package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Yogen on 9/28/2017.
 *
 * Find triplets that makes to the sum of target
 */
public class Sum3 {

    @Test
    public void testThreeSum() {
        String expectedElements = "[[-1, 0, 1], [-1, 1, 0], [-1, -1, 2], [0, 1, -1], [0, -1, 1], [1, -1, 0], [2, -1, -1]]";

        assertEquals(expectedElements,threeSum(new int[]{-1,0,1,2,-1,-4}).toString());
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();

        List<Integer> numList = new ArrayList<>();
        for(int n: nums) numList.add(n);

        for(int i = 0; i < nums.length-1; i++) {
            for(int j = i+1; j < nums.length; j++) {
                int z = (-1)* (nums[i] + nums[j]);
                if(numList.contains(z) && (numList.indexOf(z) != i && numList.indexOf(z) != j)) {
                    triplets.add(Arrays.asList(nums[i], nums[j], z));
                }
            }
        }
        return triplets;
    }
}
