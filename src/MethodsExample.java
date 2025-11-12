public class MethodsExample {

    static class Animal {
        public void sound() {
            System.out.println("Animal makes sound");
        }

        // Overloading
        public void sound(int volume) {
            System.out.println("Animal sound volume: " + volume);
        }
    }

    static class Dog extends Animal {
        // Overriding
        @Override
        public void sound() {
            System.out.println("Dog barks");
        }
    }

    public static void main(String[] args) {
        Animal animal = new Animal();
        Animal dog = new Dog();

        // Overloading
        animal.sound();
        animal.sound(5);

        // Overriding
        dog.sound();
    }
}