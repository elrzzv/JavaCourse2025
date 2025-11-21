package class_string;

public class PracticeThree {
    public static void main(String[] args) {
        // текстовые блоки (Java 15+) - три двойные кавычки
        String html = """
            <html>
                <body>
                    <h1>Hello World</h1>
                    <p>This is a text block</p>
                </body>
            </html>
            """;

        System.out.println("HTML:\n" + html);


        System.out.println("\nТри двойные кавычки нужны для:");
        System.out.println("- Многострочных строковых литералов");
        System.out.println("- Сохранения форматирования текста");
        System.out.println("- Удобства написания HTML, JSON, SQL кода");
        System.out.println("- Улучшения читаемости кода");
    }
}