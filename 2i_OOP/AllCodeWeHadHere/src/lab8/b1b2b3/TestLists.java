package lab8.b1b2b3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestLists {
    public static void main(String[] args) {
        ArrayList<Integer> test = new ArrayList<>(List.of(1,2,3,4));
        System.out.println("ArrayList test here: ");
        System.out.println(test);

        //Test insertFirst()
        Lists.insertFirst(test, 0);
        System.out.println("\nAfter insertFirst: ");
        System.out.println(test);

        //Test insertLast
        Lists.insertLast(test, 666);
        System.out.println("\nAfter insertLast: ");
        System.out.println(test);

        //Test replace the 3rd element of a list with a given value = 666
        Lists.replace(test,666);
        System.out.println("\nAfter replace the 3rd element with 666: ");
        System.out.println(test);

        //Test remove the element "666" from the list
        Lists.removeEvil(test);
        System.out.println("\nAfter remove all 666: ");
        System.out.println(test);

        //Test generateSquare()
        System.out.println("\nHere generate square: ");
        System.out.println(Lists.generateSquare());

        //Test contains()
        System.out.println("\nIs 666 in test: ");
        System.out.println(Lists.contains(test, 666));

        //Test copy()
        ArrayList<Integer> target = new ArrayList<>();
        Lists.copy(test, target);
        System.out.println("\nList target after copy from test here: ");
        System.out.println(target);

        //Test reverse()
        Lists.reverse(test);
        System.out.println("\ntest after reverse(): ");
        System.out.println(test);

        //Test reverseManual()
        Lists.reverseManual(target);
        System.out.println("\ntarget after reverseManual(): ");
        System.out.println(target);

        //Test insertBeginningEnd()
        LinkedList<Integer> list = new LinkedList<>(List.of(6,7,8,9));
        System.out.println("\nHere is list: ");
        System.out.println(list);
        Lists.insertBeginningEnd(list, 90);
        System.out.println("After insertBeginningEnd value 90 into list: ");
        System.out.println(list);
    }
}
