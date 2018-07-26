package com.eprogrammerz.examples.ds.custom.stack;

import java.util.EmptyStackException;

/**
 * @author Yogen Rai
 */
public class MyStack<T> {
    static class StackNode<T> {
        T data;
        StackNode next;

        StackNode(T data) {
            this.data = data;
            next = null;
        }
    }

    private StackNode<T> top;

    private int size;

    void push(T data) {
        StackNode newNode = new StackNode(data);

        newNode.next = top;

        top = newNode;

        size++;
    }

    T pop() {
        if (top == null) {
            throw new EmptyStackException();
        }
        T t = top.data;
        top = top.next;
        size--;
        return t;
    }

    T peek() {
        if (top == null) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    boolean isEmpty() {
        return top == null;
    }

    int size() {
        return size;
    }
}
