package com.eprogrammerz.examples.algorithm.crackingCoding;

import java.util.*;

/**
 * @author Yogen Rai
 *
 * Find all subsets for given set
 */
public class PowerSet {
    /**
     * P(0) = {}
     * P(1) = P(0) + {p(0) + a1}
     * P(2) = P(1) + {P(1) + a2}
     * . . .
     * P(n) = P(n-1) + {P(n-1) + an}
     *
     * @param integers
     * @return
     */
    public static Set<Set<Integer>> findPowerSet(List<Integer> integers) {
        return getSubsets(integers, 0);
    }

    public static Set<Set<Integer>> getSubsets(List<Integer> integers, int index) {
        Set<Set<Integer>> powerSet;

        if (index == integers.size()) { // if index has reached size of set, then start by adding empty set
            powerSet = new LinkedHashSet<>();
            powerSet.add(new LinkedHashSet<>());
        } else {
            powerSet = getSubsets(integers, index + 1);

            Integer item = integers.get(index);
            Set<Set<Integer>> moreSubset = new LinkedHashSet<>();
            for (Set<Integer> subset: powerSet) {
                Set<Integer> newSubset = new LinkedHashSet<>();
                newSubset.addAll(subset);
                newSubset.add(item);
                moreSubset.add(newSubset);
            }
            powerSet.addAll(moreSubset);
        }
        return powerSet;
    }

    public static void main(String[] args) {
        Set<Set<Integer>> powerSet = findPowerSet(Arrays.asList(1,2,3,4));
        System.out.println(powerSet.size());
        System.out.println(powerSet);
    }
}
