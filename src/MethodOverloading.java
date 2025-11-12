public class MethodOverloading {
    public static class A {
        public void printNum(Integer i) {
            System.out.printf("Integer = %d%n", i);
        }
        public void printNum(int i) {
            System.out.printf("int = %d%n", i);
        }
        public void printNum(Float f) {
            System.out.printf("Float = %.4f%n", f);
        }
        public void printNum(Number n) {
            System.out.println("Number=" + n);
        }
    }

    public static void main(String[] args) {
        A a = new A();
        //Number[] num = {new Integer(1), 11, 1.11f, 11.11};    //ошибка компиляции
        Number[] num = {Integer.valueOf(1), 11, 1.11f, 11.11};

        // цикл for (1)
        System.out.println("=== Цикл for ===");
        for (Number n : num) {
            a.printNum(n); // Всегда вызывается printNum(Number n)
            // потому что тип переменной n - Number (определено на этапе компиляции)
        }

        // (2)
        System.out.println("\n=== Прямые вызовы ===");
        //a.printNum(new Integer(1)); // ошибка компиляции
        a.printNum(Integer.valueOf(1)); // Integer = 1 (точно соответствует Integer)
        a.printNum(11);             // int = 11 (автоупаковка до Integer, но int приоритетнее)
        a.printNum(1.11f);          // Float = 1.1100 (точно соответствует Float)
        a.printNum(11.11);          // Number=11.11 (Double -> Number, т.к. нет метода для Double)
    }
}