package com.eprogrammerz.examples.ds.custom.linkedList;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class PalindromeCheck {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return false;
        boolean isEven = isEven(head);

        ListNode mid = mid(head);

        ListNode l2 = mid.next;
        mid.next = null;
        ListNode l1 = reverse(head);

        if (!isEven) l1 = l1.next;

        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) return false;
            l1 = l1.next;
            l2 = l2.next;
        }

        if (l1 != null || l2 != null) return false;
        return true;
    }

    private ListNode reverse(ListNode node) {
        if (node == null) return node;
        ListNode prev = null;
        while (node != null) {
            ListNode temp = node.next;
            node.next = prev;
            prev = node;
            node = temp;
        }
        return prev;
    }

    private boolean isEven(ListNode node) {
        if (node == null) return false;

        ListNode slow = node;
        ListNode fast = node.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return fast != null;
    }

    private ListNode mid(ListNode node) {
        if (node == null) return null;

        ListNode slow = node;
        ListNode fast = node.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    @Test
    public void testPalindrome1() {
        // 7 -> 2 -> 5 -> 3 -> 5 -> 2 -> 7
        ListNode head = new ListNode(7);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(2);
        ListNode node6 = new ListNode(7);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        assertTrue(isPalindrome(head));
    }

    @Test
    public void testPalindrome2() {
        // 7 -> 2 -> 2 -> 7
        ListNode head = new ListNode(7);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(7);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        assertTrue(isPalindrome(head));
    }

    @Test
    public void testPalindrome3() {
        // 7 -> 2 -> 2 -> 7
        ListNode head = new ListNode(7);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        assertFalse(isPalindrome(head));
    }
}
