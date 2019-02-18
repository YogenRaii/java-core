package com.eprogrammerz.examples.algorithm.interviewbit;

import org.junit.Test;

import java.util.*;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

/**
 * Given a collection of integers that might contain duplicates, S, return all possible subsets.
 * <p>
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * The subsets must be sorted lexicographically.
 * Example :
 * If S = [1,2,2], the solution is:
 * <p>
 * [
 * [],
 * [1],
 * [1,2],
 * [1,2,2],
 * [2],
 * [2, 2]
 * ]
 */
public class SubsetWithDup {
    public List<List<Integer>> subsetsWithDup(List<Integer> list) {

        Set<List<Integer>> subsets = new LinkedHashSet<>();
        subsets.add(new ArrayList<>());

        if (list == null || list.isEmpty()) return new ArrayList<>(subsets);

        Collections.sort(list);

        subsets(list, 0, new ArrayList<>(), subsets);

        return new ArrayList<>(subsets);
    }

    private void subsets(List<Integer> list, int index, List<Integer> temp, Set<List<Integer>> subsets) {
        for (int i = index; i < list.size(); i++) {
            temp.add(list.get(i));
            subsets.add(new ArrayList<>(temp));
            subsets(list, i + 1, temp, subsets);
            temp.remove(temp.size() - 1);
        }
    }

    @Test
    public void testSubsetsWithDups() {
        // [[], [1], [1, 2], [1, 2, 2], [2], [2, 2]]
        List<List<Integer>> expected = asList(asList(), asList(1), asList(1, 2), asList(1, 2, 2), asList(2), asList(2, 2));
        assertEquals(expected, subsetsWithDup(asList(1, 2, 2)));
    }
}
