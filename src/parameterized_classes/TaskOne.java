package parameterized_classes;

public class TaskOne {

    enum Size {
        SMALL("S"), MEDIUM("M"), LARGE("L");

        private final String abbreviation;

        Size(String abbreviation) {
            this.abbreviation = abbreviation;
        }

        public String getAbbreviation() {
            return abbreviation;
        }
    }

    public static void main(String[] args) {
        for (Size size : Size.values()) {
            System.out.println(size + ": " + size.getAbbreviation());
        }
    }
}