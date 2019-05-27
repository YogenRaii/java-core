package com.eprogrammerz.examples.ds.custom.queue;

import java.util.NoSuchElementException;

/**
 * @author Yogen Rai
 *
 * FIFO
 */
public class MyQueue<T> {
    static class QueueNode<T> {
        T data;
        QueueNode next;

        QueueNode(T data) {
            this.data = data;
            this.next = null;
        }

        @Override
        public String toString() {
            return "(" + data + ")";
        }
    }

    private QueueNode<T> front;

    private QueueNode<T> back;

    void enqueue(T data) {
        QueueNode<T> node = new QueueNode<>(data);
        if (back != null) {
            back.next = node;
        }

        back = node;

        if (front == null) {
            front = back;
        }
    }

    T dequeue() {
        if (front == null) throw new NoSuchElementException();
        T data =front.data;

        front = front.next;

        if (front == null) {
            back = null;
        }
        return data;
    }

    T peek() {
        if (front == null) throw new NoSuchElementException();

        return front.data;
    }

    boolean isEmpty() {
        return front == null;
    }
}
