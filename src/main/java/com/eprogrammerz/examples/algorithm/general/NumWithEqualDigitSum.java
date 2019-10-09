package com.eprogrammerz.examples.algorithm.general;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * given an array of integers, return max sum of pair whose digits sums to equals
 */
public class NumWithEqualDigitSum {
    public int findMaxSum(int[] nums) {
        Map<Integer, List<Integer>> nList = new HashMap<>();
        for (int n: nums) {
            int sum = findDigitSum(n);
            List<Integer> list = nList.get(sum);
            if (list == null) {
                list = new ArrayList<>();
                list.add(n);
                nList.put(sum, list);
            } else {
                list.add(n);
            }
        }

        int maxSum = Integer.MIN_VALUE;
        for (int key: nList.keySet()) {
            List<Integer> list = nList.get(key);
            if (list.size() >= 2) {
                int sum = list.size() == 2 ? list.get(0) + list.get(1) : findMaxSum(list);
                if (sum > maxSum) maxSum = sum;
            }
        }
        return maxSum == Integer.MIN_VALUE ? -1 : maxSum;
    }

    private int findMaxSum(List<Integer> l) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < l.size() - 1; i++) {
            for (int j = i + 1; j < l.size(); j++) {
                int sum = l.get(i) + l.get(j);
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }

    private int findDigitSum(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    @Test
    public void test() {
        assertEquals(93, findMaxSum(new int[] {51, 17, 71, 42}));
        assertEquals(102, findMaxSum(new int[] {42, 33, 60}));
        assertEquals(-1, findMaxSum(new int[] {51, 32, 43}));
    }
}
