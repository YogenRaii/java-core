package com.eprogrammerz.examples.ds.custom.stack;

import java.util.EmptyStackException;

/**
 * How would you design a stack which, in addition to push and pop, has a function min which returns the minimum element? 
 * Push, pop and min should all operate in 0(1) time.
 *
 * stack.push(1) -> [1] and min = 1
 * stack.push(2) -> [2,1] and min = 1
 * stack.push(-1) -> [-1,2,1] and min = -1
 * stack.pop() -> [2,1] and min = 1
 */
public class MinStack {
    private class Node {
        int data;
        int min;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    private Node top;
    
    public void push(int data) {
        Node node = new Node(data);
        
        if (top == null) {
            node.min = data;
            top = node;
            return;
        }
        node.min = data > top.min ? top.min : data;
        node.next = top;
        top = node;
    }
    
    public int pop() {
        if (top == null) throw new EmptyStackException();
        
        Node node = top;
        top = top.next;
        return node.data;
    }

    public int peek() {
        if (top == null) throw new EmptyStackException();

        return top.data;
    }

    public int min() {
        if (top == null) throw new EmptyStackException();

        return top.min;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
