package parameterized_classes;

public class TaskTwo {

    enum Priority {
        LOW, MEDIUM, HIGH;

        public boolean isUrgent() {
            return this == HIGH;
        }
    }

    public static void main(String[] args) {
        for (Priority priority : Priority.values()) {
            System.out.println(priority + " urgent: " + priority.isUrgent());
        }
    }
}
