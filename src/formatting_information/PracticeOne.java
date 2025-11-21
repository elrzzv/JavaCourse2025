package formatting_information;

public class PracticeOne {
    public static void main(String[] args) {
        // Примеры использования спецификаторов форматирования

        // 1. %s - строковое представление
        System.out.printf("1. String: %s%n", "Hello World");

        // 2. %d - десятичное целое
        System.out.printf("2. Integer: %d%n", 42);

        // 3. %f - десятичное с плавающей точкой
        System.out.printf("3. Float: %.2f%n", 3.14159);

        // 4. %b - логическое значение
        System.out.printf("4. Boolean: %b%n", true);

        // 5. %c - символьное представление
        System.out.printf("5. Character: %c%n", 'A');
    }
}