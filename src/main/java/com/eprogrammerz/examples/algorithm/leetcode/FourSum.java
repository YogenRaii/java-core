package com.eprogrammerz.examples.algorithm.leetcode;


import org.junit.Test;

import java.util.*;

import static java.util.Arrays.asList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums
 * such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 * <p>
 * Note:
 * <p>
 * The solution set must not contain duplicate quadruplets.
 * <p>
 * Example:
 * <p>
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 * <p>
 * A solution set is:
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 *
 * https://leetcode.com/problems/4sum/
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> res = new ArrayList<>();

        int n = nums.length;

        if (n < 3) return res;

        Arrays.sort(nums);

        Map<Integer, List<List<Integer>>> map = new HashMap<>();

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = nums[i] + nums[j];

                map.computeIfAbsent(sum, s -> new ArrayList<>()).add(Arrays.asList(i, j));
            }
        }

        Set<String> seen = new HashSet<>();

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int x = nums[i] + nums[j];
                int y = target - x;
                if (map.containsKey(y)) {
                    List<List<Integer>> l = map.get(y);

                    for (List<Integer> p : l) {
                        int k = p.get(0);
                        int m = p.get(1);

                        if (i == k || i == m || j == k || j == m) continue; // avoid same grouping

                        List<Integer> q = Arrays.asList(nums[i], nums[j], nums[k], nums[m]);
                        q.sort(Comparator.naturalOrder());
                        String key = q.get(0) + "#" + q.get(1) + "#" + q.get(2) + "#" + q.get(3);

                        if (seen.add(key)) {
                            res.add(q);
                        }
                    }
                }
            }
        }

        return res;
    }

    @Test
    public void test() {
        List<List<Integer>> actual = fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
        List<List<Integer>> expected = asList(asList(-2, -1, 1, 2), asList(-2, 0, 0, 2), asList(-1, 0, 0, 1));

        assertThat(actual, is(expected));
    }
}
