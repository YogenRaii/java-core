package com.eprogrammerz.examples.careercup;

/**
 * @author Yogen Rai
 *
 * Given two sorted linked lists, how can you combine them into one big sorted list? Do not create additional nodes.
 *
 */
public class CombineTwoLinkedList {
    public static Node combineLinkedList(Node h1, Node h2) {
        // pointer to hold the result
        Node result = null;

        // for not creating additional node
        if (h2.id > h1.id) {
            result = h1;
            h1 = h1.next;
        } else {
            result = h2;
            h2 = h2.next;
        }

        // pointer to track the current element
        Node current = result;

        while (h1 != null && h2 != null) {

            // if h2 > h1, then next of result would be h1
            if (h2.id > h1.id) {
                current.next = h1;
                current = current.next;
                h1 = h1.next;
            } else {
                // need to update result pointer
                current.next = h2;
                current = current.next;
                h2 = h2.next;
            }
        }

        if (h1 != null) {
            while (h1 != null) {
                current.next = h1;
                current = current.next;
                h1 = h1.next;
            }
        }

        if (h2 != null) {
            while (h2 != null) {
                result.next = h2;
                current = current.next;
                h2 = h2.next;
            }
        }

        return result;
    }

    static class Node {
        int id;
        Node next;

        Node(int id) {
            this.id = id;
            this.next = null;
        }

        @Override
        public String toString() {
            return "(" + id + ")";
        }
    }

    public static void main(String[] args) {
        // 2 -> 4 -> 7 -> 10
        Node h1 = new Node(2);
        h1.next = new Node(4);
        h1.next.next = new Node(7);
        h1.next.next.next = new Node(10);

        // 1 -> 5 -> 6
        Node h2 = new Node(1);
        h2.next = new Node(5);
        h2.next.next = new Node(6);

        Node result = combineLinkedList(h1, h2);

        // printing result
        while (result != null) {
            System.out.println(result);
            result = result.next;
        }
    }
}
