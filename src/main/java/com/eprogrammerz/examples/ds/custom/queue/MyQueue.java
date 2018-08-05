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

    private QueueNode<T> first;

    private QueueNode<T> last;

    void enqueue(T data) {
        QueueNode<T> node = new QueueNode<>(data);
        if (last != null) {
            last.next = node;
        }

        last = node;

        if (first == null) {
            first = last;
        }
    }

    T dequeue() {
        if (first == null) throw new NoSuchElementException();
        T data =first.data;

        first = first.next;

        if (first == null) {
            last = null;
        }
        return data;
    }

    T peek() {
        if (first == null) throw new NoSuchElementException();

        return first.data;
    }

    boolean isEmpty() {
        return first == null;
    }
}
