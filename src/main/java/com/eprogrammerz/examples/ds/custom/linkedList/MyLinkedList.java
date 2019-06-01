package com.eprogrammerz.examples.ds.custom.linkedList;

public class MyLinkedList<T> {
    private Node<T> head;
    private int size;

    public MyLinkedList() {}

    public void addFirst(T t) {
        this.head = new Node<>(t, this.head);
        size++;
    }

    public T getFirst() {
        if (this.head == null) return null;
        return this.head.data;
    }

    public void addLast(T t) {
        Node<T> node = new Node<>(t);
        if (head == null) {
            head = node;
        }

        Node<T> current = head;

        while (current.next != null) {
            current = current.next;
        }
        current.next = node;

        // increment size
        size++;
    }

    public T getLast() {
        if (head == null) return null;
        Node<T> node = head;

        while (node.next != null) {
            node = node.next;
        }
        return node.data;
    }

    public T getAt(int idx) {
        if (head == null) return null;

        Node<T> node = head;
        int counter = 0;
        while (node != null) {
            if (counter == idx) return node.data;
            node = node.next;
            counter++;
        }

        return null;
    }

    public boolean insertAt(int idx, T t) {
        if (head == null) return false;

        Node<T> newNode = new Node<>(t);

        Node<T> node = head;
        Node<T> prev = head;

        int counter = 0;
        while (node != null) {
            if (counter == idx) {
                newNode.next = node;
                prev.next = newNode;
                size++;
                return true;
            }
            prev = node;
            node = node.next;
            counter++;
        }
        return false;
    }

    public void removeAt(int idx) {
        if (head == null) return;

        Node<T> prev = head;
        Node<T> node = head;

        int counter = 0;

        while (node != null) {
            if (counter == idx) {
                prev.next = node.next;
                size--;
            }
            counter++;
            prev = node;
            node = node.next;
        }
    }

    /**
     * Return mid element of linked list
     * If there is two mid element, return last element of first half
     * eg.
     * 1 2 3 -> 2
     * 1 2 3 4 -> 2
     * @return mid element
     */

    public T midElement() {
        if (head == null) return null;

        Node<T> runner = head;
        Node<T> node = head;

        while (runner.next != null && runner.next.next != null) {
            runner = runner.next.next;
            node = node.next;
        }
        return node.data;
    }

    public int size() {
        return size;
    }

    private class Node<T> {
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return "(" + data + ")";
        }
    }
}
