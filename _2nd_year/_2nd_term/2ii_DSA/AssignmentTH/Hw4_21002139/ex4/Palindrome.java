package DataStructureAndAlgorithms.AssignmentTH.Hw4_21002139.ex4;

import DataStructureAndAlgorithms.AssignmentTH.Hw4_21002139.ex1.LinkedListStack;
import DataStructureAndAlgorithms.AssignmentTH.Hw4_21002139.ex1.StackInterface;
import DataStructureAndAlgorithms.AssignmentTH.Hw4_21002139.ex2.LinkedListQueue;
import DataStructureAndAlgorithms.AssignmentTH.Hw4_21002139.ex2.QueueInterface;

public class Palindrome {
    public static boolean isPalindrome(String str) {
        // Create a stack and a queue
        StackInterface<Character> stack = new LinkedListStack<>();
        QueueInterface<Character> queue = new LinkedListQueue<>();

        // Add characters (is a letter or a digit) to the stack and queue
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                ch = Character.toLowerCase(ch);
                stack.push(ch);
                queue.enqueue(ch);
            }
        }

        // Compare characters from the stack and queue
        while (!stack.isEmpty()) {
            if (stack.pop() != queue.dequeue()) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        // String str = "abc c,b*a";
        // System.out.println(isPalindrome(str)); // prints "true"

//        String str = "dad d9ad";
//        System.out.println(isPalindrome(str)); // prints "false"

        String str = "";
        System.out.println(isPalindrome(str)); // prints "false"
    }
}
