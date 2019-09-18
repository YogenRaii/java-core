package com.eprogrammerz.examples.ds.custom.linkedList;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RotateList {
    public ListNode rotateRight(ListNode A, int B) {
        // find size so that we can find the node for the head in resulting list
        int size = getSize(A);

        ListNode node = A;
        ListNode prev = node;
        ListNode firstHalf = prev;

        for (int i = 0; i < size; i++) {
            prev = node; // prev = 3
            node = node.next; // node = 4
            int newIdx = (i + B + 1) % size;
            if (newIdx == 0) {
                break;
            }
        }
        prev.next = null;
        ListNode half = node;
        ListNode head = node;

        if (half != null) {
            while (half.next != null) {
                half = half.next;
            }
            half.next = firstHalf;
        } else {
            head = firstHalf;
        }

        return head;
    }

    private int getSize(ListNode node) {
        ListNode n = node;
        int size = 0;
        while (n != null) {
            size++;
            n = n.next;
        }
        return size;
    }

    @Test
    public void testRotateRight() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);
        ListNode n8 = new ListNode(8);
        ListNode n9 = new ListNode(9);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;

        ListNode res = rotateRight(n1, 3); // (7)(8)(9)(1)(2)(3)(4)(5)(6)
        assertEquals(7, res.val);
    }
}
