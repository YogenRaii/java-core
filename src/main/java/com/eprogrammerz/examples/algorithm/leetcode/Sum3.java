package com.eprogrammerz.examples.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Yogen on 9/28/2017.
 */
public class Sum3 {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();

        List<Integer> numList = new ArrayList<>();
        for(int n: nums) numList.add(n);

        for(int i = 0; i < nums.length-1; i++) {
            for(int j = i+1; j < nums.length; j++) {
                int z = (-1)* (nums[i] + nums[j]);
                if(numList.contains(z) && (numList.indexOf(z) != i && numList.indexOf(z) != j)) {
                    triplets.add(Arrays.asList(new Integer[]{nums[i], nums[j], z}));
                }
            }
        }

        return triplets;
    }
}
