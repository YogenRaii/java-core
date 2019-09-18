package com.eprogrammerz.examples.ds.custom.linkedList;

import org.junit.Test;

import static com.eprogrammerz.examples.ds.custom.linkedList.ListUtil.printList;
import static org.junit.Assert.assertEquals;

/**
 * Given a singly linked list and an integer K, reverses the nodes of the
 *
 * list K at a time and returns modified linked list.
 *
 *  NOTE : The length of the list is divisible by K
 * Example :
 *
 * Given linked list 1 -> 2 -> 3 -> 4 -> 5 -> 6 and K=2,
 *
 * You should return 2 -> 1 -> 4 -> 3 -> 6 -> 5
 *
 * Try to solve the problem using constant extra space.
 */
public class KReverseLinkedList {
    public ListNode reverseList(ListNode head, int k) {

        ListNode current =  head;
        ListNode previous = null;
        ListNode next = null;

        if (isGroup(current, k)) {
            int count = k;
            while (count-- > 0 && current != null) {
                next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }
        } else {
            return head;
        }

        if (current != null) {
            if (isGroup(current, k)) {
                head.next = reverseList(current, k);
            } else {
                head.next = next;
            }
        }
        return previous == null ? current: previous;
    }

    private boolean isGroup(ListNode node, int k) {
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
            if (count == k) return true;
        }
        return false;
    }

    @Test
    public void testReverse1() {
        // 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 ->8 -> 9
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

        ListNode res = reverseList(n1, 2); // 2 -> 1 -> 4 -> 3 -> 6 -> 5 -> 8 -> 7 -> 9
        assertEquals("2 -> 1 -> 4 -> 3 -> 6 -> 5 -> 8 -> 7 -> 9", printList(res));
    }

    @Test
    public void testReverse2() {
        // 1 -> 2 -> 3 -> 4 -> 5
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ListNode res = reverseList(n1, 3); // 3 -> 2 -> 1 -> 4 -> 5
        assertEquals("3 -> 2 -> 1 -> 4 -> 5", printList(res));
    }

    @Test
    public void testReverse3() {
        // 1 -> 2
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;

        ListNode res = reverseList(n1, 3); // 1 -> 2
        assertEquals("1 -> 2", printList(res));
    }
}
