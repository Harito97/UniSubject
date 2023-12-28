package lab8.b1b2b3;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TestSets {
    public static void main(String[] args) {
        Set<Integer> first = new HashSet<>(List.of(1,2,3,4,5,6,7));
        Set<Integer> second = new HashSet<>(List.of(5,6,7,8,9,10));
        System.out.println("Set first: ");
        System.out.println(first);
        System.out.println("Set second: ");
        System.out.println(second);

        System.out.println("\nTest intersectionManual(): ");
        System.out.println(Sets.intersectionManual(first, second));

        System.out.println("\nTest unionManual(): ");
        System.out.println(Sets.unionManual(first, second));

        System.out.println("\nTest intersection(): ");
        System.out.println(Sets.intersection(first, second));

        System.out.println("\nTest union(): ");
        System.out.println(Sets.union(first, second));

        System.out.println("\nTest toList(): ");
        List<Integer> list = Sets.toList(first);
        System.out.println(list);

        System.out.println("\nTest removeDuplicates(): ");
        System.out.println("List list add new value 3.");
        list.add(3);
        System.out.println(first);
        System.out.println("Use removeDuplicates(): ");
        System.out.println(Sets.removeDuplicates(list));

        System.out.println("\nTest removeDuplicatesManual(): ");
        System.out.println("List list add new value 5.");
        list.add(5);
        System.out.println(first);
        System.out.println("Use removeDuplicates(): ");
        System.out.println(Sets.removeDuplicates(list));

        System.out.println("\nTest firstRecurringCharacter(): ");
        String s = "abcdab";
        System.out.println("String s: " + s);
        System.out.println(Sets.firstRecurringCharacter(s));

        System.out.println("\nTest toArray(): ");
        System.out.println("Set second toArray() to take new array.");
        System.out.println(Sets.toArray(second));

        System.out.println("\nTest getFirst() of TreeSet treeSet:");
        TreeSet<Integer> treeSet = new TreeSet<>(second);
        System.out.println("Here treeSet: " + treeSet);
        System.out.println(Sets.getFirst(treeSet));

        System.out.println("\nTest getLast() of TreeSet treeSet:");
        System.out.println(Sets.getLast(treeSet));

        System.out.println("\nTest getGreater(): ");
        System.out.println("What is higher 90 in treeSet?");
        System.out.println(Sets.getGreater(treeSet, 90));
    }
}
