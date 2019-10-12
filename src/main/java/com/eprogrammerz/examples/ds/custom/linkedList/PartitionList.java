package com.eprogrammerz.examples.ds.custom.linkedList;

import org.junit.Test;

import static com.eprogrammerz.examples.ds.custom.linkedList.ListUtil.printList;
import static org.junit.Assert.assertEquals;

/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * Example:
 *
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
 */
public class PartitionList {
    /**
     * O(n) - time
     * O(1) - space
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        ListNode less = head;
        ListNode lessPrev = null;
        ListNode ge = head;
        ListNode gePrev = null;

        while (less != null && ge != null) {
            if(ge.val >= x) {
                if (less != ge && less.val < x) {
                    // change pointers
                    ListNode newLess = less.next;
                    lessPrev.next = less.next;
                    less.next = ge;

                    if (gePrev != null) {
                        gePrev.next = less;
                        gePrev = gePrev.next;
                    } else {
                        head = less;
                        gePrev = less;
                    }
                    less = newLess;
                } else {
                    lessPrev = less;
                    less = less.next;
                }
            } else {
                lessPrev = less;
                less = less.next;
                gePrev = ge;
                ge = ge.next;
            }
        }
        return head;
    }

    @Test
    public void test1() {
        // 1 -> 4 -> 3 -> 2 -> 5 -> 2
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(2);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        ListNode res = partition(n1, 3);
        assertEquals("1 -> 2 -> 2 -> 4 -> 3 -> 5", printList(res));
    }

    @Test
    public void test2() {
        // 1 -> 4 -> 3 -> 2 -> 5 -> 2 -> 7 -> 8 -> 9
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(2);
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

        ListNode res = partition(n1, 4);
        assertEquals("1 -> 3 -> 2 -> 2 -> 4 -> 5 -> 7 -> 8 -> 9", printList(res));
    }

    @Test
    public void test3() {
        // 2 -> 1
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ListNode res = partition(n1, 2);
        assertEquals("1 -> 1 -> 4 -> 3 -> 2", printList(res));
    }
}
