public class Operators {
    public static void main(String[] args) {
        // Практика #1 - Примеры использования операторов

        // Базовые типы
        int a = 10, b = 3;
        double x = 5.5, y = 2.0;
        boolean p = true, q = false;

        // Операторы присваивания
        System.out.println("=== Операторы присваивания ===");
        int result = 0;
        result = a; // =
        System.out.println("= : " + result);

        result += b; // +=
        System.out.println("+= : " + result);

        result -= a; // -=
        System.out.println("-= : " + result);

        result *= b; // *=
        System.out.println("*= : " + result);

        result /= 2; // /=
        System.out.println("/= : " + result);

        result %= b; // %=
        System.out.println("%= : " + result);

        // Тернарный оператор
        System.out.println("\n=== Тернарный оператор ===");
        int max = (a > b) ? a : b;
        System.out.println("?: : " + max);

        // Логические операторы
        System.out.println("\n=== Логические операторы ===");
        boolean and = p && q; // &&
        boolean or = p || q;  // ||
        System.out.println("&& : " + and);
        System.out.println("|| : " + or);

        // Побитовые операторы
        System.out.println("\n=== Побитовые операторы ===");
        int bitOr = a | b;   // |
        int bitXor = a ^ b;  // ^
        int bitAnd = a & b;  // &
        System.out.println("| : " + bitOr);
        System.out.println("^ : " + bitXor);
        System.out.println("& : " + bitAnd);

        // Операторы сравнения
        System.out.println("\n=== Операторы сравнения ===");
        boolean equal = a == b;     // ==
        boolean notEqual = a != b;  // !=
        boolean greater = a > b;    // >
        boolean less = a < b;       // <
        System.out.println("== : " + equal);
        System.out.println("!= : " + notEqual);
        System.out.println("> : " + greater);
        System.out.println("< : " + less);

        // Операторы сдвига
        System.out.println("\n=== Операторы сдвига ===");
        int leftShift = a << 1;     // <<
        int rightShift = a >> 1;    // >>
        int unsignedRightShift = a >>> 1; // >>>
        System.out.println("<< : " + leftShift);
        System.out.println(">> : " + rightShift);
        System.out.println(">>> : " + unsignedRightShift);

        // Арифметические операторы
        System.out.println("\n=== Арифметические операторы ===");
        int sum = a + b;    // +
        int diff = a - b;   // -
        int mult = a * b;   // *
        int div = a / b;    // /
        int mod = a % b;    // %
        System.out.println("+ : " + sum);
        System.out.println("- : " + diff);
        System.out.println("* : " + mult);
        System.out.println("/ : " + div);
        System.out.println("% : " + mod);

        // Унарные операторы
        System.out.println("\n=== Унарные операторы ===");
        int preIncrement = ++a; // префиксный ++
        int postIncrement = b++; // постфиксный ++
        int preDecrement = --a; // префиксный --
        int postDecrement = b--; // постфиксный --
        boolean not = !p;       // !
        int bitNot = ~a;        // ~
        System.out.println("++a : " + preIncrement);
        System.out.println("b++ : " + postIncrement);
        System.out.println("--a : " + preDecrement);
        System.out.println("b-- : " + postDecrement);
        System.out.println("! : " + not);
        System.out.println("~ : " + bitNot);

        // Операторы для String
        System.out.println("\n=== Операторы для String ===");
        String str1 = "Hello";
        String str11 = "Hello";
        String str2 = "World";
        String concat = str1 + " " + str2; // +
        System.out.println("+ для String: " + concat);

        str1 += " Java"; // +=
        System.out.println("+= для String: " + str1);

        boolean strEqual = (str1 == str11); // != (сравнение ссылок)
        boolean strNotEqual = (str1 != str2); // !=
        System.out.println("== для String: " + strEqual);
        System.out.println("!= для String: " + strNotEqual);





        // Практика #2 - Оператор instanceof
        System.out.println("\n=== Оператор instanceof ===");

        String text = "Hello";
        Integer number = 42;

        // Примеры с разными типами
        System.out.println("text instanceof String: " + (text instanceof String));
        System.out.println("number instanceof Integer: " + (number instanceof Integer));
        System.out.println("number instanceof Number: " + (number instanceof Number));

        // Пример с null
        String nullString = null;
        System.out.println("nullString instanceof String: " + (nullString instanceof String));

    }
}