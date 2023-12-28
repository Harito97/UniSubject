package com.mylist;

public class MyArrayList extends MyAbstractList{
    //Attributes
    static final int INITIAL_SIZE = 0;
    int size = INITIAL_SIZE;
    Object[] elements = new Object[size];

    //Constructor
    public MyArrayList() {
    }

    //APIs
    public void add(Object o){
        if (o instanceof MyAbstractList){
            if (size >= elements.length - 1){
                enlarge();
            }
            elements[size++] = o;
        }
    }

    public void add(Object o, int index){
        if (o instanceof MyAbstractList){
            if (size >= elements.length - 1){
                enlarge();
            }
            for (int i = elements.length - 1; i > index; i++){
                elements[i] = elements[i - 1];
            }
            elements[index] = o;
        }
    }

    public void enlarge(){
        size *= 2;
        Object[] temp = elements;
        elements = new Object[size];
        elements.c
    }
}
