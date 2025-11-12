public class AccessModifiersDemo {
    public static class Parent {
        public String publicVar = "public";
        protected String protectedVar = "protected";
        String defaultVar = "default"; // без спецификатора
        private String privateVar = "private";

        public void showAccess() {
            System.out.println("Внутри Parent класса:");
            System.out.println(" - " + publicVar);    // доступно
            System.out.println(" - " + protectedVar); // доступно
            System.out.println(" - " + defaultVar);   // доступно
            System.out.println(" - " + privateVar);   // доступно
        }
    }

    static class ChildSamePackage extends Parent {
        public void showAccess() {
            System.out.println("В ChildSamePackage:");
            System.out.println(" - " + publicVar);    // доступно
            System.out.println(" - " + protectedVar); // доступно (наследование)
            System.out.println(" - " + defaultVar);   // доступно (тот же пакет)
            // System.out.println(privateVar); // ошибка: private недоступно
        }
    }

    static class OtherClassSamePackage {
        public void showAccess() {
            Parent parent = new Parent();
            System.out.println("В OtherClassSamePackage:");
            System.out.println(" - " + parent.publicVar);    // доступно
            System.out.println(" - " + parent.protectedVar); // доступно
            System.out.println(" - " + parent.defaultVar);   // доступно
            // System.out.println(parent.privateVar); // ошибка: private недоступно
        }
    }

    public static void main(String[] args) {
        Parent parent = new Parent();
        parent.showAccess();

        ChildSamePackage child = new ChildSamePackage();
        child.showAccess();

        OtherClassSamePackage other = new OtherClassSamePackage();
        other.showAccess();

        System.out.println("\nИз main метода:");
        System.out.println(" - " + parent.publicVar);    // доступно
        System.out.println(" - " + parent.protectedVar); // доступно
        System.out.println(" - " + parent.defaultVar);   // доступно
        // System.out.println(parent.privateVar); // ошибка: private недоступно
    }
}