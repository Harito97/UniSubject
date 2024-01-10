package com.mylist;

public interface MyList {
    void add(Object o);
    void add(Object o, int x);
    Object get(int x);
    void remove(int x);
    int size();
}
