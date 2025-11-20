package final_classes_methods;

public class PracticeOne {

    static class Parent {
        public final void finalMethod() {
            System.out.println("Это final метод");
        }
    }

    static class Child extends Parent {

        // ошибка компиляции: нельзя переопределить final метод
        // public void finalMethod() {
        //     System.out.println("Попытка переопределения");
        // }
    }

    public static void main(String[] args) {
        Child c = new Child();
        c.finalMethod();
    }
}
