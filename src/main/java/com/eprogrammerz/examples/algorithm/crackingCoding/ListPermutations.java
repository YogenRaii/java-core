package com.eprogrammerz.examples.algorithm.crackingCoding;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Find permutations of list of numbers
 */
public class ListPermutations {
    public List<List<Integer>> findPermutations(List<Integer> num) {
        List<List<Integer>> permutations = new ArrayList<>();
        findPermutations(num, new ArrayList<>(), permutations);
        return permutations;
    }

    private void findPermutations(List<Integer> nums, List<Integer> permutation, List<List<Integer>> permutations) {
        if (nums.size() == 0) {
            permutations.add(new ArrayList<>(permutation));
        } else {
            for (int i = 0; i < nums.size(); i++) {
                List<Integer> remaining1 = nums.subList(0, i);
                List<Integer> remaining2 = nums.subList(i + 1, nums.size());
                permutation.add(nums.get(i));

                List<Integer> remaining = new ArrayList<>();
                remaining.addAll(remaining1);
                remaining.addAll(remaining2);
                findPermutations(remaining, permutation, permutations);
                permutation.remove(nums.get(i));
            }
        }
    }

    @Test
    public void testFindDenomination() {
        List<List<Integer>> actual = findPermutations(Arrays.asList(1, 2, 3));
        List<Integer> p1 = Arrays.asList(1, 2, 3);
        List<Integer> p2 = Arrays.asList(1, 3, 2);
        List<Integer> p3 = Arrays.asList(2, 1, 3);
        List<Integer> p4 = Arrays.asList(2, 3, 1);
        List<Integer> p5 = Arrays.asList(3, 1, 2);
        List<Integer> p6 = Arrays.asList(3, 2, 1);
        List<List<Integer>> expected = Arrays.asList(p1, p2, p3, p4, p5, p6);
        assertEquals(expected, actual);
    }
}
