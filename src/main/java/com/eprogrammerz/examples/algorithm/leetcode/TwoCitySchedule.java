package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/two-city-scheduling/submissions/
 */
public class TwoCitySchedule {
    public int twoCitySchedCost(int[][] costs) {
        int costA = 0;
        int costB = 0;

        // sort entries so that we can look greedily the mini first for both city A and B
        Arrays.sort(costs, (c1, c2) -> (Math.abs(c2[0] - c2[1]) - Math.abs(c1[0] - c1[1])));

        int countA = 0;
        int countB = 0;
        for (int[] cost : costs) {
            if (countB == costs.length / 2) {
                costA += cost[0];
                countA++;
            } else if (countA == costs.length / 2) {
                costB += cost[1];
                countB++;
            } else {

                if (cost[0] <= cost[1]) {
                    costA += cost[0];
                    countA++;
                } else {
                    costB += cost[1];
                    countB++;
                }

            }
        }
        return costA + costB;
    }

    @Test
    public void test1() {
        int[][] costs = new int[][]{
                {100, 20}, {30, 20}, {400, 50}, {30, 30}
        };
        assertEquals(130, twoCitySchedCost(costs));
    }

    @Test
    public void test2() {
        int[][] costs = new int[][]{
                {259, 770}, {448, 54}, {926, 667}, {184, 139}, {840, 118}, {577, 469}
        };
        assertEquals(1859, twoCitySchedCost(costs));
    }

    @Test
    public void test3() {
        int[][] costs = new int[][]{
                {515, 563}, {451, 713}, {537, 709}, {343, 819}, {855, 779}, {457, 60}, {650, 359}, {631, 42}
        };
        assertEquals(3086, twoCitySchedCost(costs));
    }
}
