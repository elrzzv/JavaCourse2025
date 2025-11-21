package static_initialization_errors;

public class PracticeOne {
    final static int START_COUNTER;
    static {
        START_COUNTER = Integer.parseInt("Y-"); // NumberFormatException
    }
    public static void main(String[] args) {
        System.out.println("Hello"); // Этот код не выполнится
    }
}
/*
Пояснение:

-При загрузке класса выполнится статический блок инициализации
-Integer.parseInt("Y-") выбросит NumberFormatException
-Исключение не будет обработано в статическом блоке
-Класс не будет загружен успешно
-Метод main не выполнится
-Программа завершится с ошибкой ExceptionInInitializerError
 */