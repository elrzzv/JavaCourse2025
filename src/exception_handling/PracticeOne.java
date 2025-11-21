package exception_handling;

public class PracticeOne {

    static void methodWithHandledException() {
        try {
            int result = 10 / 0; // ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Исключение перехвачено: " + e.getMessage());
        }
    }

    static void methodWithUnhandledException() {
        String str = null;
        System.out.println(str.length()); // NullPointerException - не перехвачено
    }

    public static void main(String[] args) {
        System.out.println("Начало программы");

        // Это исключение будет перехвачено
        methodWithHandledException();
        System.out.println("Программа продолжает работу после перехваченного исключения");

        // Это исключение не будет перехвачено - аварийная остановка
        methodWithUnhandledException();

        System.out.println("Этот код не выполнится");
    }
}