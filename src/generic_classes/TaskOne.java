package generic_classes;

public class TaskOne {
    static class Box<T> {
        private T value;
    }

    public static void main(String[] args) {
        Box<String> stringBox = new Box<>();
        System.out.println("stringBox instanceof Box: " + (stringBox instanceof Box));
    }
}