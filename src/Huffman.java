import java.util.*;
import java.util.PriorityQueue;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

//узел дерева
class HuffmanNode implements Comparable<HuffmanNode> {
    char character;
    int frequency;
    HuffmanNode left, right;

    public HuffmanNode(char character, int frequency) {
        this.character = character;
        this.frequency = frequency;
        this.left = null;
        this.right = null;
    }

    public HuffmanNode(char character, int frequency, HuffmanNode left, HuffmanNode right) {
        this.character = character;
        this.frequency = frequency;
        this.left = left;
        this.right = right;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }

    @Override
    public int compareTo(HuffmanNode other) {
        return this.frequency - other.frequency;
    }
}

public class Huffman {
    private final Map<Character, String> huffmanCodes = new HashMap<Character, String>();
    private final Map<Character, Integer> frequencyMap = new HashMap<Character, Integer>();
    private HuffmanNode root;

    //дерево
    public void buildHuffmanTree(byte[] data) {
        huffmanCodes.clear();
        frequencyMap.clear();
        //считаем частоты для байтов
        for (byte b : data) {
            char c = (char) (b & 0xFF); // Преобразуем byte в char (0-255)
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        if (frequencyMap.size() == 1) {
            char singleChar = frequencyMap.keySet().iterator().next();
            root = new HuffmanNode(singleChar, frequencyMap.get(singleChar));
            huffmanCodes.put(singleChar, "0");
            return;
        }

        //приоритетная очередь
        PriorityQueue<HuffmanNode> pq = new PriorityQueue<HuffmanNode>();
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            pq.add(new HuffmanNode(entry.getKey(), entry.getValue()));
        }

        //строим дерево
        while (pq.size() > 1) {
            HuffmanNode left = pq.poll();
            HuffmanNode right = pq.poll();

            HuffmanNode parent = new HuffmanNode('\0',
                    left.frequency + right.frequency, left, right);
            pq.add(parent);
        }

        root = pq.poll();
        generateCodes(root, "");
    }

    //генерим коды
    private void generateCodes(HuffmanNode node, String code) {
        if (node == null) return;

        if (node.isLeaf()) {
            huffmanCodes.put(node.character, code);
        }

        generateCodes(node.left, code + "0");
        generateCodes(node.right, code + "1");
    }

    //кодирование
    public String encode(byte[] data) {
        StringBuilder encoded = new StringBuilder();
        for (byte b : data) {
            char c = (char) (b & 0xFF);
            encoded.append(huffmanCodes.get(c));
        }
        return encoded.toString();
    }

    //декодирование
    public String decode(String encodedText) {
        //особый случай 1 символ
        if (root != null && root.isLeaf()) {
            char singleChar = root.character;
            StringBuilder decoded = new StringBuilder();
            for (int i = 0; i < encodedText.length(); i++) {
                decoded.append(singleChar);
            }
            return decoded.toString();
        }

        StringBuilder decoded = new StringBuilder();
        HuffmanNode current = root;

        for (char bit : encodedText.toCharArray()) {
            if (bit == '0') {
                current = current.left;
            } else {
                current = current.right;
            }

            if (current.isLeaf()) {
                decoded.append(current.character);
                current = root;
            }
        }

        return decoded.toString();
    }

    public byte[] decodeToBytes(String encodedText) {
        String decodedString = decode(encodedText);
        byte[] result = new byte[decodedString.length()];
        for (int i = 0; i < decodedString.length(); i++) {
            result[i] = (byte) decodedString.charAt(i);
        }
        return result;
    }

    //сжатие файла
    public void compressFile(String inputFile, String outputFile) throws IOException {
        // читаем текст как байты
        byte[] data = Files.readAllBytes(Paths.get(inputFile));

        // строим дерево
        buildHuffmanTree(data);

        // кодируем
        String encoded = encode(data);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outputFile))) {
            // сохраняем частоты (чтобы восстановить дерево)
            oos.writeObject(frequencyMap);

            // сохраняем длину битовой строки
            oos.writeInt(encoded.length());

            // сохраняем сжатые данные (как байты)
            byte[] compressed = toByteArray(encoded);
            oos.write(compressed);
        }
    }

    //распаковка файла
    public void decompressFile(String inputFile, String outputFile) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(inputFile))) {
            @SuppressWarnings("unchecked")
            Map<Character, Integer> freq = (Map<Character, Integer>) ois.readObject();
            this.frequencyMap.clear();
            this.frequencyMap.putAll(freq);

            // особый случай один символ
            if (freq.size() == 1) {
                char singleChar = freq.keySet().iterator().next();
                root = new HuffmanNode(singleChar, freq.get(singleChar));
                huffmanCodes.put(singleChar, "0");
            } else {
                // обычный случай
                PriorityQueue<HuffmanNode> pq = new PriorityQueue<HuffmanNode>();
                for (Map.Entry<Character, Integer> e : freq.entrySet()) {
                    pq.add(new HuffmanNode(e.getKey(), e.getValue()));
                }
                while (pq.size() > 1) {
                    HuffmanNode left = pq.poll();
                    HuffmanNode right = pq.poll();
                    pq.add(new HuffmanNode('\0', left.frequency + right.frequency, left, right));
                }
                root = pq.poll();
                generateCodes(root, "");
            }

            // количество битов
            int bitLength = ois.readInt();

            // читаем оставшиеся байты
            byte[] compressed = new byte[ois.available()];
            ois.readFully(compressed);

            // восстанавливаем битовую строку с точной длиной
            String encoded = fromByteArray(compressed, bitLength);
            byte[] decodedData = decodeToBytes(encoded);

            Files.write(Paths.get(outputFile), decodedData);
        }
    }

    // побитовая упаковка строки "010101..."
    private byte[] toByteArray(String bits) {
        int byteLength = (bits.length() + 7) / 8;
        byte[] result = new byte[byteLength];
        for (int i = 0; i < bits.length(); i++) {
            if (bits.charAt(i) == '1') {
                result[i / 8] |= 1 << (7 - (i % 8));
            }
        }
        return result;
    }

    private String fromByteArray(byte[] bytes, int bitLength) {
        StringBuilder sb = new StringBuilder();
        int bitsProcessed = 0;

        for (byte b : bytes) {
            for (int i = 7; i >= 0; i--) {
                if (bitsProcessed < bitLength) {
                    sb.append((b >> i) & 1);
                    bitsProcessed++;
                } else {
                    break;
                }
            }
            if (bitsProcessed >= bitLength) break;
        }
        return sb.toString();
    }

    //создание тестовых файлов
    public static void createTestFiles() throws IOException {
        // Файл 1: 10 одинаковых символов
        Files.write(Paths.get("test1.txt"), "1111111111".getBytes());

        // Файл 2: 20 байт, 3 символа (10,5,5)
        Files.write(Paths.get("test2.txt"), "11111111112222233333".getBytes());

        System.out.println("Test files created:");
        System.out.println("- test1.txt (10 identical characters)");
        System.out.println("- test2.txt (3 different characters)");
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Huffman Coding - Command Line Tool");
            System.out.println("Usage:");
            System.out.println("  java Huffman -c input.txt output.huff    # Compress");
            System.out.println("  java Huffman -d input.huff output.txt    # Decompress");
            System.out.println("  java Huffman -test                       # Create test files");
            return;
        }

        Huffman huffman = new Huffman();

        try {
            if (args[0].equals("-c") || args[0].equals("--compress")) {
                if (args.length != 3) {
                    System.out.println("Usage: java Huffman -c input.txt output.huff");
                    return;
                }
                huffman.compressFile(args[1], args[2]);
                System.out.println("File compressed: " + args[1] + " -> " + args[2]);
            } else if (args[0].equals("-d") || args[0].equals("--decompress")) {
                if (args.length != 3) {
                    System.out.println("Usage: java Huffman -d input.huff output.txt");
                    return;
                }
                huffman.decompressFile(args[1], args[2]);
                System.out.println("File decompressed: " + args[1] + " -> " + args[2]);
            } else if (args[0].equals("-test") || args[0].equals("--test")) {
                createTestFiles();
            } else {
                System.out.println("Unknown command: " + args[0]);
                System.out.println("Use -c to compress, -d to decompress, -test to create test files");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}