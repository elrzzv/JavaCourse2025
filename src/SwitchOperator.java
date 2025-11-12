public class SwitchOperator {
    public static void main(String[] args) {
        // Практика #1 - Типы переменных в switch

        // byte
        byte byteValue = 1;
        switch(byteValue) {
            case 1: System.out.println("byte case"); break;
        }

        // short
        short shortValue = 2;
        switch(shortValue) {
            case 2: System.out.println("short case"); break;
        }

        // int
        int intValue = 3;
        switch(intValue) {
            case 3: System.out.println("int case"); break;
        }

        // char
        char charValue = 'A';
        switch(charValue) {
            case 'A': System.out.println("char case"); break;
        }

        // String
        String stringValue = "hello";
        switch(stringValue) {
            case "hello": System.out.println("String case"); break;
        }

        // enum
        Color color = Color.RED;
        switch(color) {
            case RED: System.out.println("enum case"); break;
        }

        // Byte (автораспаковка)
        Byte byteObj = 5;
        switch(byteObj) {
            case 5: System.out.println("Byte case"); break;
        }




        // Практика #2 - Отсутствие break
        System.out.println("\nПрактика #2 - Отсутствие break:");
        int value = 2;
        int i = 0;

        switch(value) {
            case 1:
                i = 1;
                break;
            case 2:
                i = 2;  // нет break - выполнение перейдет к следующему case (т.е. case 3)
            case 3:
                i = 3;  // это тоже выполнится для value = 2
                break;
        }
        System.out.println("При value = 2, i = " + i); // Выведет 3
    }

    enum Color {
        RED, GREEN, BLUE
    }
}