package com.eprogrammerz.examples.ds.custom.queue;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * https://leetcode.com/problems/design-circular-queue/
 */
public class CircularQueue {
    class MyCircularQueue {

        private int[] arr;
        private int head;
        private int tail;
        /** Initialize your data structure here. Set the size of the queue to be k. */
        public MyCircularQueue(int k) {
            this.arr = new int[k];
            Arrays.fill(this.arr, -1);
        }

        /** Insert an element into the circular queue. Return true if the operation is successful. */
        public boolean enQueue(int value) {
            if (isFull()) return false;

            if (tail == arr.length - 1) {
                tail = 0;
            }

            if (tail == 0 && arr[tail] == -1) {
                arr[0] = value;
                return true;
            }

            arr[++tail] = value;

            return true;
        }

        /** Delete an element from the circular queue. Return true if the operation is successful. */
        public boolean deQueue() {
            if (isEmpty()) return false;
            arr[head] = -1;
            if (head + 1 < arr.length && arr[head + 1] != -1) {
                head++;
            }
            if (head == arr.length) head = 0;
            return true;
        }

        /** Get the front item from the queue. */
        public int Front() {
            return isEmpty() ? -1 : arr[head];
        }

        /** Get the last item from the queue. */
        public int Rear() {
            return isEmpty() ? -1 : arr[tail];
        }

        /** Checks whether the circular queue is empty or not. */
        public boolean isEmpty() {
            return head == tail && arr[head] == -1;
        }

        /** Checks whether the circular queue is full or not. */
        public boolean isFull() {
            return (tail == arr.length - 1 && head == 0 && arr[tail] != -1 && arr[head] != -1)
                    || (tail + 1 == head && arr[tail] != -1 && arr[head] != -1);
        }
    }

    @Test
    public void test1() {
        MyCircularQueue queue = new MyCircularQueue(3);
        assertTrue(queue.enQueue(1));
        assertTrue(queue.enQueue(2));
        assertTrue(queue.enQueue(3));
        assertFalse(queue.enQueue(4));
        assertEquals(3, queue.Rear());
        assertTrue(queue.isFull());
        assertTrue(queue.deQueue());
        assertTrue(queue.enQueue(5));
        assertEquals(5, queue.Rear());
        assertEquals(2, queue.Front());
    }

    @Test
    public void test2() {
        MyCircularQueue queue = new MyCircularQueue(6);
        assertTrue(queue.enQueue(6));
        assertEquals(6, queue.Rear());
        assertTrue(queue.deQueue());
        assertTrue(queue.enQueue(4));
        assertEquals(4, queue.Rear());
        assertTrue(queue.deQueue());
        assertEquals(-1, queue.Front());
        assertFalse(queue.deQueue());
        assertFalse(queue.deQueue());
        assertFalse(queue.deQueue());
    }

    @Test
    public void test3() {
        MyCircularQueue queue = new MyCircularQueue(2);
        assertTrue(queue.enQueue(4));
        assertTrue(queue.enQueue(9));
        assertTrue(queue.deQueue());
        assertTrue(queue.deQueue());

        assertTrue(queue.enQueue(4));
        assertTrue(queue.enQueue(6));
    }
}
