import java.util.Arrays;

public class InsertionSort {
    // https://www.geeksforgeeks.org/insertion-sort/

    // 4 3 2 10

    // 4
    // 3 4
    // 2 3 4
    // 2 3 4 10
    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] array = {9, 6, 4, 1, 5};
        insertionSort(array);
        System.out.println(Arrays.toString(array));
    }
}
