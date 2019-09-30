package com.eprogrammerz.examples.ds.custom.linkedList;

import org.junit.Test;

import java.util.PriorityQueue;

import static com.eprogrammerz.examples.ds.custom.linkedList.ListUtil.printList;
import static org.junit.Assert.assertEquals;

public class MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        return mergeKLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeKLists(ListNode[] lists, int start, int end) {
        if (end == start)
            return lists[end];
        int mid = start + (end - start) / 2;
        ListNode a = mergeKLists(lists, start, mid);
        ListNode b = mergeKLists(lists, mid + 1, end);
        return mergeTwoList(a, b);
    }

    private ListNode mergeTwoList(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode dummy = new ListNode(-1);
        ListNode runner = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                runner.next = l2;
                runner = runner.next;
                l2 = l2.next;
            } else {
                runner.next = l1;
                runner = runner.next;
                l1 = l1.next;
            }
        }

        if (l1 != null) {
            runner.next = l1;
        }

        if (l2 != null) {
            runner.next = l2;
        }
        return dummy.next;
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

        ListNode[] lists = new ListNode[] { n1, m1};
        ListNode res = mergeKLists(lists);
        assertEquals("1 -> 2 -> 3 -> 4 -> 8", printList(res));
    }

    public ListNode mergeKListsPQ(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> pq = new PriorityQueue<>((n1, n2) -> n1.val - n2.val);

        ListNode dummy = new ListNode(-1);
        ListNode runner = dummy;

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                pq.add(lists[i]);
            }
        }

        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            runner.next = node;
            runner = runner.next;

            if (node.next != null) {
                pq.add(node.next);
            }
        }
        return dummy.next;
    }

    @Test
    public void testBetter() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(8);
        n1.next = n2;
        n2.next = n3;

        ListNode m1 = new ListNode(2);
        ListNode m2 = new ListNode(4);
        m1.next = m2;

        ListNode[] lists = new ListNode[] { n1, m1};
        ListNode res = mergeKListsPQ(lists);
        assertEquals("1 -> 2 -> 3 -> 4 -> 8", printList(res));
    }
}
