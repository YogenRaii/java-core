package com.eprogrammerz.examples.ds.custom.linkedList;

/**
 * @author Yogen Rai
 */
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    @Override
    public String toString() {
        return "(" + data + ")";
    }
}
