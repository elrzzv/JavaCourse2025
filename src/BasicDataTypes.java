public class BasicDataTypes {
    public static void main(String[] args) {

        // Практика №1 - Примеры всех типов данных
        // byte
        byte byteZero = 0;
        byte byteValue = 127;

        // short
        short shortZero = 0;
        short shortValue = 32767;

        // int
        int intZero = 0;
        int intValue = 2147483647;

        // long
        long longZero = 0L;
        long longValue = 9223372036854775807L;

        // float
        float floatZero = 0.0f;
        float floatValue = 3.14f;

        // double
        double doubleZero = 0.0;
        double doubleValue = 2.71828;

        // char
        char charZero = '\u0000';
        char charValue = 'A';

        // boolean
        boolean booleanFalse = false;
        boolean booleanTrue = true;

        // String
        String stringNull = null;
        String stringValue = "Hello";



        // Практика №2 - Имя в Unicode
        System.out.println("\nName in Unicode:");
        System.out.println("\u0045\u006C\u0065\u006F\u006E\u006F\u0072\u0061"); // Eleonora


        // Практика №3 - Область видимости переменных
        int a = 1;
        {
            int b = 2;
            // b доступна только внутри этого блока
        }
        // int c = a + b; // ошибка компиляции: переменная b не видна вне блока


        // Практика №4 - Перегруженный оператор +
        String str1 = "Hello";
        String str2 = "World";
        String result1 = str1 + " " + str2;
        String result2 = "Number: " + 42;
        String result3 = "Boolean: " + true;
        String result4 = "Pi: " + 3.14;

        System.out.println("\nString concatenation:");
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);


        // Практика №5 - Арифметические операции с разными типами
        byte byteNum = 10;
        short shortNum = 100;
        int intNum = 1000;
        long longNum = 10000L;
        float floatNum = 2.5f;
        double doubleNum = 3.14;

        // byte + short -> int (автоматическое преобразование при арифметике)
        int result5 = byteNum + shortNum;

        // int + long -> long
        long result6 = intNum + longNum;

        // long + float -> float
        float result7 = longNum + floatNum;

        // float + double -> double
        double result8 = floatNum + doubleNum;

        // int + double -> double
        double result9 = intNum + doubleNum;

        System.out.println("\nMixed type operations (widening conversions):");
        System.out.println("byte(10) + short(100) = " + result5 + " (type: int)");
        System.out.println("int(1000) + long(10000) = " + result6 + " (type: long)");
        System.out.println("long(10000) + float(2.5) = " + result7 + " (type: float)");
        System.out.println("float(2.5) + double(3.14) = " + result8 + " (type: double)");
        System.out.println("int(1000) + double(3.14) = " + result9 + " (type: double)");


        // Практика №6 - Сужающее преобразование типов
        double largeDouble = 123.456;
        int fromDouble = (int)largeDouble; // дробная часть отбрасывается
        long largeLong = 300L;
        byte fromLong = (byte)largeLong; // возможна потеря данных

        System.out.println("\nNarrowing conversions:");
        System.out.println("(int)123.456 = " + fromDouble); // 123
        System.out.println("(byte)300L = " + fromLong); // 44 (300 % 256)


        // Практика №7
        int a7 = 120;
        // byte b7 = a7 + 10; // ошибка компиляции: требуется явное преобразование
        byte c7 = (byte)(a7 + 10); // 130 в диапазоне byte (-128 до 127) = -126
        // byte d7 = a7 + 1; // ошибка компиляции: требуется явное преобразование

        System.out.println("\nByte conversions:");
        System.out.println("(byte)(120 + 10) = " + c7); // -126


        // Практика №8 - type inference с var
        var name = "Elya"; //String
        var age = 25; //int
        var salary = 50000.0; //double
        var firstLetterInName = 'E'; //char
    }
}