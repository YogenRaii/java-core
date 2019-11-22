package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Given an array A of 0s and 1s, we may change up to K values from 0 to 1.
 *
 * Return the length of the longest (contiguous) subarray that contains only 1s.
 *
 *
 *
 * Example 1:
 *
 * Input: A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * Output: 6
 * Explanation:
 * [1,1,1,0,0,1,1,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.
 *
 * https://leetcode.com/problems/max-consecutive-ones-iii/
 */
public class MaxConsecutivesIII {
    /**
     * Slide start based upon
     * 1) if there is 1, then look for freeing atleast one 0, find start
     * 2) if there is 0, then free 0, and increase start by 1
     * @param A
     * @param K
     * @return
     */
    public int longestOnes(int[] A, int K) {
        int count = 0;
        int start = 0; // to track the start of looking potential range
        int end = 0; // to track the end of A

        int remK = K;
        while (end < A.length) {
            if (A[end] == 1) end++; // we are still good to move ahead
            else {
                if (remK > 0) {
                    remK--;
                    end++;
                } else {
                    count = Math.max(count, end - start);
                    if (A[start] == 1) {
                        // move start till remK > 0
                        while (remK == 0) {
                            if (A[start] == 0) {
                                remK++;
                            }
                            start++;
                        }
                    } else {
                        remK++;
                        start++;
                    }
                }
            }
        }
        count = Math.max(count, end - start);

        return count;
    }

    @Test
    public void test() {
        assertEquals(6, longestOnes(new int[] {1,1,1,0,0,0,1,1,1,1,0}, 2));
        assertEquals(10, longestOnes(new int[] {1,1,1,0,0,0,1,1,1,1,0}, 3));
        assertEquals(10, longestOnes(new int[] {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
    }
}
