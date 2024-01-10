package com.oop.collection.mylist;

public class MyArrayList extends MyAbstractList{
    static final int INITIALSIZE = 16;
    Object[] elements;
    int size;

    public MyArrayList() {
        this.elements = new Object[INITIALSIZE];
        this.size = 0;
    }

    @Override
    public void add(Object o){
        if (size >= elements.length - 1){
            enlarge();
        }
        elements[size++] = o;
    }

    @Override
    public void add(Object o, int index){
        if (size >= elements.length - 1){
            enlarge();
        }
        try{
            checkBoundaries(index, size);
            for (int i = size; i > index; i--){
                elements[i] = elements[i - 1];
            }
            elements[index] = o;
            size++;
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Can't add " + o + " into list.");
        }
    }

    @Override
    public Object get(int index){
        try {
            checkBoundaries(index, size - 1);
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Can't get item from list.");
        }
        return elements[index];
    }
    @Override
    public void remove(int index){
        try{
            checkBoundaries(index, size);
            for (int i = index; i < size; i++){
                elements[i] = elements[i + 1];
            }
            size--;
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Can't remove item from list.");
        }
    }

    @Override
    public int size(){
        return this.size;
    }

    void enlarge(){
        Object[] tmp = new Object[elements.length * 2];
        System.arraycopy(elements, 0, tmp, 0, elements.length);
        elements = tmp;
    }
}
