package scanner_class;

import java.io.*;
import java.util.*;

public class PracticeOne {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(new File("src/scanner_class/data.txt"));

        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            System.out.println(line);
        }

        fileScanner.close();
    }
}