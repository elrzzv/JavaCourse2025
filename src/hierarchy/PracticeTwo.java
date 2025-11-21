package hierarchy;

public class PracticeTwo {

    // ArithmeticException - арифметическая ошибка
    static void divideByZero() {
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException: " + e.getMessage());
        }
    }

    // ArrayIndexOutOfBoundsException - выход за границы массива
    static void arrayAccess() {
        try {
            int[] arr = {1, 2, 3};
            System.out.println(arr[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException: " + e.getMessage());
        }
    }

    // IllegalArgumentException - неверный аргумент
    static void setAge(int age) {
        try {
            if (age < 0 || age > 150) {
                throw new IllegalArgumentException("Invalid age: " + age);
            }
            System.out.println("Age set to: " + age);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: " + e.getMessage());
        }
    }

    // ClassCastException - неверное приведение типов
    static void typeCast() {
        try {
            Object obj = "Hello";
            Integer num = (Integer) obj;
        } catch (ClassCastException e) {
            System.out.println("ClassCastException: " + e.getMessage());
        }
    }

    // NullPointerException - обращение к null
    static void nullAccess() {
        try {
            String str = null;
            System.out.println(str.length());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        divideByZero();
        arrayAccess();
        setAge(-5);
        typeCast();
        nullAccess();
    }
}