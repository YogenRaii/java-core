package com.eprogrammerz.examples.general.inheritance.drawbacks;

import java.util.ArrayList;

/**
 * Created by Yogen on 3/2/2017.
 */
public class InheritanceISAviolate {
    public static void main(String[] args) {
        //here LSP is being violated
        ArrayList<Integer> integers = new Stack<>();
//        integers.push(); //violates the ISA relationship
    }
}

class Stack<T> extends ArrayList<T> {
    private int stackPointer = 0;

    public void push(T article) {
        add(stackPointer, article);
        stackPointer++;
    }

    public T pop() {
        return remove(--stackPointer);
    }
}