package super_and_this;

public class PracticeTwo {

    static class A {
        int a = 10;
        void method() {
            System.out.println("Method from A");
        }
    }

    static class B extends A {
        // нет поля a и метода method() - наследуются от A
    }

    static class C extends B {
        void method() {
            int a = super.a;      // доступ к полю из класса A
            super.method();       // вызов метода из класса A
            System.out.println("a = " + a);
        }
    }

    public static void main(String[] args) {
        C c = new C();
        c.method();
    }
}
