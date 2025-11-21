package multiple_exceptions;

public class PracticeOne {

    static class Ex1 extends Exception {}
    static class Ex2 extends Ex1 {}
    static class Ex3 extends Ex2 {}

    public static void main(String[] args) {
        // 1. Обработка нескольких исключений одинаковым образом
        try {
            int[] arr = {1, 2, 3};
            System.out.println(arr[5]); // ArrayIndexOutOfBoundsException
            // String str = null;
            // str.length(); // NullPointerException
        } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
            System.out.println("Одинаковая обработка: " + e.getClass().getSimpleName());
        }

        // 2. Исключения в иерархии
        try {
            throw new Ex3(); // Бросаем самое конкретное исключение
        } catch (Ex3 e) {
            System.out.println("Поймали Ex3");
        } catch (Ex2 e) {
            System.out.println("Поймали Ex2");
        } catch (Ex1 e) {
            System.out.println("Поймали Ex1");
        }

        // неверно: исключения из одной иерархии
        // try {
        //     throw new Ex3();
        // } catch (Ex1 | Ex2 | Ex3 e) { // ОШИБКА: Ex2 и Ex3 подклассы Ex1
        //     System.out.println("Нельзя так делать");
        // }
    }
}