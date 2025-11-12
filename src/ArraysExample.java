import java.util.Arrays;

public class ArraysExample {
    public static void main(String[] args) {
        // Практика #1
        int a1[] = {1,2,3,4,5};
        int a2[] = {6,7,8,9,10};
        a1 = a2;
        System.out.println("a1 после присваивания: " + Arrays.toString(a1));
        // a1 теперь ссылается на тот же массив что и a2



        // Практика #2 - Класс Arrays
        System.out.println("\n=== Практика #2 ===");
        int[] arr1 = {5, 3, 8, 1, 9};
        int[] arr2 = {5, 3, 8, 1, 9};
        int[] arr3 = {1, 3, 5, 8, 9};

        // toString
        System.out.println("toString: " + Arrays.toString(arr1));

        // sort + binarySearch
        Arrays.sort(arr1);
        System.out.println("После sort: " + Arrays.toString(arr1));
        int index = Arrays.binarySearch(arr1, 5);
        System.out.println("binarySearch 5: " + index);

        // equals
        boolean isEqual = Arrays.equals(arr1, arr2);
        System.out.println("equals sorted arr1 и arr2: " + isEqual);

        // compare
        int comparison = Arrays.compare(arr1, arr3);
        System.out.println("compare arr1 и arr3: " + comparison);
    }
}