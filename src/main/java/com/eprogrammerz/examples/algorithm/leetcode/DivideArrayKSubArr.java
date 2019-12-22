package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;
import org.springframework.stereotype.Repository;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/
 */
public class DivideArrayKSubArr {
    public boolean isPossibleDivide(int[] nums, int k) {

        int n = nums.length;
        if (n % k != 0) return false;

        int r = n / k;
        int[][] partitions = new int[r][k];

        int[] pos = new int[r];

        for (int num: nums) {
            // n has to go any of parititions
            for (int i = 0; i < partitions.length; i++) {
                if (pos[i] >= k) continue;

                if (pos[i] == 0 || num == partitions[i][pos[i] - 1] + 1) {
                    partitions[i][pos[i]] = num;
                    pos[i]++;
                    break;
                }
            }
        }

        for (int p: pos) {
            if (p != k) return false;
        }
        return true;
    }

    @Test
    public void test() {
        assertFalse(isPossibleDivide(new int[] {15,16,17,18,19,16,17,18,19,20,6,7,8,9,10,3,4,5,6,20}, 5));
        assertTrue(isPossibleDivide(new int[] {1,2,3,3,4,4,5,6}, 4));
    }
}
