package lab8.b1b2b3;

import java.util.*;

public class Lists {
    //Function to insert an element into a list at the beginning
    public static void insertFirst(ArrayList<Integer> list, int value){
        int size = list.size();
        list.add(0);
        for (int idx = size - 1; idx >= 0; idx--){
            list.set(idx + 1, list.get(idx));
        }
        list.set(0, value);
    }

    //Function to insert an element into a list at the end
    public static void insertLast(ArrayList<Integer> list, int value){
        list.add(list.size(), value);
    }

    //Function to replace the 3rd element of a list with a given value
    public static void replace(ArrayList<Integer> list, int value){
        if (list.size() < 3) return;
        list.set(2, value);
    }

    //Function to remove the element "666" from the list
    public static void removeEvil(ArrayList<Integer> list){
        list.removeAll(Collections.singleton(666));
    }

    //Function returning a ArrayList<Integer> containing
    //the first 10 square numbers (ie: 1,4,9,...)
    public static ArrayList<Integer> generateSquare(){
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 1; i <= 10; i++){
            result.add(i * i);
        }
        return result;
    }

    //Function to verify if a list contains a certain value
    public static boolean contains(ArrayList<Integer> list, int value){
        if (list == null || list.size() == 0){
            return false;
        }
        for (Integer integer : list) {
            if (integer == value) {
                return true;
            }
        }
        return false;
    }

    //Function to copy a list into another list (without using library functions)
    //Note well: the target list must be emptied before the copy
    public static void copy(ArrayList<Integer> source, ArrayList<Integer> target){
        target.clear();
        if (source.size() == 0) return;
        for (int i = 0; i < source.size(); i++){
            target.add(i, source.get(i));
        }
    }

    //Function to reverse the elements of a list
    public static void reverse(ArrayList<Integer> list){
        Collections.reverse(list);
    }

    //Function to reverse the elements of a list (without using library functions)
    public static void reverseManual(ArrayList<Integer> list){
        if (list.size() <= 0) return;
        int temp;
        int size = list.size();
        for (int i = 0; i < size / 2; i++){
            temp = list.get(i);
            list.set(i, list.get(size - i - 1));
            list.set(size - i - 1, temp);
        }
    }

    //Function to insert the same element both at the beginning
    //and the end of the same LinkedList
    //Note well: you can use LinkedList specific methods
    public static void insertBeginningEnd(LinkedList<Integer> list, int value){
        list.add(0, value);
        list.add(list.size(), value);
    }

}
