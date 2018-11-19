package com.eprogrammerz.examples.algorithm.crackingCoding;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * @author Yogen Rai
 *
 * https://www.hackerrank.com/challenges/pairs/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=7-day-campaign&h_r=next-challenge&h_v=zen
 */
public class SearchPairs {
    public int pairs(int k, int[] arr) {
        final Set<Integer> nums = new HashSet<>();
        for (int n: arr) {
            nums.add(n);
        }

        int pairCount = 0;

        for (int n: arr) {
            if (nums.contains(n - k)) {
                pairCount++;
            }
        }
        return pairCount;
    }

    @Test
    public void testPairs() {
        int[] arr = new int[] {1,5,3,4,2};
        assertEquals(3, pairs(2, arr));
    }
}
