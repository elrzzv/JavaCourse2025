package generic_classes;

import java.util.*;

public class TaskTwo {
    // <? extends T> - "producer" (поставщик)
    // Принимает коллекции типа T или его подклассов
    // Можно безопасно читать элементы как T, но нельзя добавлять
    static <T> void readFromList(List<? extends T> list) {
        for (T item : list) {
            System.out.println("Читаем: " + item);
        }
    }

    // <? super T> - "consumer" (потребитель)
    // Принимает коллекции типа T или его суперклассов
    // Можно безопасно добавлять элементы типа T, но читать только как Object
    static <T> void addToList(List<? super T> list, T item) {
        list.add(item);
        System.out.println("Добавили: " + item);
    }

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3);
        List<Number> numbers = new ArrayList<>();

        System.out.println("<? extends T> - только чтение:");
        readFromList(integers);

        System.out.println("\n<? super T> - только запись:");
        addToList(numbers, 42);

        System.out.println("numbers: " + numbers);
    }
}