package com.eprogrammerz.examples.ds.custom.linkedList;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * @author Yogen Rai
 *
 * This method is also dependent on Floyd’s Cycle detection algorithm.
1) Detect Loop using Floyd’s Cycle detection algo and get the pointer to a loop node.
2) Count the number of nodes in loop. Let the count be k.
3) Fix one pointer to the head and another to kth node from head.
4) Move both pointers at the same pace, they will meet at loop starting node.
 */
public class CycleDetector {
    boolean hasCycle(Node head) {
        if (head == null) return false;

        Node node = head, runner = head;

        while (runner.next != null && runner.next.next != null) {
            runner = runner.next.next;
            node = node.next;

            if (runner == node) return true;  // reference should be compared
        }
        return false;
    }

    @Test
    public void testCycleDetector() {
        Node n1 = new Node(1); // 1
        Node n2 = new Node(2, n1); // 2 -> 1
        Node n3 = new Node(3, n2); // 3 -> 2 -> 1
        Node n4 = new Node(4, n3); // 4 -> 3 -> 2 -> 1
        Node n5 = new Node(5, n4); // 5 -> 4 -> 3 -> 2 -> 1

        // till now no cycle
        assertFalse(hasCycle(n5));

        // now last node points to first node
        n1.next = n5;
        assertTrue(hasCycle(n5));

        // reset
        n1.next = null;
        assertFalse(hasCycle(n5));

        n1.next = n3;
        assertTrue(hasCycle(n5));
    }
}

