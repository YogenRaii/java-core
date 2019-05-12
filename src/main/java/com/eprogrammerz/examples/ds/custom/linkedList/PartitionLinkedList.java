package com.eprogrammerz.examples.ds.custom.linkedList;

import org.junit.Test;

/**
 * @author Yogen Rai
 *
 * Partition: Write code to partition a linked list around a value x,
 * such that all nodes less than x come before all nodes greater than or equal to x.
 * If x is contained within the list, the values of x only need to be after the elements less than x (see below).
 * The partition element x can appear anywhere in the "right partition";
 * it does not need to appear between the left and right partitions.
 */
public class PartitionLinkedList {

    /**
     * compare value of current node with x and if the value is greater than x,
     * then swap the value with next smaller value than x
     */
    public static Node partitionList(Node head, int partition) {
        Node original = head;

        while (head != null) {
            Node runner = head;
            // runner data is greater or equal to partition, run
            // over the remaining list and swap with nearest smaller node
            if (runner.data >= partition) {
                while (runner.next != null) {
                    runner = runner.next;
                    if (runner.data < partition) {
                        int temp = head.data;
                        head.data = runner.data;
                        runner.data = temp;
                        break;
                    }
                }
            }
            head = head.next;
        }
        return original;
    }

    // create two linked list for less and greater and join them
    public static Node partitionListBetter(Node head, int partition) {
        Node original = head;
        Node less = null;
        Node lessHead = null;
        Node greater = null;
        Node greaterHead = null;

        Node joiner = null;

        while (head != null) {
            Node tempNode = new Node(head.data);
            if (head.data < partition) {
                if (less == null) {
                    less = tempNode;
                    lessHead = less;
                } else {
                    less.next = tempNode;
                    less = less.next;
                }
            } else if (head.data > partition) {
                if (greater == null) {
                    greater = tempNode;
                    greaterHead = greater;
                } else {
                    greater.next = tempNode;
                    greater = greater.next;
                }
            } else {
                joiner = new Node(head.data);
            }
            head = head.next;
        }
        // if no joiner encountered, then it should return original list
        if (joiner == null) return original;


        if (lessHead == null) {
            joiner.next = greaterHead;
            greaterHead = joiner;
            return greaterHead;
        }

        // if there is no half, then return less + joiner
        if (greaterHead == null) {
            less.next = joiner;
            return lessHead;
        }

        joiner.next = greaterHead;
        less.next = joiner;
        return lessHead;
    }

    @Test
    public void testPartitionWithValidOne() {
        // 7 -> 2 -> 5  -> 3 -> 1 -> 6 -> 4
        Node head = new Node(7);
        Node node1 = new Node(2);
        Node node2 = new Node(5);
        Node node3 = new Node(3);
        Node node4 = new Node(1);
        Node node5 = new Node(6);
        Node node6 = new Node(4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

//        Node partitioned = partitionList(head, 5);
        Node partitioned = partitionListBetter(head, 5);

        // (2) (3) (1) (4) (5) (7) (6)
        while (partitioned != null) {
            System.out.print(partitioned + " ");
            partitioned = partitioned.next;
        }
        System.out.println();
    }

    @Test
    public void testPartitionWithNoValidOne() {
        // 7 -> 2 -> 5  -> 3 -> 1 -> 6 -> 4
        Node head = new Node(7);
        Node node1 = new Node(2);
        Node node2 = new Node(5);
        Node node3 = new Node(3);
        Node node4 = new Node(1);
        Node node5 = new Node(6);
        Node node6 = new Node(4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        Node partitioned = partitionListBetter(head, 10);

        // 7 -> 2 -> 5  -> 3 -> 1 -> 6 -> 4
        while (partitioned != null) {
            System.out.print(partitioned + " ");
            partitioned = partitioned.next;
        }
        System.out.println();
    }

    @Test
    public void testPartitionWithOnlyLess() {
        // 7 -> 2 -> 5  -> 3 -> 1 -> 6 -> 4
        Node head = new Node(7);
        Node node1 = new Node(2);
        Node node2 = new Node(5);
        Node node3 = new Node(3);
        Node node4 = new Node(1);
        Node node5 = new Node(6);
        Node node6 = new Node(4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

//        Node partitioned = partitionList(head, 5);
        Node partitioned = partitionListBetter(head, 1);

        // 1 -> 7 -> 2 -> 5  -> 3 -> 6 -> 4
        while (partitioned != null) {
            System.out.print(partitioned + " ");
            partitioned = partitioned.next;
        }
        System.out.println();
    }
}
