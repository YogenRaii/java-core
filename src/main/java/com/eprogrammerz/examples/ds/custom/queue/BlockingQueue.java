package com.eprogrammerz.examples.ds.custom.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * https://leetcode.com/problems/design-bounded-blocking-queue/
 */
public class BlockingQueue {
    class BoundedBlockingQueue {
        private Queue<Integer> q;
        private int capacity;
        private ReentrantLock lock = new ReentrantLock();
        private Condition full = lock.newCondition();
        private Condition empty = lock.newCondition();


        public BoundedBlockingQueue(int capacity) {
            this.capacity = capacity;
            this.q = new LinkedList<>();
        }

        public void enqueue(int element) throws InterruptedException {
            lock.lock();
            try {
                while (q.size() >= capacity) full.await();

                q.add(element);

                empty.signalAll();
            } finally {
                if (lock.isLocked()) lock.unlock();
            }
        }

        public int dequeue() throws InterruptedException {
            lock.lock();
            int val;
            try {
                while (size() == 0) {
                    empty.await();
                }

                val = q.poll();

                full.signalAll();
            } finally {
                if (lock.isLocked()) lock.unlock();
            }
            return val;
        }

        public int size() {
            return q.size();
        }
    }
}
