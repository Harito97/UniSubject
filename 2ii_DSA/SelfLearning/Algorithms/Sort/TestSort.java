package DataStructureAndAlgorithms.SelfLearning.Algorithms.Sort;

import java.util.Arrays;
import java.util.Random;

public class TestSort {
    private static Integer[] generateRandomArray() {
        Random random = new Random();
        int n = random.nextInt(0, 10000);
        Integer[] array = new Integer[n];
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(0, 1000000);
        }
        return array;
    }

    public static void main(String[] args) {
        Integer[] array = generateRandomArray();
        Integer[] temp = Arrays.copyOf(array, array.length);

        testBubbleSort(temp);

        temp = Arrays.copyOf(array, array.length);
        testSelectionSort(temp);

        temp = Arrays.copyOf(array, array.length);
        testInsertionSort(temp);

        temp = Arrays.copyOf(array, array.length);
        testQuickSort(array);

        temp = Arrays.copyOf(array, array.length);
        testMergeSort(array);
    }

    public static void testBubbleSort(Integer[] array) {
        Sort<Integer> sort = new BubbleSort<Integer>(array);
        //testSort.sort.printArray();

        System.out.println("BubbleSort take these time to sort: ");
        sort.printTimeRan();
        //testSort.sort.printArray();
    }

    public static void testSelectionSort(Integer[] array) {
        Sort<Integer> sort = new SelectionSort<Integer>(array);

        System.out.println("SelectionSort take these time to sort: ");
        sort.printTimeRan();
    }

    public static void testInsertionSort(Integer[] array) {
        Sort<Integer>  sort = new SelectionSort<Integer>(array);
        //sort.printArray();

        System.out.println("InsertionSort take these time to sort: ");
        sort.printTimeRan();
        //sort.printArray();
    }

    public static void testQuickSort(Integer[] array) {
        Sort<Integer>  sort = new QuickSort<Integer>(array);
        //sort.printArray();

        System.out.println("QuickSort take these time to sort: ");
        sort.printTimeRan();
        //sort.printArray();
    }

    public static void testMergeSort(Integer[] array) {
        Sort<Integer>  sort = new MergeSort<Integer>(array);
        //sort.printArray();

        System.out.println("MergeSort take these time to sort: ");
        sort.printTimeRan();
        //sort.printArray();
    }
}