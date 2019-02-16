package com.eprogrammerz.examples.algorithm.interviewbit;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 *
 *  Note:
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 * The solution set must not contain duplicate quadruplets.
 * Example :
 * Given array S = {1 0 -1 0 -2 2}, and target = 0
 * A solution set is:
 *
 *     (-2, -1, 1, 2)
 *     (-2,  0, 0, 2)
 *     (-1,  0, 0, 1)
 *
 *     Find each sum -> pairs (s2p)
 *     for each pair, if there is (target - pair) in s2p, then add to result
 */
public class FourSum {
    public List<List<Integer>> fourSum(List<Integer> input, int target) {
        Set<List<Integer>> quadruplets = new HashSet<>();

        Map<Integer, List<Integer>> sumPairs = new HashMap<>();

        for (int i = 0; i < input.size() - 1; i++) {
            for (int j = i + 1; j <input.size(); j++) {
                int sum = input.get(i) + input.get(j);
                sumPairs.put(sum, Arrays.asList(i, j));
            }
        }

        for (int i = 0; i < input.size() - 1; i++) {
            for (int j = i + 1; j < input.size(); j++) {
                int sum = input.get(i) + input.get(j);
                if (sumPairs.containsKey(target - sum)) {
                    List<Integer> pair = sumPairs.get(target - sum);

                    // if not the same pair
                    if (!pair.contains(i) && !pair.contains(j)) {
                        List<Integer> quadruplet = new ArrayList<>();
                        quadruplet.add(input.get(pair.get(0)));
                        quadruplet.add(input.get(pair.get(1)));
                        quadruplet.add(input.get(i));
                        quadruplet.add(input.get(j));
                        Collections.sort(quadruplet);
                        quadruplets.add(quadruplet);
                    }
                }
            }
        }

        List<List<Integer>> result = new ArrayList<>(quadruplets);
        result.sort((l1, l2) -> {
            for (int idx = 0; idx < l1.size(); idx++) {
                int diff = l1.get(idx) - l2.get(idx);
                if (diff != 0) return diff;
            }
            return 0;
        });
        return result;
    }

    @Test
    public void testFourSum() {
        List<Integer> input = Arrays.asList(1, 0, -1, 0, -2, 2);
        assertEquals("[[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]]", fourSum(input, 0).toString());
    }
}
