package com.eprogrammerz.examples.ds.custom.linkedList;

/**
 * @author Yogen Rai
 *
 * Return Kth to Last: Implement an algorithm to find the kth to last element of a singly linked list.
 */
public class KthLastElement {
    // recursive
    public static Node findKthLastElement(Node head, int k) {
        Node kthNode = new Node(Integer.MAX_VALUE);
        findKthLastNode(head, k, kthNode);
        return kthNode.data == Integer.MAX_VALUE ? null : kthNode;
    }

    private static int findKthLastNode(Node head, int k, Node kthNode) {
        if (head == null) {
            return 0;
        }

        int indexFromLast = findKthLastNode(head.next, k, kthNode) + 1;
        if (indexFromLast == k) {
            kthNode.data = head.data;
            kthNode.next = head.next;
        }
        return indexFromLast;
    }

    // iterative
    public static Node findKthNodeIterative(Node head, int k) {
        Node p1 = head;
        Node p2 = head;

        // move p1 to k ahead
        for (int i = 0; i < k; i++) {
            if (p1 == null) return null;
            p1 = p1.next;
        }

        // now loop over until p1 is null and value of p2 at that moment is required node
        while (p1 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        return p2;
    }

    public static void main(String[] args) {
        // 1 -> 2 -> 3  -> 4 -> 5 -> 6
        Node head = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        Node node5 = new Node(6);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        System.out.println(findKthNodeIterative(head, 7));
    }
}
