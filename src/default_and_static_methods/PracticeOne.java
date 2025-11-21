package default_and_static_methods;


interface MyInterface {
    static void staticMethod() {
        System.out.println("Static method in interface");
    }

    default void defaultMethod() {
        System.out.println("Default method in interface");
    }

}

class MyClass implements MyInterface {
    // можно переопределить default метод
    @Override
    public void defaultMethod() {
        System.out.println("Overridden default method");
    }
}

public class PracticeOne {
    public static void main(String[] args) {
        MyClass obj = new MyClass();

        // переопределенный default метод
        obj.defaultMethod();

        // вызов статического метода через интерфейс
        MyInterface.staticMethod();

        // Вызов default метода через интерфейс
        MyInterface inter = obj;
        inter.defaultMethod();
    }
}
