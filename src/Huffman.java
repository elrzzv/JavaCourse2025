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

class HuffmanNode implements Comparable<HuffmanNode> {
    Byte character;
    int frequency;
    HuffmanNode left, right;

    public HuffmanNode(Byte character, int frequency) {
        this.character = character;
        this.frequency = frequency;
        this.left = null;
        this.right = null;
    }

    public HuffmanNode(Byte character, int frequency, HuffmanNode left, HuffmanNode right) {
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
    private Map<Byte, String> huffmanCodes = new HashMap<>();
    private Map<Byte, Integer> frequencyMap = new HashMap<>();
    private HuffmanNode root;

    public void buildHuffmanTree(byte[] data) {
        huffmanCodes.clear();
        frequencyMap.clear();

        for (byte b : data) {
            frequencyMap.put(b, frequencyMap.getOrDefault(b, 0) + 1);
        }

        System.out.println("Unique bytes: " + frequencyMap.size());

        if (frequencyMap.size() == 1) {
            Byte singleByte = frequencyMap.keySet().iterator().next();
            root = new HuffmanNode(singleByte, frequencyMap.get(singleByte));
            huffmanCodes.put(singleByte, "0");
            return;
        }

        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>();
        for (Map.Entry<Byte, Integer> entry : frequencyMap.entrySet()) {
            pq.add(new HuffmanNode(entry.getKey(), entry.getValue()));
        }

        while (pq.size() > 1) {
            HuffmanNode left = pq.poll();
            HuffmanNode right = pq.poll();
            HuffmanNode parent = new HuffmanNode(null, left.frequency + right.frequency, left, right);
            pq.add(parent);
        }

        root = pq.poll();
        generateCodes(root, "");
    }

    private void generateCodes(HuffmanNode node, String code) {
        if (node == null) return;

        if (node.isLeaf()) {
            huffmanCodes.put(node.character, code);
        }

        generateCodes(node.left, code + "0");
        generateCodes(node.right, code + "1");
    }

    public String encode(byte[] data) {
        StringBuilder encoded = new StringBuilder();
        for (byte b : data) {
            encoded.append(huffmanCodes.get(b));
        }
        System.out.println("Encoded bits: " + encoded.length());
        return encoded.toString();
    }

    public byte[] decodeToBytes(String encodedText) {
        System.out.println("Decoding bits: " + encodedText.length());

        if (root != null && root.isLeaf()) {
            Byte singleByte = root.character;
            byte[] result = new byte[encodedText.length()];
            Arrays.fill(result, singleByte);
            return result;
        }

        List<Byte> decodedBytes = new ArrayList<>();
        HuffmanNode current = root;

        for (int i = 0; i < encodedText.length(); i++) {
            char bit = encodedText.charAt(i);

            if (bit == '0') {
                current = current.left;
            } else {
                current = current.right;
            }

            if (current.isLeaf()) {
                decodedBytes.add(current.character);
                current = root;
            }
        }

        byte[] result = new byte[decodedBytes.size()];
        for (int i = 0; i < decodedBytes.size(); i++) {
            result[i] = decodedBytes.get(i);
        }

        System.out.println("Decoded bytes: " + result.length);
        return result;
    }

    private byte[] toByteArray(String bits) {
        int byteLength = (bits.length() + 7) / 8;
        byte[] result = new byte[byteLength];

        for (int i = 0; i < bits.length(); i++) {
            if (bits.charAt(i) == '1') {
                result[i / 8] |= (1 << (7 - (i % 8)));
            }
        }
        return result;
    }

    private String fromByteArray(byte[] bytes, int bitLength) {
        StringBuilder sb = new StringBuilder(bitLength);

        for (int i = 0; i < bytes.length && sb.length() < bitLength; i++) {
            byte b = bytes[i];
            int bitsToRead = Math.min(8, bitLength - sb.length());

            for (int j = 7; j >= 8 - bitsToRead; j--) {
                sb.append((b >> j) & 1);
            }
        }

        if (sb.length() != bitLength) {
            System.out.println("WARNING: Expected " + bitLength + " bits, got " + sb.length());
        }

        return sb.toString();
    }

    public void compressFile(String inputFile, String outputFile) throws IOException {

        // автоматическое добавление в папку test для тестовых файлов
        if (!inputFile.startsWith("tests/")) {
            inputFile = "tests/" + inputFile;
        }
        if (!outputFile.startsWith("tests/")) {
            outputFile = "tests/" + outputFile;
        }

        System.out.println("=== COMPRESSING " + inputFile + " ===");
        byte[] data = Files.readAllBytes(Paths.get(inputFile));
        System.out.println("Original size: " + data.length + " bytes");

        buildHuffmanTree(data);
        String encoded = encode(data);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outputFile))) {
            oos.writeObject(frequencyMap);
            oos.writeInt(encoded.length());

            byte[] compressed = toByteArray(encoded);
            oos.write(compressed);

            System.out.println("Compressed size: " + compressed.length + " bytes");
            System.out.println("Bit length: " + encoded.length());
        }
        System.out.println("Compression completed\n");
    }

    public void decompressFile(String inputFile, String outputFile) throws IOException, ClassNotFoundException {

        // автоматическое добавление в папку test для тестовых файлов
        if (!inputFile.startsWith("tests/")) {
            inputFile = "tests/" + inputFile;
        }
        if (!outputFile.startsWith("tests/")) {
            outputFile = "tests/" + outputFile;
        }

        System.out.println("=== DECOMPRESSING " + inputFile + " ===");

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(inputFile))) {
            // читаем словарь частот
            @SuppressWarnings("unchecked")
            Map<Byte, Integer> freq = (Map<Byte, Integer>) ois.readObject();
            System.out.println("Frequency map entries: " + freq.size());

            this.frequencyMap = freq;
            this.huffmanCodes = new HashMap<>();

            // восстанавливаем дерево
            if (freq.size() == 1) {
                Byte singleByte = freq.keySet().iterator().next();
                root = new HuffmanNode(singleByte, freq.get(singleByte));
                huffmanCodes.put(singleByte, "0");
                System.out.println("Single byte case");
            } else {
                PriorityQueue<HuffmanNode> pq = new PriorityQueue<>();
                for (Map.Entry<Byte, Integer> e : freq.entrySet()) {
                    pq.add(new HuffmanNode(e.getKey(), e.getValue()));
                }
                while (pq.size() > 1) {
                    HuffmanNode left = pq.poll();
                    HuffmanNode right = pq.poll();
                    pq.add(new HuffmanNode(null, left.frequency + right.frequency, left, right));
                }
                root = pq.poll();
                generateCodes(root, "");
                System.out.println("Codes generated: " + huffmanCodes.size());
            }

            // читаем длину битов
            int bitLength = ois.readInt();
            System.out.println("Expected bit length: " + bitLength);

            // читаем сжатые данные
            byte[] compressed = ois.readAllBytes();
            System.out.println("Compressed data bytes: " + compressed.length);

            // восстанавливаем битовую строку
            String encoded = fromByteArray(compressed, bitLength);
            System.out.println("Recovered bits: " + encoded.length());

            // декодируем
            byte[] decodedData = decodeToBytes(encoded);
            Files.write(Paths.get(outputFile), decodedData);

            System.out.println("Decompression completed. Output: " + decodedData.length + " bytes\n");
        }
    }

    public static void createTestFiles() throws IOException {
        Path testDir = Paths.get("tests");
        if (!Files.exists(testDir)) {
            Files.createDirectory(testDir);
        }

        Files.write(Paths.get("tests/test1.txt"), "1111111111".getBytes());
        Files.write(Paths.get("tests/test2.txt"), "11111111112222233333".getBytes());

        Path test3 = Paths.get("tests/test3.class");
        if (Files.exists(test3)) {
            Files.delete(test3);
        }
        Files.copy(Paths.get("Huffman.class"), test3);

        System.out.println("Test files created in /test directory");
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Huffman Coding - Fixed Version");
            System.out.println("Usage:");
            System.out.println("  java Huffman -c input output.huff");
            System.out.println("  java Huffman -d input.huff output");
            System.out.println("  java Huffman -test");
            return;
        }

        Huffman huffman = new Huffman();

        try {
            if (args[0].equals("-c")) {
                if (args.length != 3) {
                    System.out.println("Usage: java Huffman -c input output.huff");
                    return;
                }
                huffman.compressFile(args[1], args[2]);
            } else if (args[0].equals("-d")) {
                if (args.length != 3) {
                    System.out.println("Usage: java Huffman -d input.huff output");
                    return;
                }
                huffman.decompressFile(args[1], args[2]);
            } else if (args[0].equals("-test")) {
                createTestFiles();
            } else {
                System.out.println("Unknown command");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}