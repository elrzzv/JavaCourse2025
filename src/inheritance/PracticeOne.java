package inheritance;

public class PracticeOne {

    class Parent {
        String name = "Parent";

        void printName() {
            System.out.println("Name: " + name);
        }
    }

    class Child extends Parent {
        String name = "Child";

        void printName() {
            // this - ссылка на текущий объект (подкласс)
            System.out.println("this.name: " + this.name);
            // super - ссылка на родительский класс
            System.out.println("super.name: " + super.name);

            // Вызов метода родителя
            super.printName();
        }
    }

    public static void main(String[] args) {
        PracticeOne practice = new PracticeOne();
        Child child = practice.new Child();
        child.printName();
    }
}