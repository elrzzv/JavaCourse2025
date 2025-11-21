package formatting_information;

import java.io.*;

public class PracticeTwo {
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("test.txt");
            writer.write("First line\n");

            // flush() принудительно записывает буферизованные данные
            writer.flush();
            System.out.println("Данные записаны в файл после flush()");

            writer.write("Second line\n");
            writer.close(); // close() автоматически вызывает flush()

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\nМетод flush() нужен для:");
        System.out.println("- Принудительной записи буферизованных данных");
        System.out.println("- Обеспечения актуальности данных в потоке вывода");
        System.out.println("- Предотвращения потери данных при сбоях");
    }
}