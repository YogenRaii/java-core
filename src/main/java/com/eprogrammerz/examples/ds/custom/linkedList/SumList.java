package com.eprogrammerz.examples.ds.custom.linkedList;

import org.junit.Test;

import static com.eprogrammerz.examples.ds.custom.linkedList.ListUtil.printList;
import static org.junit.Assert.assertEquals;

public class SumList {
    public Node sumList(Node h1, Node h2) {
        Node result = null;

        Node carrier = null;

        int carry = 0;

        while (h1 != null || h2 != null || carry > 0) {
            int sum = carry;

            if (h1 != null) {
                sum += h1.data;
                h1 = h1.next;
            }

            if (h2 != null) {
                sum += h2.data;
                h2 = h2.next;
            }

            if (sum > 9) {
                sum = sum % 10;
                carry = 1;
            } else {
                carry = 0;
            }
            Node node = new Node(sum);

            if (result == null) {
                result = node;
                carrier = result;
            } else {
                carrier.next = node;
                carrier = carrier.next;
            }
        }

        return result;
    }

    @Test
    public void testSumList() {
        // 617
        // presented in reverse order 7 -> 1 -> 6
        Node n1 = new Node(7);
        Node n2 = new Node(1);
        Node n3 = new Node(6);
        n1.next = n2;
        n2.next = n3;

        // 295
        // 5 -> 9 -> 2
        Node na = new Node(5);
        Node nb = new Node(9);
        Node nc = new Node(2);
        na.next = nb;
        nb.next = nc;

        Node sum = sumList(n1, na); // 912

        while (sum != null) {
            System.out.print(sum.data);
            sum = sum.next;
        }
        // prints 219
    }

    /**
     * You are given two non-empty linked lists representing two non-negative integers.
     * The digits are stored in reverse order and each of their nodes contain a single digit.
     * Add the two numbers and return it as a linked list.
     *
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     *
     * Example:
     *
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 0 -> 8
     * Explanation: 342 + 465 = 807.
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;

        ListNode result = new ListNode(-1);

        ListNode last = result;

        while(l1 != null || l2 != null) {
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            int sum = x + y + carry;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            carry = sum / 10;
            sum = sum % 10;

            last.next = new ListNode(sum);
            last = last.next;
        }

        if(carry != 0) {
            last.next = new ListNode(carry);
        }
        return result.next;
    }

    @Test
    public void testSumList2() {
        // 617
        // presented in reverse order 7 -> 1 -> 6
        ListNode n1 = new ListNode(7);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(6);
        n1.next = n2;
        n2.next = n3;

        // 295
        // 5 -> 9 -> 2
        ListNode na = new ListNode(5);
        ListNode nb = new ListNode(9);
        ListNode nc = new ListNode(2);
        na.next = nb;
        nb.next = nc;

        ListNode sum = addTwoNumbers(n1, na); // 912
        assertEquals("2 -> 1 -> 9", printList(sum));
    }
}
