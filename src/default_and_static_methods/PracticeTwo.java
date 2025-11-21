package default_and_static_methods;

interface InterfaceA {
    default void conflictMethod() {
        System.out.println("Default method from InterfaceA");
    }
}

interface InterfaceB {
    default void conflictMethod() {
        System.out.println("Default method from InterfaceB");
    }
}

class MyClass2 implements InterfaceA, InterfaceB {
    // ошибка компиляции: конфликт default методов
    // необходимо явно переопределить метод

    @Override
    public void conflictMethod() {
        // можно выбрать одну из реализаций
        InterfaceA.super.conflictMethod();
        // или
        // InterfaceB.super.conflictMethod(); // вызов метода из InterfaceB

        // или
        // собственная реализация
        System.out.println("Resolved conflict in MyClass2");
    }
}

public class PracticeTwo {
    public static void main(String[] args) {
        MyClass2 obj = new MyClass2();
        obj.conflictMethod();

        System.out.println("\nРешение конфликта default методов:");
        System.out.println("1. Обязательно переопределить метод в классе");
        System.out.println("2. Можно вызвать конкретную реализацию через InterfaceName.super.methodName()");
        System.out.println("3. Или предоставить собственную реализацию");
    }
}