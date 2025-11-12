public class VarArgsMethods {

    public static void printAll(String... strings) {
        System.out.print("Strings: ");
        for (String s : strings) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    public static void printAll(int... numbers) {
        System.out.print("Integers: ");
        for (int n : numbers) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    public static void printAll(double... numbers) {
        System.out.print("Doubles: ");
        for (double n : numbers) {
            System.out.print(n + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {

        printAll("Hello", "World", "Java");
        printAll(1, 2, 3, 4, 5);
        printAll(1.1, 2.2, 3.3);

    }
}