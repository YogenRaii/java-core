package com.eprogrammerz.examples.algorithm.interviewbit;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://www.interviewbit.com/problems/min-steps-in-infinite-grid/
 */

public class MinStepInInfiniteGrid {
    public int coverPoints(int[] A, int[] B) {
        int steps = 0;

        // (A[0],B[0])->(A[1],B[1])

        for (int i = 0; i < A.length - 1; i++) {
            int startX = A[i];
            int startY = B[i];

            int endX = A[i + 1];
            int endY = B[i + 1];

            while (startX != endX || startY != endY) {
                if (startX < endX) {
                    startX++;
                } else if (startX > endX) {
                    startX--;
                }

                if (startY < endY) {
                    startY++;
                } else if (startY > endY) {
                    startY--;
                }

                steps++;
            }
        }
        return steps;
    }

    @Test
    public void testCoverPoints() {
        assertEquals(6, coverPoints(new int[]{-7, -13}, new int[]{1, -5}));
    }
}
