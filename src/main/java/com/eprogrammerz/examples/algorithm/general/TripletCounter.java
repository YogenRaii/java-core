package com.eprogrammerz.examples.algorithm.general;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Will there be repeated element? if so, in triplet, will the repetition allowed?
 * {1,2,3,-1},4 -> {1,2,-1}, {1,3,-1} = 2
 *
 * x + y <= s - z
 * for (i = 0; i < len - 2; i++)
 *    for (j = i; j < len - 1; j++)
 *      if (n[i] + n[j] - sum <=
 *
 * for (i = 0; i < len - 1; i++)
 *    if (nums[i]-sum) yes
 */
public class TripletCounter {
    public int countTriplets(int[] nums, int sum) {
        if (nums == null) {
            throw new IllegalArgumentException("Array should not be null.");
        }

        Set<Integer> numSet = new HashSet<>();
        for(int n: nums) {
            numSet.add(n);
        }
        int count = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i; j < nums.length - 1; j++) {
                if (numSet.contains(nums[i] + nums[j] - sum)) {
                    count++;
                }
            }
        }
        return count;
    }

    @Test
    public void testCountTriplets() {
        assertEquals(2, countTriplets(new int[]{1,2,3,-1}, 4));
        assertEquals(2, countTriplets(new int[]{1,-2,3,0}, 2));
    }
}
