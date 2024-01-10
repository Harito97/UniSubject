package com.oop.collection.mylist;

public class MyLinkedList extends MyAbstractList{
    MyLinkedListNode head;
    int size;

    public MyLinkedList(){
        head = null;
        size = 0;
    }

    private MyLinkedListNode getNodeByIndex(int index){
        MyLinkedListNode current = head;
        for (int i = 1; i <= index; i++){
            current = current.getNext();
        }
        return current;
    }

    @Override
    public void add(Object o){
        add(o, size);
    }

    @Override
    public void add(Object o, int index){
        try{
            checkBoundaries(index, size);
            if (index == 0){
                head = new MyLinkedListNode(o, head);
            } else {
                MyLinkedListNode current = getNodeByIndex(index - 1);
                current.setNext(new MyLinkedListNode(o, current.getNext()));
            }
            size++;
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Can't add " + o + " into list.");
        }
    }

    @Override
    public Object get(int index){
        MyLinkedListNode current = getNodeByIndex(index);
        return current.getPayload();
    }

    @Override
    public void remove(int index){
        try{
            checkBoundaries(index, size);
            if (index == 0){
                head = new MyLinkedListNode(head);
            } else {
                head = getNodeByIndex(index + 1);
                head.setNext(new MyLinkedListNode(head.getNext()));
            }
            size--;
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Can't remove.");
        }
    }

    @Override
    public int size(){
        return size;
    }
}
