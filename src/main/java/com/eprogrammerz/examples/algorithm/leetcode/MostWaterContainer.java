package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 *
 * Note: You may not slant the container and n is at least 2.
 *
 *
 *
 *
 *
 * The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 *
 *
 *
 * Example:
 *
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 */
public class MostWaterContainer {
    public int maxArea(int[] height) {
        // int max = 0;
        // for (int i = 0; i < height.length - 1; i++) {
        //     for (int j = i + 1; j < height.length; j++) {
        //         int area = (j - i) * Math.min(height[i], height[j]);
        //         if (max < area) {
        //             max = area;
        //         }
        //     }
        // }
        // return max;

        int max = 0;
        int start = 0;
        int end = height.length - 1;
        while(start < end) {
            int area = (end - start) * Math.min(height[start], height[end]);
            if (area > max) {
                max = area;
            }

            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }
        return max;
    }

    @Test
    public void test() {
        assertEquals(100, maxArea(new int[] {1,8,6,100,100,4,8,3,7}));
        assertEquals(49, maxArea(new int[] {1,8,6,2,5,4,8,3,7}));
    }
}
