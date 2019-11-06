package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 *
 * Example:
 *
 * Input: n = 4, k = 2
 * Output:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> l = new ArrayList<>();

        if (n == 0) return l;

        backTrack(n, 1, k, l, new ArrayList<>());
        return l;
    }

    private void backTrack(int n, int start, int k, List<List<Integer>> l, List<Integer> temp) {
        if (temp.size() == k) {
            l.add(new ArrayList<>(temp));
        } else {
            for (int i = start; i <= n; i++) {
                temp.add(i);
                backTrack(n, i + 1, k, l, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }

    @Test
    public void test1() {
        List<List<Integer>> actual = combine(4, 2);
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(1,2));
        expected.add(Arrays.asList(1,3));
        expected.add(Arrays.asList(1,4));
        expected.add(Arrays.asList(2,3));
        expected.add(Arrays.asList(2,4));
        expected.add(Arrays.asList(3,4));

        assertThat(actual, is(expected));
    }
}
