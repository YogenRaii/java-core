package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.anyOf;

/**
 * https://leetcode.com/problems/random-pick-index/
 */
class Solution {

    private Random rand;

    /**
     * nums[i] -> [i, j, k]
     */
    private Map<Integer, List<Integer>> map;
    public Solution(int[] nums) {
        this.map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<>());
            }
            List<Integer> l = map.get(nums[i]);
            l.add(i);
        }
        this.rand = new Random();
    }

    public int pick(int target) {
        List<Integer> l = map.get(target);

        int idx = rand.nextInt(l.size());

        return l.get(idx);

    }

}

public class RandomPickIndex {
    @Test
    public void test1() {
        Solution random = new Solution(new int[]{1, 2, 3, 3, 3});
        assertThat(random.pick(3), anyOf(is(2), is(3), is(4)));
    }
}
