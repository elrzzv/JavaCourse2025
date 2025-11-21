package hierarchy;

public class PracticeOne {
    public static void main(String[] args) {
        // Error - системные ошибки (не обрабатываются)
        // throw new OutOfMemoryError(); // Ошибка памяти
        // throw new StackOverflowError(); // Переполнение стека

        // Exception - проверяемые исключения (требуют обработки)
        try {
            // throw new IOException(); // Ошибка ввода-вывода
            // throw new SQLException(); // Ошибка базы данных
        } catch (Exception e) {
            System.out.println("Checked exception handled");
        }

        // RuntimeException - непроверяемые исключения
        // throw new NullPointerException(); // Можно не обрабатывать
        // throw new IllegalArgumentException(); // Неверный аргумент
        // throw new ArrayIndexOutOfBoundsException(); // Выход за границы массива



        System.out.println("Иерархия исключений:");
        System.out.println("Throwable - базовый класс для всех исключений и ошибок");
        System.out.println("Error - системные ошибки (OutOfMemoryError, StackOverflowError)");
        System.out.println("Exception - проверяемые исключения (IOException, SQLException)");
        System.out.println("RuntimeException - непроверяемые исключения (NPE, ArrayIndexOutOfBounds)");
    }
}
