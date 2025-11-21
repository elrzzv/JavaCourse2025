package byte_and_character_streams;

// PracticeThree.java
import java.io.*;

public class PracticeThree {
    public static void main(String[] args) throws IOException {

        // InputStream/OutputStream - работают с байтами
        byte[] bytes = {65, 66, 67}; // ABC
        InputStream is = new ByteArrayInputStream(bytes);
        System.out.print("InputStream bytes: ");
        int b;
        while ((b = is.read()) != -1) {
            System.out.print(b + " ");
        }
        System.out.println();
        is.close();

        // Reader/Writer - работают с символами
        String text = "ABC";
        Reader reader = new StringReader(text);
        System.out.print("Reader chars: ");
        int c;
        while ((c = reader.read()) != -1) {
            System.out.print((char)c + " ");
        }
        System.out.println();
        reader.close();

        System.out.println("Reader/Writer обрабатывают Unicode символы правильно");


        String explanation = """
                \n\nReader/Writer vs InputStream/OutputStream:
                InputStream/OutputStream - работают с байтами (8-bit)
                Reader/Writer - работают с символами (16-bit Unicode)
                Reader/Writer обеспечивают правильную обработку текста:
                -Кодировки символов
                -Международные символы
                -Преобразование байт-символ
                """;
        System.out.println(explanation);
    }
}