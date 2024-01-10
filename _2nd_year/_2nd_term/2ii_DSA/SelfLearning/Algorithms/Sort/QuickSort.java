package DataStructureAndAlgorithms.SelfLearning.Algorithms.Sort;

public class QuickSort<T extends Comparable<T>> extends Sort<T> {
    public QuickSort(T[] inputArray) {
        super(inputArray);
    }
    
    @Override
    public void sort() {
        quickSort(0, array.length - 1);
    }

    private void quickSort(int indexLower, int indexHigher) {
        int pivotIndex;

        if (indexLower < indexHigher) {
            pivotIndex = partition(array, indexLower, indexHigher);

            quickSort(indexLower, pivotIndex - 1);
            quickSort(pivotIndex + 1, indexHigher);
        }
    }

    private int partition(T[] array, int indexLower, int indexHigher) {
        T pivot = array[indexLower];
        // pivot is the pivot item
        int pivotIndex = indexLower;
        // pivotIndex is the right index of the pivot (divide array into 2 parts)

        for (int k = indexLower + 1; k <= indexHigher; k++) {
            if (compare(array[k], pivot) < 0) {
                pivotIndex++;
                swap(pivotIndex, k);
            } else {
                // it mean this element (item) is bigger
                // then don't need swap it to the pivot as it is right of pivot
            }
        }

        swap(indexLower, pivotIndex);
        return pivotIndex;
    }
}