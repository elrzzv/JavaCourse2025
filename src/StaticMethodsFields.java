public class StaticMethodsFields {
    public static int a = 1;
    public static int b;

    public static void printVars() {
        System.out.println(a);
        System.out.println(b);
    }

    public static void main(String[] args) {

        // Варианты вызова статического метода printVars()

        // 1. Через имя класса
        StaticMethodsFields.printVars();

        // 2. Через объект класса
        StaticMethodsFields obj = new StaticMethodsFields();
        obj.printVars();

        // 3. Напрямую (из того же класса)
        printVars();
    }
}
