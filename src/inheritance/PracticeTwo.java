package inheritance;

public class PracticeTwo {

    static class A {
        int a1;              // default - доступ в том же пакете
        public int a2;       // public - доступ везде
        protected int a3;    // protected - доступ в пакете + подклассы
        private int a4;      // private - доступ только в A

        void method1() { }        // default - доступ в пакете
        public void method2() { } // public - доступ везде
        protected void method3() { } // protected - доступ в пакете + подклассы
        private void method4() { }   // private - доступ только в A
    }

    static class B extends A {
        void testAccess() {
            System.out.println("class B");
            a1 = 1;    // доступно (тот же пакет)
            a2 = 2;    // доступно (public)
            a3 = 3;    // доступно (protected + подкласс)
            // a4 = 4; // ошибка: private недоступно

            method1(); // доступно (тот же пакет)
            method2(); // доступно (public)
            method3(); // доступно (protected + подкласс)
            // method4(); // ошибка: private недоступно
        }
    }

    static class C extends B {
        void testAccess() {
            System.out.println("class C");
            a1 = 1;    // доступно (тот же пакет)
            a2 = 2;    // доступно (public)
            a3 = 3;    // доступно (protected + подкласс)
            // a4 = 4; // ошибка: private недоступно

            method1(); // доступно (тот же пакет)
            method2(); // доступно (public)
            method3(); // доступно (protected + подкласс)
            // method4(); // ошибка: private недоступно
        }
    }

    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();

        b.testAccess();
        c.testAccess();
    }
}
