package com.eprogrammerz.examples.ds.custom.linkedList;

import org.junit.Test;

import static com.eprogrammerz.examples.ds.custom.linkedList.ListUtil.printList;
import static org.junit.Assert.assertEquals;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * e.g.  for a list 1-> 2 -> 3 -> 4, one should return the head of list as 2 -> 1 -> 4 -> 3.
 */
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
        assertEquals("2 -> 1 -> 4 -> 3 -> 6 -> 5 -> 8 -> 7 -> 9", printList(node));
    }

    public ListNode swapPairsRec(ListNode A) {
        // first swap two
        // call swap with A.next.next
        if (A == null || A.next == null) return A;

        ListNode temp = A.next.next;

        A.next.next = A;
        ListNode head = A.next;
        A.next = swapPairsRec(temp);
        return head;
    }

    @Test
    public void testSwapPairRec() {
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
        ListNode node = swapPairsRec(n1);
        assertEquals("2 -> 1 -> 4 -> 3 -> 6 -> 5 -> 8 -> 7 -> 9", printList(node));
    }
}
