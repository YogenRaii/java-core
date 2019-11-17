package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sums to target.
 * <p>
 * The same repeated number may be chosen from candidates unlimited number of times.
 * <p>
 * Note:
 * <p>
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 * <p>
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 * [7],
 * [2,2,3]
 * ]
 */
public class CombinationSum {

    /**
     * Time - O(n!)
     * Space - O(n)
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> l = new ArrayList<>();
        if (candidates.length == 0) return l;

        // this is important as we are pruning the search with index
        Arrays.sort(candidates);
        backTrack(candidates, 0, new ArrayList<>(), l, target);

        return l;
    }

    private void backTrack(int[] candidates, int start, List<Integer> temp, List<List<Integer>> r, int target) {
        if (target == 0) { // found the set of element
            r.add(new ArrayList<>(temp));
        } else {
            for (int i = start; i < candidates.length; i++) {
                int n = candidates[i];

                if (target - n < 0) return;

                temp.add(n);
                backTrack(candidates, i, temp, r, target - n);
                temp.remove(temp.size() - 1);
            }
        }
    }

    @Test
    public void test1() {
        List<List<Integer>> actual = combinationSum(new int[]{2, 3, 6, 7}, 7);

        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(2, 2, 3));
        expected.add(Arrays.asList(7));
        assertThat(actual, is(expected));
    }

    @Test
    public void test2() {
        List<List<Integer>> actual = combinationSum(new int[]{2, 3, 5}, 8);
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(2, 2, 2, 2));
        expected.add(Arrays.asList(2, 3, 3));
        expected.add(Arrays.asList(3, 5));

        assertThat(actual, is(expected));
    }
}
