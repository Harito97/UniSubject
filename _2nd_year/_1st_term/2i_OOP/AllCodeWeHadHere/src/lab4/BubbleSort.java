package lab4;

import java.util.Arrays;

public class BubbleSort {
    public static void bubbleSort(int[] array){
        if (array == null){
            System.out.println("The array has no value");
            return;
        }
        int length = array.length;
        for (int downBubble = 0; downBubble < length - 1; downBubble++){
            for (int upBubble = downBubble + 1; upBubble < length; upBubble++){
                if (array[downBubble] > array[upBubble]){
                    int temp = array[downBubble];
                    array[downBubble] = array[upBubble];
                    array[upBubble] = temp;
                }
            }
        }
        System.out.println("The array after sort.");
    }

    //Main
    public static void main(String[] args) {
        int[] array1 = null;
        int[] array2 = {2,54,65,45,12,36,78,79,25};
        System.out.println("Test array1:");
        bubbleSort(array1);
        System.out.println("Test array2:");
        bubbleSort(array2);
        System.out.println(Arrays.toString(array2));
        /*for (int idx = 0; idx < array2.length; idx++){
            System.out.print(array2[idx] + " ");
        }*/
    }
}
