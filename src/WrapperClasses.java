public class WrapperClasses {
    public static void main(String[] args) {
        // Практика #1 - Метод decode()
        System.out.println("=== Практика #1 - decode() ===");
        Integer hex = Integer.decode("0x10");     // 16 в десятичной
        Integer octal = Integer.decode("012");    // 10 в десятичной
        Integer decimal = Integer.decode("42");   // 42 в десятичной
        System.out.println("decode('0x10') = " + hex);
        System.out.println("decode('012') = " + octal);
        System.out.println("decode('42') = " + decimal);


        // Практика #2 - Boolean
        System.out.println("\n=== Практика #2 - Создание Boolean ===");
        Boolean bool1 = Boolean.valueOf(true);
        Boolean bool2 = Boolean.valueOf("true");
        Boolean bool3 = Boolean.valueOf("TRUE");
        Boolean bool4 = Boolean.valueOf("false");
        Boolean bool5 = Boolean.TRUE; // константа
        System.out.println("valueOf(true): " + bool1);
        System.out.println("valueOf('true'): " + bool2);
        System.out.println("valueOf('TRUE'): " + bool3);
        System.out.println("valueOf('false'): " + bool4);
        System.out.println("Boolean.TRUE: " + bool5);


        // Практика #3 - NullPointerException
        System.out.println("\n=== Практика #3 - NullPointerException ===");
        Integer nullInteger = null;
        try {
            int unboxed = nullInteger; // автораспаковка null -> NPE
        } catch (NullPointerException e) {
            System.out.println("NullPointerException при автораспаковке: " + e.getMessage());
        }


        // Практика #4 - Сравнение Integer
        System.out.println("\n=== Практика #4 - Сравнение Integer ===");
        int i1 = 128;
        Integer a1 = i1;
        Integer b1 = i1;
        System.out.println("a1==i1 " + (a1 == i1));           // true - автораспаковка
        System.out.println("b1==i1 " + (b1 == i1));           // true - автораспаковка
        System.out.println("a1==b1 " + (a1 == b1));           // false - разные объекты
        System.out.println("a1.equals(i1) -> " + a1.equals(i1)); // true
        System.out.println("b1.equals(i1) -> " + b1.equals(i1)); // true
        System.out.println("a1.equals(b1) -> " + a1.equals(b1)); // true

        int i2 = 127;
        Integer a2 = i2;
        Integer b2 = i2;
        System.out.println("a2==i2 " + (a2 == i2));           // true - автораспаковка
        System.out.println("b2==i2 " + (b2 == i2));           // true - автораспаковка
        System.out.println("a2==b2 " + (a2 == b2));           // true - кэширование
        System.out.println("a2.equals(i2) -> " + a2.equals(i2)); // true
        System.out.println("b2.equals(i2) -> " + b2.equals(i2)); // true
        System.out.println("a2.equals(b2) -> " + a2.equals(b2)); // true

        System.out.println("\nОбъяснение:");
        System.out.println("- == с int: происходит автораспаковка, сравниваются значения");
        System.out.println("- == с Integer: сравниваются ссылки на объекты");
        System.out.println("- IntegerCache кэширует значения от -128 до 127");
        System.out.println("- 127 берется из кэша (один объект), 128 создается новый объект");
    }
}