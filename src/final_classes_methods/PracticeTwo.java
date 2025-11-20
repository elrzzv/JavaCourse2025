package final_classes_methods;

public class PracticeTwo {

    static final class FinalClass {
        public void method() {
            System.out.println("Метод final класса");
        }
    }

    // ошибка компиляции: нельзя наследовать от final класса
    // class ChildClass extends FinalClass {
    // }

    public static void main(String[] args) {
        FinalClass a = new FinalClass();
        a.method();
    }
}