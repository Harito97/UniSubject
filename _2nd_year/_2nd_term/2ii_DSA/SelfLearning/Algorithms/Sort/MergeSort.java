package DataStructureAndAlgorithms.SelfLearning.Algorithms.Sort;

import java.util.Arrays;

public class MergeSort<T extends Comparable<T>> extends Sort<T> {
    public MergeSort(T[] inputArray) {
        super(inputArray);
    }
    
    @Override
    public void sort() {
        mergeSort(array, 0, array.length - 1);
    }

    private void mergeSort(T[] array, int lowerIndex, int higherIndex) {
        int midIndex;
        if (lowerIndex < higherIndex) {
            midIndex = (lowerIndex + higherIndex) / 2;

            // Divide a into two halves and recursively sort them
            mergeSort(array, lowerIndex, midIndex);
            mergeSort(array, midIndex + 1, higherIndex);

            // Conquer: merge the two sorted halves
            // This function below use to merge array[low...mid] + array[mid+1...high] = array[low...mid]
            merge(array, lowerIndex, midIndex, higherIndex);
        }

        // If lowerIndex >= higherIndex, then it is the base case. Eg: array has 0 or 1 item
    }

    private void merge(T[] array, int lowerIndex, int midIndex, int higherIndex) {
        int n = higherIndex - lowerIndex + 1;
        T[] temp = Arrays.copyOf(array, n);

        int left = lowerIndex, right = midIndex + 1, tempIndex = 0;

        while (left <= midIndex && right <= higherIndex) {
            if (compare(array[left], array[right]) <= 0) {
                temp[tempIndex++] = array[left++];
            } else {
                temp[tempIndex++] = array[right++];
            }
        }

        while (left <= midIndex) {
            temp[tempIndex++] = array[left++];
        }

        while (right <= higherIndex) {
            temp[tempIndex++] = array[right++];
        }

        for (int k = 0; k < n; k++) {
            array[lowerIndex + k] = temp[k];
        }

        temp = null;    // To clear memory

        // Merge sort hiện đang có vấn đề mà mk chưa hiểu đc
        // (Đã hiểu ra lỗi tại dòng 10, higherIndex đầu vào phải là chỉ số max = length - 1, chứ không phải là length)
    }
}
