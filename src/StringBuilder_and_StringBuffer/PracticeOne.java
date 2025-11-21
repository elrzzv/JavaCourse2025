package StringBuilder_and_StringBuffer;

public class PracticeOne {
    public static void main(String[] args) {
        // StringBuilder (не потокобезопасный, но быстрее)
        StringBuilder sb = new StringBuilder("Hello");

        // 1. append() - добавляет строку в конец
        sb.append(" World");
        System.out.println("1. append(): " + sb);

        // 2. insert() - вставляет строку в указанную позицию
        sb.insert(5, " Java");
        System.out.println("2. insert(): " + sb);

        // 3. delete() - удаляет символы в диапазоне
        sb.delete(5, 10);
        System.out.println("3. delete(): " + sb);

        // 4. reverse() - переворачивает строку
        System.out.println("4. reverse(): " + sb.reverse());
        sb.reverse(); // возвращаем обратно

        // 5. replace() - заменяет символы в диапазоне
        sb.replace(6, 11, "Universe");
        System.out.println("5. replace(): " + sb);

        // 6. charAt() - возвращает символ по индексу
        System.out.println("6. charAt(0): " + sb.charAt(0));

        // 7. setCharAt() - устанавливает символ по индексу
        sb.setCharAt(0, 'h');
        System.out.println("7. setCharAt(): " + sb);

        // 8. length() - возвращает длину
        System.out.println("8. length(): " + sb.length());

        // 9. capacity() - возвращает текущую емкость
        System.out.println("9. capacity(): " + sb.capacity());

        // 10. substring() - возвращает подстроку
        System.out.println("10. substring(0, 5): " + sb.substring(0, 5));

        // StringBuffer (потокобезопасный)
        StringBuffer sbf = new StringBuffer("Buffer");
        sbf.append(" Example");
        System.out.println("\nStringBuffer: " + sbf);
    }
}