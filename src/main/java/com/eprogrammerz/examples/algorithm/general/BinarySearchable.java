package com.eprogrammerz.examples.algorithm.general;

import org.junit.Test;

import java.util.*;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Binary search is a search algorithm usually used on a sorted sequence to quickly find an element with a given value.
 * In this problem we will evaluate how binary search performs on data that isn't necessarily sorted. An element is said to be binary searchable if,
 * regardless of how the pivot is chosen the algorithm returns true. For example:
 *
 * [2, 1, 3, 4, 6, 5] and target = 5, we cannot find 5. Because when the pivot is 4, we get element 6, then right pointer will move left,
 * so we'll lose the opportunity to find target 5.
 * [2, 1, 3, 4, 5, 6] and target = 5, we can find 5. Because wherever we choose the pivots, we'll find target at last.
 * Given an unsorted array of n distinct integers, return the number of elements that are binary searchable.
 *
 * Example 1:
 *
 * Input: [1, 3, 2]
 * Output: 1
 * Explanation: However we choose the pivots, we will always find the number 1 when looking for it. This does not hold for 3 and 2.
 * Example 2:
 *
 * Input: [2, 1, 3, 5, 4, 6]
 * Output: 2
 * Explanation: 3 and 6 are the numbers guaranteed to be found.
 *
 * https://leetcode.com/discuss/interview-question/352743/
 */
public class BinarySearchable {
    public List<Integer> binarySearchable(int[] arr) {
        LinkedList<Integer> l = new LinkedList<>();

        int n = arr.length;

        if (n == 0) return l;

        // keep track of maximums while going left to right
        // now traverse from right to left and see
        // if curr <= right && curr >= leftMax[i]
        //      then that is searchable

        int[] leftMax = new int[n];
        leftMax[0] = arr[0];

        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(arr[i], leftMax[i - 1]);
        }

        int rightMin = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] <= rightMin && arr[i] >= leftMax[i]) {
                l.addFirst(arr[i]);
            }
            rightMin = Math.min(rightMin, arr[i]);
        }

        return l;
    }

    @Test
    public void test() {
        assertThat(binarySearchable(new int[] {1,3,2}), is(Collections.singletonList(1)));
        assertThat(binarySearchable(new int[] {2, 1, 3, 5, 4, 6}), is(asList(3, 6)));
        assertThat(binarySearchable(new int[] {1, 5, 7, 11, 12, 18}), is(asList(1, 5, 7, 11, 12, 18)));
        assertThat(binarySearchable(new int[] {3, 2, 1}), is(Collections.emptyList()));
        assertThat(binarySearchable(new int[] {5, 4, 6, 2, 8}), is(Collections.singletonList(8)));
        assertThat(binarySearchable(new int[] {1, 3, 2, 4, 5, 7, 6, 8}), is(asList(1, 4, 5, 8)));
    }
}
