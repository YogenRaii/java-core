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
 *
 * https://leetcode.com/problems/reverse-linked-list-ii/
 */
public class ReverseListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode prev = null;
        ListNode next = null;

        // if m == 1, then head needed to be updated

        int i = 1;

        ListNode runner = head;
        while (runner != null) {
            if (i == m - 1) {
                prev = runner;
            }

            if (i == n) {
                next = runner.next;
                break;
            }

            runner = runner.next;
            i++;
        }


        ListNode part = prev == null ? head: prev.next;

        if (prev != null)
            prev.next = null;

        runner.next = null;

        ListNode rhead = reverse(part);

        if (prev != null)
            prev.next = rhead;
        else head = rhead;

        while (rhead.next != null) {
            rhead = rhead.next;
        }

        rhead.next = next;

        return head;
    }

    private ListNode reverse(ListNode head) {
        if (head.next == null) return head;

        ListNode node = reverse(head.next);

        head.next.next = head;
        head.next = null;

        return node;
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
