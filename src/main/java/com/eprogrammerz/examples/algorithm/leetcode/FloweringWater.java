package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Count how many times you and your friend, who is watering flower from last, have to refill the water tank
 */
public class FloweringWater {
    public int countRefill(int[] plants, int capacity1, int capacity2) {
        int n = plants.length;

        int lo = 0;
        int hi = n - 1;

        int count = 2; // fill both tanks initially
        int w1 = capacity1;
        int w2 = capacity2;

        while (lo < hi) {
            if (plants[lo] > w1) { // no sufficient water, so needs to refill
                w1 = capacity1;
                count++;
            }
            w1 -= plants[lo]; // watering from start and remaining water

            if (plants[hi] > w2) {
                w2 = capacity2;
                count++;
            }
            w2 -= plants[hi];

            lo++;
            hi--;
        }

        // if there is flower in between which both can water, then we can sum up
        if ((n & 1) == 1) {
            if (w1 + w2 < plants[lo]) count++;
        }
        return count;
    }

    @Test
    public void test() {
        assertEquals(3, countRefill(new int[]{2, 4, 5, 1, 2}, 5, 7));
    }
}
