package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/task-scheduler/
 */
public class TaskScheduler {
    /**
     * 1. count tasks
     * 2. put tasks into priority queue
     * 3. fill distances arr with -1 (noting -1 is unreachable)
     * 4. pull the from pq with highest count (as we want to finish those task first)
     * 5. if polled task is not in enough interval n, then keep looking another
     * ready task
     * 6. update the interval for each task
     *
     * @param tasks
     * @param n
     * @return
     */
    public int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];
        for (char task: tasks) {
            counts[task - 'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a1, a2) -> a2 - a1);
        for (int count: counts) {
            if (count > 0)
                pq.add(count);
        }


        int count = 0;

        while (!pq.isEmpty()) {

            List<Integer> temp = new ArrayList<>();

            for (int i = 0; i <= n; i++) {
                if (!pq.isEmpty()) {
                    int next = pq.poll();
                    if (next > 1) {
                        temp.add(next - 1);
                    }
                }

                count++;

                if (pq.isEmpty() && temp.isEmpty()) break;
            }

            for (int rem: temp) pq.offer(rem);
        }

        return count;
    }

    @Test
    public void test() {
        assertEquals(8, leastInterval(new char[] {'A','A','A','B','B','B'}, 2));
        assertEquals(16, leastInterval(new char[] {'A','A','A','A','A','A','B','C','D','E','F','G'}, 2));
    }
}
