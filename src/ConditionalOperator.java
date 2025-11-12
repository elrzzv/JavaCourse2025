public class ConditionalOperator {
    public static void main(String[] args) {
        int a = 2; // любое значение для определённости
        int i = (a == 1) ? 1 : (a == 2) ? 2 : 3;
        System.out.println("a = " + a + " -> i = " + i);
    }
}