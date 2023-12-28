package DataStructureAndAlgorithms.AssignmentTH.Hw2_21002139.Ex4;

import DataStructureAndAlgorithms.AssignmentTH.Hw2_21002139.Ex1.BubbleSort;
import DataStructureAndAlgorithms.AssignmentTH.Hw2_21002139.Ex2.SelectionSort;
import DataStructureAndAlgorithms.AssignmentTH.Hw2_21002139.Ex3.InsertionSort;

public class TestSimpleSort {
    public static void main(String[] args) {
        int[] array = generateArraySortedAlready(50);
        BubbleSort bubbleSort = new BubbleSort(array);
        SelectionSort selectionSort = new SelectionSort(array);
        InsertionSort insertionSort = new InsertionSort(array);

        // The array before sort 
        bubbleSort.printArray();

        // Test bubble sort
        System.out.println("\nTest BubbleSort");
        System.out.println("BubbleSort ran in " + bubbleSort.sortBubbleSort() + " nano seconds");
        System.out.println("with " + bubbleSort.getNumberOfSwap() + " swap times " +
            "and " + bubbleSort.getNumberOfComparisons() + " comparisons times.");
        
        // Test selection sort
        System.out.println("\nTest SelectionSort");
        System.out.println("SelectionSort ran in " + selectionSort.sortSelectionSort() + " nano seconds");
        System.out.println("with " + selectionSort.getNumberOfSwap() + " swap times " +
            "and " + selectionSort.getNumberOfComparisons() + " comparisons times.");

        // Test bubble sort
        System.out.println("\nTest InsertionSort");
        System.out.println("InsertionSort ran in " + insertionSort.sortInsertionSort() + " nano seconds");
        System.out.println("with " + insertionSort.getNumberOfSwap() + " swap times " +
            "and " + insertionSort.getNumberOfComparisons() + " comparisons times.");
    }

    public static int[] generateArraySortedAlready(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i;
        }
        return array;
    }
    

}
