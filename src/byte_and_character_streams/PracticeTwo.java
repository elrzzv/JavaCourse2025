package byte_and_character_streams;

import java.io.*;

public class PracticeTwo {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] data = {87, 111, 114, 108, 100}; // "World" в байтах

        for (byte b : data) {
            output.write(b); // запись одного байта
        }

        System.out.println("Written: " + output.toString());
        output.close();
    }
}