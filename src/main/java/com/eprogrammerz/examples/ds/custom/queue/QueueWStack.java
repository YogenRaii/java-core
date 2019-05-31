package com.eprogrammerz.examples.ds.custom.queue;

import java.util.Stack;


public class QueueWStack<T> {
    private Stack<T> s1;
    private Stack<T> s2;

    public QueueWStack() {
        this.s1 = new Stack<>();
        this.s2 = new Stack<>();
    }

    public void enqueue(T t) {
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
        s1.push(t);
    }

    public T dequeue() {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        return s2.pop();
    }

    public T peek() {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        return s2.peek();
    }
}
