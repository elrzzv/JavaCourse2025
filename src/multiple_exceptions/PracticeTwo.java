package multiple_exceptions;

// PracticeTwo.java
public class PracticeTwo {

    public static void main(String[] args) {
        try {
            int result = 10 / 0;
        } catch (final ArithmeticException e) {
            // final означает, что ссылку e нельзя переназначить
            // e = new ArithmeticException(); // ошибка: нельзя изменить final переменную
            System.out.println("Исключение: " + e.getMessage());
        }


        System.out.println("\nfinal в catch:");
        System.out.println("Предотвращает лучайное переназначение переменной исключения");
        System.out.println("Улучшает читаемость кода");
        System.out.println("Показывает, что переменная не должна меняться");
    }
}