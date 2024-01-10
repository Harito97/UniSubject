package lab8.b1b2b3;

import java.util.*;

public class Sets {
    //Function returning the intersection of 2 given sets
    //(without using lib)
    public static Set<Integer> intersectionManual(Set<Integer> first,
                                                  Set<Integer> second){
        Set<Integer> result = new HashSet<>();
        for (int x : first){
            for (int y : second){
                if (x == y){
                    result.add(x);
                    break;
                }
            }
        }
        return result;
    }

    //Function returning the union of 2 given sets
    //(without using lib)
    public static Set<Integer> unionManual(Set<Integer> first,
                                           Set<Integer> second){
        Set<Integer> result = new HashSet<>();
        for (int x : first){
            result.add(x);
        }
        for (int y : second) {
            result.add(y);
        }
        return result;
    }

    //Function returning the intersection of 2 given sets (see retainAll())
    public static Set<Integer> intersection(Set<Integer> first,
                                            Set<Integer> second){
        Set<Integer> result = new HashSet<Integer>(first);
        result.retainAll(second);
        return result;
    }

    //Function returning the union of 2 given sets (see addAll())
    public static Set<Integer> union(Set<Integer> first,
                                     Set<Integer> second){
        Set<Integer> result = new HashSet<Integer>(first);
        result.addAll(second);
        return result;
    }

    //Function to transform a set into a list without duplicates
    //Note well: collections can be created from another collection
    public static List<Integer> toList(Set<Integer> source){
//        List<Integer> result = new LinkedList<>();
//        for (int x : source){
//            result.add(x);
//        }
//        return result;
        return new ArrayList<>(source);
    }

    //Function to remove duplicates from a list
    //Note: collections can be created from another collection
    public static List<Integer> removeDuplicates(List<Integer> source){
        return new ArrayList<>(new HashSet<>(source));
    }

    //Function to remove duplicates from a list
    //without using the constructors trick seen above
    public static List<Integer> removeDuplicatesManual(List<Integer> source){
        List<Integer> temp = new ArrayList<>();
        for (Integer integer : source) {
            if (!temp.contains(integer)){
                temp.add(integer);
            }
        }
        return temp;
    }

    //Function accepting a string s
    //returning the first recurring character
    //Eg: firstRecurringCharacter("abaco") -> a
    public static String firstRecurringCharacter(String s){
        if (s == null || s.length() == 0){
            return null;
        }
        for (int i = 0; i < s.length() - 1; i++){
            for (int j = i + 1; j < s.length(); j++){
                if (s.charAt(i) == s.charAt(j)){
                    return s.charAt(i) + "";
                }
            }
        }
        return null;
    }

    //Function to transform a set into an array
    public static Integer[] toArray(Set<Integer> source){
//        Integer[] result = new Integer[source.size()];
//        int idx = 0;
//        for (int x : source){
//            result[idx] = x;
//            idx++;
//        }
//        return result;
        return source.toArray(source.toArray(new Integer[0]));
    }

    //Function to return the first item from a TreeSet
    //Note: use TreeSet specific methods
    public static int getFirst(TreeSet<Integer> source){
        return source.first();
    }

    //Function to return the last item from a TreeSet
    public static int getLast(TreeSet<Integer> source){
        return source.last();
    }

    //Function to get an element from a TreeSet
    //which is strictly greater than a given element
    public static int getGreater(TreeSet<Integer> source, int value){
        for (int x : source){
            if (x > value){
                return x;
            }
        }
        return Integer.MIN_VALUE;
//        return source.higher(value);
    }
}
