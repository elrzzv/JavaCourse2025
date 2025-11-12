public class LogicalBlocks {
    public static class A {
        {
            System.out.println("logic (1) id= " + this.id);
            // Выполняется вторым. id еще не инициализирован явно, поэтому = 0 (значение по умолчанию для int)
        }

        static {
            System.out.println("static logic");
            // Выполняется первым при загрузке класса, до создания любого объекта
        }

        private int id = 1;
        // Инициализация поля. Выполняется после первого логического блока, но до второго

        public A(int id) {
            this.id = id;
            System.out.println("ctor id= " + id);
            // Выполняется последним, после всех логических блоков
        }

        {
            System.out.println("logic (2) id= " + id);
            // Выполняется третьим. id уже инициализирован значением 1
        }
    }

    public static void main(String[] args) {
        new A(100);
        /* Вывод:
            static logic
            logic (1) id= 0
            logic (2) id= 1
            ctor id= 100
        */
    }
}