package lab4;

public class SelectionSort {
    public static void selectionSort(int[] array){
        if (array == null){
            System.out.println("The array has no value.");
            return;
        }
        int length = array.length;
        for (int idxSorted = 0; idxSorted < length - 1; idxSorted++){
            int idxMin = idxSorted + 1;
            int min = array[idxMin];
            //Find the min value in the unsorted part of array
            for (int idxUnSorted = idxSorted + 2; idxUnSorted < length; idxUnSorted++){
                if (min > array[idxUnSorted]) {
                    min = array[idxUnSorted];
                    idxMin = idxUnSorted;
                }
            }
            //Compare that min value to the max value in the sorted part of array
            //Note that the min value in the unsorted part
            //always bigger than the 2nd max value in the sorted part of array
            //If the min value in unsorted part smaller the max value in sorted part
            //then swap them
            if (min < array[idxSorted]){
                int temp = array[idxSorted];
                array[idxSorted] = min;
                array[idxMin] = temp;
            }
            System.out.print(array[idxSorted] + " ");
        }
    }
    //So sanh voi cach cua anh tro giang
    /*public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIdx = i + 1;
            for (int j = i + 2; j < array.length; j++) {
                if (array[minIdx] > array[j]) {
                    minIdx = j;
                }
            }
            int tmp = array[i];
            array[i] = array[minIdx];
            array[minIdx] = tmp;
        }
    }*/

    public static void main(String[] args) {
        int[] array1 = null;
        int[] array2 = {2,54,65,45,12,36,78,79,25};
        System.out.println("Test array1:");
        selectionSort(array1);
        System.out.println("Test array2:");
        selectionSort(array2);
    }
}
