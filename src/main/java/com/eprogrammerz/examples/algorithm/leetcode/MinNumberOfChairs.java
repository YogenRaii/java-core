package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

import static org.junit.Assert.assertEquals;

/**
 * There are n guests who are invited to a party. The k-th guest will attend the party at time S[k] and leave the party at time E[k].
 *
 * Given an integer array S and an integer array E, both of length n, return an integer denoting the minimum number of chairs
 * you need such that everyone attending the party can sit down.
 *
 * Example:
 *
 * Input: S = [1, 2, 6, 5, 3], E = [5, 5, 7, 6, 8]
 * Output: 3
 * Explanation:
 * There are five guests attending the party.
 * The 1st guest will arrive at time 1. We need one chair at time 1.
 * The 2nd guest will arrive at time 2. There are now two guests at the party, so we need two chairs at time 2.
 * The 5th guest will arrive at time 3. There are now three guests at the party, so we need three chairs at time 3.
 * The 4th guest will arrive at time 5 and, at the same moment, the 1st and 2nd guests will leave the party.
 * There are now two (the 4th and 5th) guests at the party, so we need two chairs at time 5.
 * The 3rd guest will arrive at time 6, and the 4th guest will leave the party at the same time.
 * There are now two (the 3rd and 5th) guests at the party, so we need two chairs at time 6.
 * So we need at least 3 chairs.
 */
public class MinNumberOfChairs {
    public int minNumberOfChairs(int[] S, int[] E) {
        int n = S.length;
        if (n == 0) return 0;

        int[][] intervals = new int[n][2];
        for (int i = 0; i < n; i++) {
            intervals[i] = new int[]{S[i], E[i]};
        }

        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(intervals[0][1]);

        int count = 1;

        for (int i = 1; i < n; i++) {
            int[] curr = intervals[i];

            int prevEnd = pq.peek();

            if (prevEnd <= curr[0]) { // re-use
                pq.poll();
            } else {
                count++;
            }

            pq.offer(curr[1]);
        }

        return count;
    }

    @Test
    public void test() {
        assertEquals(3, minNumberOfChairs(new int[] {1, 2, 6, 5, 3}, new int[] {5, 5, 7, 6, 8}));
    }
}
