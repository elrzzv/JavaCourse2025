// PracticeOne.java
public class OverridingStaticMethods {

    static class A {
        public static void staticMethod() {
            System.out.println("Static method from A");
        }

        public void instanceMethod() {
            System.out.println("Instance method from A");
        }
    }

    static class B extends A {
        // Это не переопределение, а hiding (сокрытие)
        public static void staticMethod() {
            System.out.println("Static method from B");
        }

        @Override
        public void instanceMethod() {
            System.out.println("Instance method from B");
        }
    }

    public static void main(String[] args) {
        A a = new B();

        // Статический метод - связывание на этапе компиляции
        a.staticMethod();  // "Static method from A" (по типу ссылки A)

        // Нестатический метод - связывание на этапе выполнения  
        a.instanceMethod(); // "Instance method from B" (по типу объекта B)

        System.out.println("\nОбъяснение:");
        System.out.println("Статические методы связаны с классом, а не с объектом");
        System.out.println("Выбор статического метода определяется типом ссылки");
        System.out.println("Выбор нестатического метода определяется типом объекта");
        System.out.println("Поэтому полиморфизм работает только для нестатических методов");
    }
}