// PracticeOne.java
public class ObjectClass {

    static class Student {
        private String name;
        private int age;
        private String id;

        public Student(String name, int age, String id) {
            this.name = name;
            this.age = age;
            this.id = id;
        }

        @Override
        public boolean equals(Object obj) {
            // 1. Рефлексивность: объект должен быть равен самому себе
            if (this == obj) return true;

            // 2. Проверка на null и совпадение классов
            if (obj == null || this.getClass() != obj.getClass()) return false;

            // 3. Приведение типа и сравнение полей
            Student other = (Student) obj;
            return this.age == other.age &&
                    this.name.equals(other.name) &&
                    this.id.equals(other.id);
        }

        @Override
        public int hashCode() {
            // 4. Если equals возвращает true, hashCode должен быть одинаковым
            return name.hashCode() + age + id.hashCode();
        }

        @Override
        public String toString() {
            return "Student{name='" + name + "', age=" + age + ", id='" + id + "'}";
        }
    }

    public static void main(String[] args) {
        Student student1 = new Student("John", 20, "S123");
        Student student2 = new Student("John", 20, "S123");
        Student student3 = new Student("Jane", 22, "S124");

        System.out.println("student1.equals(student2): " + student1.equals(student2)); // true
        System.out.println("student1.equals(student3): " + student1.equals(student3)); // false
        System.out.println("student1.equals(null): " + student1.equals(null));       // false
        System.out.println("student1.equals(student1): " + student1.equals(student1)); // true

        System.out.println("\nСоглашения для equals():");
        System.out.println("1. Рефлексивность: x.equals(x) = true");
        System.out.println("2. Симметричность: x.equals(y) = y.equals(x)");
        System.out.println("3. Транзитивность: если x.equals(y) и y.equals(z), то x.equals(z)");
        System.out.println("4. Консистентность: multiple calls return same result");
        System.out.println("5. x.equals(null) = false");
        System.out.println("6. Если x.equals(y) = true, то x.hashCode() == y.hashCode()");
    }
}