package com.eprogrammerz.examples.ds.custom.linkedList;

import org.junit.Test;

import static com.eprogrammerz.examples.ds.custom.linkedList.ListUtil.printList;
import static org.junit.Assert.assertEquals;

public class RemoveNthNodeFromLast {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = head;

        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast != null && fast.next != null) {
            node = node.next;
            fast = fast.next;
        }

        if (fast == null) {
            head = head.next;
        } else {

            node.next = node.next != null ? node.next.next : null;
        }

        return head;
    }

    @Test
    public void testRemoveNthFromEnd1() {
// 1 -> 2 -> 3  -> 4 -> 5 -> 6
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode res = removeNthFromEnd(head, 2);
        assertEquals("1 -> 2 -> 3 -> 5", printList(res));
    }


    @Test
    public void testRemoveNthFromEnd2() {
        // 1 -> 2
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        head.next = node1;

        ListNode res = removeNthFromEnd(head, 2);
        assertEquals("2", printList(res));
    }

    @Test
    public void testRemoveNthFromEnd3() {
        // 1 -> 2
        ListNode head = new ListNode(1);

        ListNode res = removeNthFromEnd(head, 1);
        assertEquals("", printList(res));
    }
}
