package custom_exceptions;

class CustomException extends Exception {
    public CustomException() {
        super();
    }

    public CustomException(String message) {
        super(message);
    }

    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }
}

public class PracticeOne {

    static void validateAge(int age) throws CustomException {
        if (age < 0 || age > 150) {
            throw new CustomException("Invalid age: " + age);
        }
        System.out.println("Age is valid: " + age);
    }

    public static void main(String[] args) {
        try {
            validateAge(25);  // нормальный случай
            validateAge(200); // выбросит исключение
        } catch (CustomException e) {
            System.out.println("Caught custom exception: " + e.getMessage());
        }
    }
}