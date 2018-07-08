package com.eprogrammerz.examples.general.inheritance.drawbacks;

import java.util.Vector;

/**
 * Created by Yogen on 3/2/2017.
 */
public class InheritanceISAviolate2 {
    public static void main(String[] args) {
        Vector<Integer> myVector = new MyVector<>();
//        myVector.addElement();
    }
}

class MyVector<T> extends Vector<T> {
    public void addElement(T t){}
}

class MyVectorComp<T> {
    private Vector<T> vector = new Vector<T>();
    public void addElement(T t) {}
}