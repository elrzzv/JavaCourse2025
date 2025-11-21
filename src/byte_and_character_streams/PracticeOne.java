package byte_and_character_streams;

import java.io.*;

public class PracticeOne {
    public static void main(String[] args) throws IOException {
        byte[] data = {72, 101, 108, 108, 111}; // "Hello" в байтах
        InputStream input = new ByteArrayInputStream(data);

        int byteRead;
        while ((byteRead = input.read()) != -1) {
            System.out.print((char) byteRead + "(" + byteRead + ") ");
        }
        input.close();
    }
}