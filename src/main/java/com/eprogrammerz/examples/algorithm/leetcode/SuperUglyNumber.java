package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Write a program to find the nth super ugly number.
 *
 * Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k.
 *
 * Example:
 *
 * Input: n = 12, primes = [2,7,13,19]
 * Output: 32
 * Explanation: [1,2,4,7,8,13,14,16,19,26,28,32] is the sequence of the first 12
 *              super ugly numbers given primes = [2,7,13,19] of size 4.
 */
public class SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Long> q = new PriorityQueue<>();
        for (int prime: primes) {
            q.add((long) prime);
        }
        if (primes.length == 1) {
            return (int) Math.pow(primes[0], n - 1);
        }
        int count = 1;
        long ugly = 1;
        while (count < n) {
            ugly = q.poll();

            if (ugly != q.peek()) {
                count++;
                for (int prime: primes) {
                    long potentialUgly = prime * ugly;
                    q.add(potentialUgly);
                }
            }

        }
        return (int) ugly;
    }

    @Test
    public void test() {
        assertEquals(32, nthSuperUglyNumber(12, new int[] {2, 7, 13, 19}));
        assertEquals(2, nthSuperUglyNumber(2, new int[] {2}));
    }
}
