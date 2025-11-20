package inner_classes;

public class PracticeThree {

    public static class OuterClass {
        // Внешний класс создает объект внутреннего
        private InnerClass inner = new InnerClass();

        public void accessInner() {
            // внешний класс имеет доступ только к public элементам внутреннего класса
            inner.publicField = "accessed";
            System.out.println("public field");
            inner.publicMethod();

            // ошибка: нет доступа к private полям внутреннего класса
            // inner.privateField = "error";
            // inner.privateMethod();
        }

        public class InnerClass {
            private String privateField = "private";
            public String publicField = "public";

            private void privateMethod() {
                System.out.println("private method");
            }

            public void publicMethod() {
                System.out.println("public method");
            }
        }
    }

    public static void main(String[] args) {
        OuterClass outer = new OuterClass();
        outer.accessInner();
    }
}