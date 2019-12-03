package com.eprogrammerz.examples.ds.custom.linkedList;


import org.junit.Test;

import static com.eprogrammerz.examples.ds.custom.linkedList.ListUtil.printList;
import static org.junit.Assert.assertEquals;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 * Example 1:
 *
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 */
public class SortLinkedList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode left = findMid(head);

        ListNode right = left.next;
        left.next = null;

        left = sortList(head);
        right = sortList(right);

        // now merge left and right
        ListNode dummy = new ListNode( - 1);
        ListNode runner = dummy;

        while (left != null && right != null) {
            if (left.val <= right.val) {
                runner.next = left;
                left = left.next;
            } else {
                runner.next = right;
                right = right.next;
            }
            runner = runner.next;
        }

        if (left != null) {
            runner.next = left;
        }

        if (right != null) {
            runner.next = right;
        }

        return dummy.next;
    }

    private ListNode findMid(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    @Test
    public void test1() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(8);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(6);
        ListNode n6 = new ListNode(5);
        ListNode n7 = new ListNode(7);
        ListNode n8 = new ListNode(2);
        ListNode n9 = new ListNode(9);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;

        ListNode res = sortList(n1);
        assertEquals("1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9", printList(res));
    }

    @Test
    public void test2() {
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(1);
        n1.next = n2;
        n2.next = n3;

        ListNode res = sortList(n1);
        assertEquals("1 -> 2 -> 3", printList(res));
    }

    @Test
    public void test3() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(-1);
        n1.next = n2;

        ListNode res = sortList(n1);
        assertEquals("-1 -> 1", printList(res));
    }
}
