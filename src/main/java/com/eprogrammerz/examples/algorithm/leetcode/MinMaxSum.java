package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import java.util.TreeSet;

/**
 * Created by Yogen on 9/28/2017.
 */
public class MinMaxSum {
    public static void main(String[] args) {
        int[] inputs = {256741038, 623958417, 467905213, 714532089, 938071625};
        int[] minMax = findMinMax(inputs);

        for(int n: minMax) {
            System.out.print(n + "  ");
        }
    }

    private static int[] findMinMax(int[] nums) {
        long totalSum = 0;

        for (int n : nums) {
            totalSum += n;
        }

        TreeSet<Long> sums = new TreeSet<>();

        for (int num : nums) {
            sums.add(totalSum - num);
        }
        return new int[]{(int) (long) sums.first(), (int) (long) sums.last()};
    }
}
