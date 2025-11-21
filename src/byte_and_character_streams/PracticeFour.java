package byte_and_character_streams;

public class PracticeFour {

    static class MyResource implements AutoCloseable {
        public void use() {
            System.out.println("Using resource");
        }

        @Override
        public void close() {
            System.out.println("Resource closed automatically");
        }
    }

    public static void main(String[] args) {
        try (MyResource resource = new MyResource()) {
            resource.use();
        }

        String explanation = """
                \n\nAutoCloseable нужен для:
                - Автоматического закрытия ресурсов
                - Предотвращения утечек ресурсов
                - Упрощения кода (не нужно finally)
                """;

        System.out.println(explanation);
    }
}