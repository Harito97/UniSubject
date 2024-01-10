package DataStructureAndAlgorithms.SelfLearning.DataStructures.List.Stack;

import DataStructureAndAlgorithms.SelfLearning.DataStructures.List.SimplyLinkedList.SimplyLinkedList;

public class LinkedStack<E> implements Stack<E> { 
    private SimplyLinkedList<E> list = new SimplyLinkedList<>( ); // an empty list
    
    public LinkedStack( ) { } // new stack relies on the initially empty list
    public int size( ) { 
        return list.size( ); 
    }
    public boolean isEmpty( ) { 
        return list.isEmpty( ); 
    } 
    public void push(E element) { 
        list.addFirst(element); 
    } 
    public E top( ) { 
        return list.get(0); 
    } 
    public E pop( ) { 
        return list.removeFirst( ); 
    }

    public static void main(String[] args) {
        Stack<Integer> S = new LinkedStack<>( ); // contents: ()
        S.push(5); // contents: (5)
        S.push(3); // contents: (5, 3)
        System.out.println(S.size( )); // contents: (5, 3) outputs 2
        System.out.println(S.pop( )); // contents: (5) outputs 3
        System.out.println(S.isEmpty( )); // contents: (5) outputs false
        System.out.println(S.pop( )); // contents: () outputs 5
        System.out.println(S.isEmpty( )); // contents: () outputs true
        System.out.println(S.pop( )); // contents: () outputs null
        S.push(7); // contents: (7)
        S.push(9); // contents: (7, 9)
        System.out.println(S.top( )); // contents: (7, 9) outputs 9
        S.push(4); // contents: (7, 9, 4)
        System.out.println(S.size( )); // contents: (7, 9, 4) outputs 3
        System.out.println(S.pop( )); // contents: (7, 9) outputs 4
        S.push(6); // contents: (7, 9, 6)
        S.push(8); // contents: (7, 9, 6, 8)
        System.out.println(S.pop( )); // contents: (7, 9, 6) outputs 8
    }
}