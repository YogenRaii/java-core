package com.eprogrammerz.examples.ds.custom.linkedList;

import org.junit.Test;

public class SwapPair {
    public ListNode swapPairs(ListNode A) {
        // temp = current.next
        // prev.next = current.next
        // current.next = prev
        // current = temp

        ListNode prev = null;
        ListNode head = A.next;
        if (head == null) return A;

        ListNode current = A;
        while (current != null && current.next != null) {

            ListNode temp = current.next;
            current.next = current.next.next;
            temp.next = current;
            if (prev != null) prev.next = temp;
            prev = current;
            current = current.next;
        }
        return head;
    }

    @Test
    public void testSwapPair() {
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
        ListNode node = swapPairs(n1);
        System.out.println(node);
    }
}
