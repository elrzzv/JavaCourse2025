package inner_classes;

public class PracticeTwo {

    public static class OuterClass {
        private String privateField = "private field";
        protected String protectedField = "protected field";
        String defaultField = "default field";
        public String publicField = "public field";

        private void privateMethod() {
            System.out.println("private method");
        }

        public void publicMethod() {
            System.out.println("public method");
        }

        public class InnerClass {
            public void accessOuter() {
                // Внутренний класс имеет доступ ко всем полям и методам внешнего класса
                System.out.println(privateField);
                System.out.println(protectedField);
                System.out.println(defaultField);
                System.out.println(publicField);

                privateMethod();
                publicMethod();
            }
        }
    }

    public static void main(String[] args) {
        OuterClass outer = new OuterClass();
        OuterClass.InnerClass inner = outer.new InnerClass();
        inner.accessOuter();
    }
}