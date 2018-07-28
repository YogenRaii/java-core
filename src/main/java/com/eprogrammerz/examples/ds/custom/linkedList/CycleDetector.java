package com.eprogrammerz.examples.ds.custom.linkedList;

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

        Node current = head, fast = head, faster = head;

        while (current != null && fast.next != null && faster.next != null) {
            fast = faster.next;
            faster = fast.next;

            if (current == fast || current == faster) return true;

            current = current.next;
        }
        return false;
    }
}

