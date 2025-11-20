package inner_classes;

public class PracticeOne {

    // Внешний класс
    public static class OuterClass {
        // public внутренний класс - доступен везде
        public class PublicInner {
            public void show() {
                System.out.println("Public inner class");
            }
        }

        // protected внутренний класс - доступен в пакете и подклассах
        protected class ProtectedInner {
            public void show() {
                System.out.println("Protected inner class");
            }
        }

        // default внутренний класс - доступен только в пакете
        class DefaultInner {
            public void show() {
                System.out.println("Default inner class");
            }
        }

        // private внутренний класс - доступен только во внешнем классе
        private class PrivateInner {
            public void show() {
                System.out.println("Private inner class");
            }
        }

        public void testAccess() {
            // Все внутренние классы доступны из внешнего
            PublicInner pi = new PublicInner();
            ProtectedInner proi = new ProtectedInner();
            DefaultInner di = new DefaultInner();
            PrivateInner pri = new PrivateInner();
        }
    }

    public static void main(String[] args) {
        OuterClass outer = new OuterClass();

        // доступ к внутренним классам извне
        OuterClass.PublicInner publicInner = outer.new PublicInner();
        publicInner.show();
        // OuterClass.ProtectedInner protectedInner = outer.new ProtectedInner(); // ошибка вне пакета
        // OuterClass.DefaultInner defaultInner = outer.new DefaultInner(); // ошибка вне пакета
        // OuterClass.PrivateInner privateInner = outer.new PrivateInner(); // ошибка всегда
    }
}