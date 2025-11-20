package overloading;

// PracticeThree.java
public class PracticeThree {

    static class Parent {
        public void display() {
            System.out.println("Parent display");
        }
    }

    static class Child extends Parent {
        @Override
        public void display() {
            System.out.println("Child display");
        }

        // ошибка компиляции: @Override обнаруживает, что метода display(int) нет в Parent
        // @Override
        // public void display(int x) {
        //     System.out.println("Wrong override");
        // }
    }

    public static void main(String[] args) {
        Parent child = new Child();
        Parent parent = new Parent();
        child.display();
        parent.display();

        System.out.println("\n@Override помогает обнаружить ошибки при:");
        System.out.println("- опечатке в имени метода");
        System.out.println("- несовпадении параметров");
        System.out.println("- несовпадении типа возвращаемого значения");
    }
}