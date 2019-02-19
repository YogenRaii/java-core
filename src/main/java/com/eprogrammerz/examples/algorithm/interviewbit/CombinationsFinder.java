package com.eprogrammerz.examples.algorithm.interviewbit;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 2 3 ... n.
 *
 * Make sure the combinations are sorted.
 *
 * To elaborate,
 *
 * Within every entry, elements should be sorted. [1, 4] is a valid entry while [4, 1] is not.
 * Entries should be sorted within themselves.
 * Example :
 * If n = 4 and k = 2, a solution is:
 *
 * [
 *   [1,2],
 *   [1,3],
 *   [1,4],
 *   [2,3],
 *   [2,4],
 *   [3,4],
 * ]
 */
public class CombinationsFinder {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        findCombinations(combinations, new ArrayList<>(), nums, k, 0, nums.size() - 1, 0);
        return combinations;
    }

    private void findCombinations(List<List<Integer>> combinations, List<Integer> temp, List<Integer> nums, int k, int start, int end, int idx) {
        if (idx == k) {
            List<Integer> comb = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                comb.add(temp.get(i));
            }
            combinations.add(comb);
            return;
        }

        for (int i = start; i <= end && end-i+1 >= k-idx; i++) {
            temp.add(idx, nums.get(i));
            findCombinations(combinations, temp, nums, k, i + 1, end, idx + 1);
        }
//        temp.clear();
    }

    @Test
    public void testCombine() {
        System.out.println(combine(4, 3));
    }
}
