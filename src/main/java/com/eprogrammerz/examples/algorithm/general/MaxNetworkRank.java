package com.eprogrammerz.examples.algorithm.general;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Find the max network rank in infrastructure where rank is total num of road connected to either cities
 * <p>
 * Example
 * A = [1,2,3,3]
 * B = [2,3,1,4]
 * N = 4
 * <p>
 * return 4 (city 2 and 3 with road [2,1], [2,3], [3,1], [3,4]
 */
public class MaxNetworkRank {
    public int maxNetworkRank(int[] A, int[] B, int n) {
        // map to store city - ranks
        int[] ranks = new int[n];
        for (int i = 0; i < A.length; i++) {
            int cityA = A[i];
            int cityB = B[i];
            ranks[cityA - 1]++;
            ranks[cityB - 1]++;
        }

        int max = 0;

        // traverse each city pair and sum their ranks and see it is max
        for (int i = 0; i < A.length; i++) {
            max = Math.max(ranks[A[i] - 1] + ranks[B[i] - 1] - 1, max);
        }
        return max;
    }

    @Test
    public void test() {
        assertEquals(4, maxNetworkRank(new int[]{1, 2, 3, 3}, new int[]{2, 3, 1, 4}, 4));
        assertEquals(5, maxNetworkRank(new int[]{1, 2, 3, 3, 3}, new int[]{2, 3, 1, 4, 5}, 5));
    }
}
