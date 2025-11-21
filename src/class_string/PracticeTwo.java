package class_string;

import java.util.StringJoiner;

public class PracticeTwo {
    public static void main(String[] args) {
        // StringJoiner для объединения строк с разделителем
        StringJoiner sj1 = new StringJoiner(", ");
        sj1.add("Apple");
        sj1.add("Banana");
        sj1.add("Orange");
        System.out.println("Fruits: " + sj1.toString());

        // StringJoiner с префиксом и суффиксом
        StringJoiner sj2 = new StringJoiner(" - ", "[ ", " ]");
        sj2.add("One");
        sj2.add("Two");
        sj2.add("Three");
        System.out.println("Numbers: " + sj2.toString());

        // Объединение StringJoiner
        StringJoiner sj3 = new StringJoiner(" | ");
        sj3.merge(sj1);
        sj3.merge(sj2);
        System.out.println("Merged: " + sj3.toString());
    }
}