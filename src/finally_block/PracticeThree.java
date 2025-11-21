package finally_block;

public class PracticeThree {

    public static void main(String[] args) {
        System.out.println("try с двумя finally использовать нельзя");

        // try {
        //     System.out.println("Try block");
        // } finally {
        //     System.out.println("First finally");
        // } finally {
        //     System.out.println("Second finally");
        // }
        // ОШИБКА КОМПИЛЯЦИИ: несколько finally блоков
    }
}
