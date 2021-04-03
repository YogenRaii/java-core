package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

// Return 1 if multiplication is +ve, -1 if negative and 0 if 0
public class Multiplication {
    public int solution(int[] A) {
        int neg = 0;
        for (int a : A) {
            if (a < 0) neg++;
            if (a == 0) return 0;
        }

        return neg % 2 == 0 ? 1 : -1;
    }

    @Test
    public void test() {
        assertEquals(1, solution(new int[]{-1,2,3,-1}));
        assertEquals(-1, solution(new int[]{-1,2,3,-1,-2}));
        assertEquals(0, solution(new int[]{-1,2,3,-1,-2,0}));
    }
}
