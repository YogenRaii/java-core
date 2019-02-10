package com.eprogrammerz.examples.algorithm.interviewbit;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Find floor(sqrt(x))
 *
 * e.g. floor(sqrt(6)) = 2
 */

public class SqrtFinder {
    public int sqrt(int a) {

        if (a ==0 || a == 1) return a;

        int low = 1;
        int high = a;

        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            long square = (long) mid * mid;

            if (square == a) return mid;

            if (square < a) {
                low = mid + 1;
                ans = mid;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    @Test
    public void testSqrt() {
        assertEquals(1, sqrt(1));
        assertEquals(2, sqrt(6));
        assertEquals(3, sqrt(9));
        assertEquals(5, sqrt(25));
        assertEquals(30506, sqrt(930675566));
    }
}
