package com.eprogrammerz.examples.algorithm.leetcode;

import java.util.TreeSet;

/**
 * Created by Yogen on 9/28/2017.
 */
public class MinMaxSum {
    public static void main(String[] args) {
//        int[] inputs = {1,2,3,4,5};
        int[] inputs = {256741038, 623958417, 467905213, 714532089, 938071625};
        int[] minMax = findMinMax(inputs);

        for(int n: minMax) {
            System.out.print(n + "  ");
        }
    }

    private static int[] findMinMax(int[] nums) {
        long totalSum = 0;

        for(int n: nums) {
            totalSum += n;
        }

        TreeSet<Long> sums = new TreeSet<>();
        for(int i = 0; i < nums.length; i++) {
            sums.add(totalSum - nums[i]);
        }
        return new int[]{ (int) (long) sums.first(), (int) (long) sums.last()};
    }
}
