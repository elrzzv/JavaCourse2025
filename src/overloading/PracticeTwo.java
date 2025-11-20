package overloading;

public class PracticeTwo {

    static class Animal {
        public String makeSound() {
            return "Animal sound";
        }
    }

    static class Dog extends Animal {
        @Override
        public String makeSound() {
            return "Woof";
        }

        // ошибка компиляции: тип возвращаемого значения должен совпадать
        // @Override
        // public int makeSound() {
        //     return 1;
        // }
    }

    public static void main(String[] args) {
        Animal dog = new Dog();
        System.out.println(dog.makeSound()); // Woof
    }
}