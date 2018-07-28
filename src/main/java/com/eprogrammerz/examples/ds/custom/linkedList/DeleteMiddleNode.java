package com.eprogrammerz.examples.ds.custom.linkedList;

/**
 * @author Yogen Rai
 *
 * Delete Middle Node: Implement an algorithm to delete a node in the middle
 * (Le., any node but the first and last node, not necessarily the exact middle) of a singly linked list
 */
public class DeleteMiddleNode {
    public static Node deleteMiddleNode(Node head) {
        Node runner = head;
        Node prev = head;
        // find middle element
        // when runner is at end, then head is middle node
        while (runner.next != null) {
            if (runner.next.next != null) {
                runner = runner.next.next;
            } else {
                runner = runner.next;
            }

            prev = head;
            head = head.next;
        }
        Node deletedNode = head;
        // delete the node
        prev.next = head.next;
        return deletedNode;
    }

    public static void main(String[] args) {
        // 1 -> 2 -> 3  -> 4 -> 5 -> 6 -> 7
        Node head = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        Node node5 = new Node(6);
        Node node6 = new Node(7);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        System.out.println(deleteMiddleNode(head));

        while (head != null) {
            System.out.println(head);
            head = head.next;
        }
    }
}
