package com.eprogrammerz.examples.algorithm.interviewbit;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * find all combinations of numbers sum to the target
 */
public class CombinationII {
    List<List<Integer>> combinations(List<Integer> list, int target) {
        List<List<Integer>> comb = new ArrayList<>();
        Collections.sort(list);
        combinations(list, comb, new ArrayList<>(), target, 0);
        return comb;
    }

    private void combinations(List<Integer> list, List<List<Integer>> comb, List<Integer> temp, int target, int start) {
        if (target == 0) {
            comb.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < list.size() && target >= list.get(i); i++) {
            if (i != start && list.get(i - 1).equals(list.get(i))) continue;
            temp.add(list.get(i));

            combinations(list, comb, temp, target - list.get(i), i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    @Test
    public void test() {
        List<Integer> input = Arrays.asList(10, 1, 2, 7, 3, 4, 1, 2);
        List<List<Integer>> actual = combinations(input, 8);

        List<List<Integer>> expected = Arrays.asList(Arrays.asList(1, 1, 2, 4),
                Arrays.asList(1, 2, 2, 3), Arrays.asList(1, 3, 4), Arrays.asList(1, 7),
                Arrays.asList(2, 2, 4));
        assertEquals(expected, actual);
    }
}
