interface MyInterface {
    // вложенный класс в интерфейсе (неявно static)
    class NestedClass {
        public void printMessage() {
            System.out.println("Message from nested class in interface");
        }

        public static void staticMethod() {
            System.out.println("Static method in nested class");
        }
    }

    void interfaceMethod(); // метод интерфейса
}

public class NestedClasses {
    public static void main(String[] args) {
        // создание объекта вложенного класса без реализации интерфейса
        MyInterface.NestedClass nested = new MyInterface.NestedClass();
        nested.printMessage();

        // вызов статического метода вложенного класса
        MyInterface.NestedClass.staticMethod();

        // реализация интерфейса с использованием вложенного класса
        MyInterface impl = new MyInterface() {
            @Override
            public void interfaceMethod() {
                System.out.println("Interface method implementation");
            }
        };
        impl.interfaceMethod();
    }
}