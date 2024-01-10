package com.mylist;

public abstract class MyAbstractList implements MyList {
    public MyAbstractList(){}

    public boolean checkBoundaries(int index, int limit){
        return (index >= 0 && index <= limit);
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < size(); i++){
            result = result + "[" + get(i) + "]";
        }
        return result;
    }
}
