package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/rle-iterator/submissions/
 */
public class RLEIteratorTest {

    @Test
    public void test1() {
        RLEIterator iterator = new RLEIterator(new int[] {3, 8, 0, 9 , 2, 5});
        assertEquals(8, iterator.next(2));
        assertEquals(8, iterator.next(1));
        assertEquals(5, iterator.next(1));
        assertEquals(-1, iterator.next(2));
    }

    @Test
    public void test2() {
        //[[[811,903,310,730,899,684,472,100,434,611]],[358],[345],[154],[265],[73],[220],[138],[4],[170],[88]]
        RLEIterator iterator = new RLEIterator(new int[] {811,903,310,730,899,684,472,100,434,611});
        assertEquals(903, iterator.next(358));
        assertEquals(903, iterator.next(345));
        assertEquals(730, iterator.next(154));
        assertEquals(684, iterator.next(265));
        assertEquals(684, iterator.next(73));
        assertEquals(684, iterator.next(220));
        assertEquals(684, iterator.next(138));
        assertEquals(684, iterator.next(4));
        assertEquals(684, iterator.next(170));
        assertEquals(684, iterator.next(88));
        //[null,903,903,730,684,684,684,684,684,684,684]
    }

}

class RLEIterator {
    private int[] A; // 3, 8, 0, 9 , 2, 5
    private int p;
    public RLEIterator(int[] A) {
        this.A = A;
    }

    public int next(int n) {
        if (p >= A.length) return -1; // p = 0

        while (p < A.length && A[p] == 0) {
            if (A[p] == 0) {
                p = p + 2;
            }
        }

        if (p >= A.length) return -1;

        // 1
        int rem = A[p] - n;
        while (p < A.length) {

            if (rem < 0) {
                A[p] = 0;
                p = p + 2;
                if (p < A.length) {
                    rem += A[p];
                }
            } else {
                A[p] = rem; // A[0] = 1
                break;
            }
        }

        if (p >= A.length) return -1;

        return A[p + 1];
    }
}
