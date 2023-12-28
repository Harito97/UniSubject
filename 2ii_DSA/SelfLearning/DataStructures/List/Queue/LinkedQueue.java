package DataStructureAndAlgorithms.SelfLearning.DataStructures.List.Queue;

import DataStructureAndAlgorithms.SelfLearning.DataStructures.List.SimplyLinkedList.SimplyLinkedList;

/* Realization of a FIFO queue as an adaptation of a SinglyLinkedList. */ 
public class LinkedQueue<E> implements Queue<E> {
    private SimplyLinkedList<E> list = new SimplyLinkedList<>( ); // an empty list

    public LinkedQueue( ) { } // new queue relies on the initially empty list
    public int size( ) { return list.size( ); }
    public boolean isEmpty( ) { return list.isEmpty( ); } 
    public void enqueue(E element) { list.addLast(element); } 
    public E first( ) { return list.get(0); } 
    public E dequeue( ) { return list.removeFirst( ); }
}
