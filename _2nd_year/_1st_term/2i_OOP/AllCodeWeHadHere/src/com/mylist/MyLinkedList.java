package com.mylist;

import com.oop.collection.mylist.MyLinkedListNode;

public class MyLinkedList extends MyAbstractList{
    //Attributes
    MyLinkedNode head;
    int size;

    //Constructor
    public MyLinkedList() {
        head = null;
        size = 0;
    }

    //Interface
    public void add(Object o){
        if (o instanceof MyAbstractList){
            size++;
            head.setPayload(((MyLinkedNode) o).payload);
            head.setNext(((MyLinkedNode) o).next);
        }
    }

    public void add(Object o, int index){
        if (checkBoundaries(index, size - 1)
                && o != null){
            size++;
            MyLinkedNode temp = new MyLinkedNode(o, getNodeByIndex(index));
        }
    }

    public Object get(int index){
        MyLinkedNode current = getNodeByIndex(index);
        return current.getPayload();
    }

    public void remove(int index){
        if (checkBoundaries(index, size - 1)){
            size--;
            getNodeByIndex(index - 1).setNext(getNodeByIndex(index + 1));
        }
    }

    public int size(){
        return size;
    }

    //Implementation
    private MyLinkedNode getNodeByIndex(int index){
        MyLinkedNode current = head;
        for (int i = 1; i <= index; i++){
            current = current.getNext();
        }
        return current;    }
}
