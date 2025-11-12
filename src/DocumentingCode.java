/**
 * Класс для демонстрации javadoc дескрипторов
 * @author Eleonora
 * @version 1.0
 * @since 1.0
 */
public class DocumentingCode {

    private String name;

    /**
     * Конструктор класса
     * @param name имя пользователя
     * @see #getName()
     */
    public DocumentingCode(String name) {
        this.name = name;
    }

    /**
     * Возвращает имя пользователя
     * @return имя пользователя
     * @exception IllegalArgumentException если имя равно null
     * @throws IllegalArgumentException если имя пустая строка
     */
    public String getName() {
        if (name == null) {
            throw new IllegalArgumentException("Name can not be null");
        }
        return name;
    }

    /**
     * Новый метод приветствия
     * @return приветствие
     */
    public String hello() {
        return "Hello, " + name;
    }


    /**
     * Устаревший метод приветствия
     * @deprecated Используйте {@link #hello()} вместо этого
     * @return приветствие
     */
    @Deprecated
    public String greet() {
        return "Greetings to " + name + "!";
    }

    /**
     * Главный метод
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        DocumentingCode doc = new DocumentingCode("Eleonora");
        System.out.println(doc.hello());
    }
}