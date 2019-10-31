package com.eprogrammerz.examples.ds.custom.linkedList;

import org.junit.Test;

import static com.eprogrammerz.examples.ds.custom.linkedList.ListUtil.printList;
import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/add-two-numbers-ii/
 * <p>
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
 */
public class AddTwoNumII {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = 0;
        int len2 = 0;
        ListNode h1 = l1;
        while (h1 != null) {
            len1++;
            h1 = h1.next;
        }

        ListNode h2 = l2;
        while (h2 != null) {
            len2++;
            h2 = h2.next;
        }
        ListNode sum = traverse(l1, l2, len1, len2);
        return sum.val == 0 ? sum.next: sum;
    }

    private ListNode traverse(ListNode l1, ListNode l2, int len1, int len2) {
        if (l1 == null && l2 == null) return new ListNode(0);
        ListNode next;
        int sum;
        if (len1 == len2) {
            next = traverse(l1.next, l2.next, len1 - 1, len2 - 1);
            sum = l1.val + l2.val + next.val;
        } else if (len1 > len2) {
            next = traverse(l1.next, l2, len1 - 1, len2);
            sum = l1.val + next.val;
        } else {
            next = traverse(l1, l2.next, len1, len2 - 1);
            sum = l2.val + next.val;
        }

        ListNode node = new ListNode(sum / 10);
        next.val = sum % 10;

        node.next = next;

        return node;
    }

    @Test
    public void test() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(8);
        n1.next = n2;
        n2.next = n3;

        ListNode m1 = new ListNode(2);
        ListNode m2 = new ListNode(4);
        m1.next = m2;

        ListNode sum = addTwoNumbers(n1, m1);
        assertEquals("1 -> 6 -> 2", printList(sum));
    }
}
