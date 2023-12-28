package DataStructureAndAlgorithms.SelfLearning.DataStructures.List.Stack;

public interface Stack<E> {

    //Returns the number of elements in the stack
    int size();
    //Tests whether the stack is empty
    public boolean isEmpty();
    //Inserts an element at the top of the stack
    public void push(E element);
    //Returns, but does not remove, the element at the top
    public E top();
    //Removes and returns the top element from the stack
    public E pop();
    
}