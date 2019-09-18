package com.eprogrammerz.examples.ds.custom.linkedList;

import org.junit.Test;

import java.util.List;

import static com.eprogrammerz.examples.ds.custom.linkedList.ListUtil.printList;
import static org.junit.Assert.assertEquals;

/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 *
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 *
 * return 1->4->3->2->5->NULL.
 */
public class ReverseListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head.next == null) return head;

        /**
         * Get first half f1 (0 -> m - 1)
         * Traverse and create reversed list (m -> n) mid
         * f1.next = mid
         */

        ListNode tracker = head;
        ListNode f1Tail = head;

        ListNode resultHead = tracker;
        for (int i = 1; i < m; i++) {
            f1Tail = tracker;
            tracker = tracker.next;
        }


        ListNode next = tracker.next;

        ListNode midHead = tracker;
        midHead.next = null;

        ListNode midTail = tracker;
        for (int i = m; i < n; i++) {
            ListNode temp = midHead;
            ListNode nextTemp = next.next;
            midHead = next;
            midHead.next = temp;
            next = nextTemp;
        }

        midTail.next = next;
        f1Tail.next = midHead;

        return resultHead;
    }

    public ListNode reverse(ListNode node) {
        if (node == null) return null;

        ListNode current = node;

        ListNode next = current.next;

        current.next = null;

        while (next != null) {
            ListNode temp = next.next;
            next.next = current;
            current = next;
            next = temp;
        }
        return current;
    }

    @Test
    public void testReverse() {
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

        ListNode res = reverseBetween(n1, 2, 4);
        assertEquals("1 -> 4 -> 3 -> 2 -> 5 -> 6 -> 7 -> 8 -> 9", printList(res));
    }

    @Test
    public void testReverse2() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;

        ListNode res = reverseBetween(n1, 2 ,3);
        assertEquals("1 -> 3 -> 2", printList(res));
    }
}
