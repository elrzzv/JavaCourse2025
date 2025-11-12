public class FinalModifier {

    public static class A{
        // Вариант 1: Инициализация при объявлении
        public final int a = 10;

        // Вариант 2: Инициализация в конструкторе
        public final int b;

        public A(int value) {
            this.b = value;
        }
    }

    public static void main(String[] args) {
        A obj1 = new A(20);
        System.out.println("a = " + obj1.a);
        System.out.println("b = " + obj1.b);
    }
}