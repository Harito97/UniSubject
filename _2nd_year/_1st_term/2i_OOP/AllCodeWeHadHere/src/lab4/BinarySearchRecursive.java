package lab4;

public class BinarySearchRecursive {
    //Method binary search is only applicable to a sorted list
    private static boolean binarySearch(int[] array, int key, int startIdx, int endIdx) {
        int middleIdx = (startIdx + endIdx) / 2;
        if (startIdx > endIdx) {
            return false;
        }
        if (array[middleIdx] == key) {
            return true;
        }
        if (array[middleIdx] > key) {
            return binarySearch(array, key, startIdx, middleIdx - 1);
        }
        return binarySearch(array, key, middleIdx + 1, endIdx);
    }

    //Return true if key is found in the array
    public static boolean binarySearch(int[] array, int key) {
        return binarySearch(array, key, 0, array.length - 1);
    }

    public static void main(String[] args) {
        int[] array = {1, 27, 5, 78, 30, 79, 97, 4900, 450};
        SelectionSort.selectionSort(array);
        System.out.println();
        System.out.println(binarySearch(array, 2));
        System.out.println(binarySearch(array, 30));
        System.out.println(binarySearch(array, 25));
        System.out.println(binarySearch(array, 46));
        System.out.println(binarySearch(array, 450));
    }
}
