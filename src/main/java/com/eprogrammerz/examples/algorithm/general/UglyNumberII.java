package com.eprogrammerz.examples.algorithm.general;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

import static org.junit.Assert.assertEquals;

/**
 * Write a program to find the n-th ugly number.
 * <p>
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * <p>
 * Example:
 * <p>
 * Input: n = 10
 * Output: 12
 * Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers
 */
public class UglyNumberII {
    private List<Long> factors = Arrays.asList(2L, 3L, 5L);

    public int nthUglyNumber(int n) {
        if (n <= 3) return n;

        PriorityQueue<Long> pq = new PriorityQueue<>(factors);


        int count = 1;
        long ugly = 1;
        while (count < n) {
            ugly = pq.poll();

            if (ugly != pq.peek()) {
                count++;

                for (long factor : factors) {
                    pq.add(factor * ugly);
                }
            }
        }

        return (int) ugly;
    }

    @Test
    public void test1() {
        int ugly = nthUglyNumber(10);
        assertEquals(12, ugly);
    }
}
