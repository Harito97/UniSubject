package com.mylist;

public class MyLinkedNode {
    //Attributes
    Object payload;
    MyLinkedNode next;

    //Constructor
    public MyLinkedNode(Object payload) {
        this.payload = payload;
    }

    public MyLinkedNode(Object payload, MyLinkedNode next) {
        this.payload = payload;
        this.next = next;
    }

    //Setters, Getters
    public Object getPayload() {
        return payload;
    }

    public void setPayload(Object payload) {
        this.payload = payload;
    }

    public MyLinkedNode getNext() {
        return next;
    }

    public void setNext(MyLinkedNode next) {
        this.next = next;
    }
}
