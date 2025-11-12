public class Cycles {
    public static void main(String[] args) {
        // Практика #1 - Бесконечные циклы

        // Бесконечный while
        /*
        while (true) {
            System.out.println("Бесконечный while");
        }
        */

        // Бесконечный do-while
        /*
        do {
            System.out.println("Бесконечный do-while");
        } while (true);
        */




        // Практика #2 - break и continue

        System.out.println("Пример с break и continue:");
        for (int i = 0; i < 10; i++) {
            if (i == 2) {
                continue; // пропускаем итерацию когда i = 2
            }
            if (i == 7) {
                break; // выходим из цикла когда i = 7
            }
            System.out.println("i = " + i);
        }
    }
}