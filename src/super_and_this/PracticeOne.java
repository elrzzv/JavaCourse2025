package super_and_this;

public class PracticeOne {

    static class A {
        String field = "field from A";

        A() {
            System.out.println("Constructor A");
        }

        void method() {
            System.out.println("Method from A");
        }
    }

    static class B extends A {
        String field = "field from B";

        B() {
            super(); // 1. обращение к конструктору суперкласса
            System.out.println("Constructor B");
        }

        void printFields() {
            System.out.println(super.field); // 2. доступ к полю суперкласса
            System.out.println(this.field);   // доступ к полю текущего класса
        }

        void callMethods() {
            super.method(); // 3. доступ к методу суперкласса
            this.method();
        }

        void method() {
            System.out.println("Method from B");
        }
    }

    public static void main(String[] args) {
        B b = new B();
        b.printFields();
        b.callMethods();
    }
}