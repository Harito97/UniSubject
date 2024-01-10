package lab4;

import java.util.Arrays;

public class InsertionSort {
    public static void insertionSort(int[] array){
        if (array == null){
            System.out.println("The array has no value");
            return;
        }
        int length = array.length;
        for (int unSorted = 1; unSorted < length; unSorted++){
            for (int sorted = 0; sorted < unSorted; sorted++){
                //If the value are testing smaller than a value - called X - in sorted part
                //then we will insert that value in the index of the value X,
                //at the same time, we will push the values bigger than it
                //(start from X to the end of sorted part) 1 index
                if (array[unSorted] < array[sorted]){
                    int temp = array[unSorted];
                    for (int idx = unSorted; idx > sorted; idx--){
                        array[idx] = array[idx - 1];
                    }
                    array[sorted] = temp;
                }
            }
            //After each in-for loop be done -> sorted part bigger than 1 index
        }
        System.out.println("The array after sort.");
    }
    //So sanh voi thuat toan tu trang
    //https://www.geeksforgeeks.org/insertion-sort/
    //Khong biet cach nao nhanh hon nhi :>
    /*public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }*/


    public static void main(String[] args) {
        int[] array1 = null;
        int[] array2 = {2,54,65,45,12,36,78,79,25};
        System.out.println("Test array1:");
        insertionSort(array1);
        System.out.println(Arrays.toString(array1));
        System.out.println("Test array2:");
        insertionSort(array2);
        System.out.println(Arrays.toString(array2));
        /*for (int idx = 0; idx < array2.length; idx++){
            System.out.print(array2[idx] + " ");
        }*/
    }
}
