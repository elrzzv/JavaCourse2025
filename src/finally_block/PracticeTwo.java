package finally_block;

// PracticeTwo.java
public class PracticeTwo {

    public static void main(String[] args) {
        System.out.println("try только с finally использовать можно\n");

        try {
            System.out.println("Try block executed");
            int result = 10 / 2; // нормальное выполнение
            int error = 10 / 0; // ошибка
            System.out.println("Unreachable line");
        } finally {
            System.out.println("Finally block always executed");
        }
    }
}