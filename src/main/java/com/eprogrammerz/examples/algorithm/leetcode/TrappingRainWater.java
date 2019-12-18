package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/trapping-rain-water/
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        if (height.length == 0) return 0;

        int n = height.length;
        int[] lMax = new int[n];
        lMax[0] = height[0];

        for (int i = 1; i < n; i++) {
            lMax[i] = Math.max(height[i], lMax[i - 1]);
        }

        int[] rMax = new int[n];
        rMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rMax[i] = Math.max(rMax[i + 1], height[i]);
        }

        int vol = 0;
        for (int i = 0; i < n; i++) {
            vol += Math.min(lMax[i], rMax[i]) - height[i];
        }
        return vol;
    }

    @Test
    public void test() {
        assertEquals(6,  trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
