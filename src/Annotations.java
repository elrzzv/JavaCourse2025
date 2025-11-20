// Аннотация @Override
class Parent {
    public void display() {
        System.out.println("Parent display");
    }
}

class Child extends Parent {
    @Override
    public void display() {
        System.out.println("Child display");
    }
}

// Аннотация @Deprecated
class OldClass {
    @Deprecated
    public void oldMethod() {
        System.out.println("This method is deprecated");
    }

    @Deprecated(since = "2.0", forRemoval = true)
    public void veryOldMethod() {
        System.out.println("This method will be removed");
    }
}

public class Annotations {
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        // использование устаревшего метода с предупреждением
        OldClass old = new OldClass();
        old.oldMethod(); // вызов устаревшего метода

        Child child = new Child();
        child.display();

        System.out.println("\nОбъяснение аннотаций:");
        System.out.println("@Override - проверяет, что метод переопределяет метод суперкласса");
        System.out.println("@Deprecated - помечает устаревший код");
        System.out.println("@SuppressWarnings - подавляет предупреждения компилятора");
    }
}