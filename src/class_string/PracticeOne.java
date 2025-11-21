package class_string;

public class PracticeOne {
    public static void main(String[] args) {
        String str = "  Hello World!  ";

        // 1. length() - возвращает длину строки
        System.out.println("1. length(): " + str.length());

        // 2. trim() - удаляет пробелы в начале и конце
        System.out.println("2. trim(): '" + str.trim() + "'");

        // 3. toUpperCase() - преобразует в верхний регистр
        System.out.println("3. toUpperCase(): " + str.toUpperCase());

        // 4. toLowerCase() - преобразует в нижний регистр
        System.out.println("4. toLowerCase(): " + str.toLowerCase());

        // 5. substring() - возвращает подстроку
        System.out.println("5. substring(7, 11): " + str.substring(7, 11));

        // 6. replace() - заменяет символы
        System.out.println("6. replace('l', 'X'): " + str.replace('l', 'X'));

        // 7. contains() - проверяет наличие подстроки
        System.out.println("7. contains('Hello'): " + str.contains("Hello"));

        // 8. split() - разделяет строку на массив
        String[] parts = str.trim().split(" ");
        System.out.println("8. split(): " + String.join(", ", parts));

        // 9. startsWith() - проверяет начало строки
        System.out.println("9. startsWith('  Hello'): " + str.startsWith("  Hello"));

        // 10. charAt() - возвращает символ по индексу
        System.out.println("10. charAt(1): " + str.charAt(1));
    }
}