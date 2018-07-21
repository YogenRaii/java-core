package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import java.util.*;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertArrayEquals;


/**
 * find the indexes of elements, in increasing order, that makes the sums to the target
 * Time O(n)
 */
public class TwoSum {

    @Test
    public void testTwoSum() {
        int[] nums = {1, 3, 3, 4};
        int[] pair = twoSum(nums, 6);

        assertNotNull(pair);
        assertEquals(2, pair.length);
        assertArrayEquals(new int[]{1,2}, pair);
    }

    @Test
    public void testTwoSumMap() {
        int[] nums = {1, 3, 3, 4};
        int[] pair = twoSumMap(nums, 6);

        assertNotNull(pair);
        assertEquals(2, pair.length);
        assertArrayEquals(new int[]{1,2}, pair);
    }

    public static int[] twoSum(int[] nums, int target) {
        List<Integer> numList = new ArrayList<Integer>();
        for (Integer num : nums) numList.add(num);

        for (int i = 0; i < nums.length; i++) {
            int y = target - nums[i];
            int index = numList.indexOf(y);
            if (index >= 0 && i != index) {
                return i < index ? new int[]{i, index} : new int[]{index, i};
            }
        }
        return null;
    }

    private static int[] twoSumMap(int[] nums, int target) {
        //store element and its index and if two elements with same value, second will replace first
        Map<Integer, Integer> elems = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (elems.containsKey(target - nums[i])) {
                return new int[] {elems.get(target - nums[i]), i};
            } else {
                elems.put(nums[i], i);
            }
        }

        return null;
    }

}
