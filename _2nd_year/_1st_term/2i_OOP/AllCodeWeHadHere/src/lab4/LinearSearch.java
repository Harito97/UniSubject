package lab4;

public class LinearSearch {
    //Return true if the key is found inside the array
    public static boolean linearSearch(int[] array, int key){
        if (array == null){
            return false;
        }
        for (int value : array){
            if (value == key){
                return true;
            }
        }
        return false;
    }

    //Return the array index, if key is found or 0 otherwise
    public static int linearSearchIndex(int[] array, int key){
        if (array == null){
            return 0;
        }
        int length = array.length;
        for (int idx = 0; idx < length; idx++){
            if (array[idx] == key){
                return idx;
            }
        }
        return 0;
    }

    //Main
    public static void main(String[] args) {
        int[] array1 = null;
        int[] array2 = {0,1,2,3,4};
        System.out.println("Test array1: ");
        System.out.println(linearSearch(array1, 2));
        System.out.println(linearSearchIndex(array1, 2));
        System.out.println("Test array2: ");
        System.out.println(linearSearch(array2, 2));
        System.out.println(linearSearchIndex(array2, 2));
    }
}
