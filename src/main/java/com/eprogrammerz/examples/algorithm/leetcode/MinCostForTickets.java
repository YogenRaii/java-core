package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/minimum-cost-for-tickets/
 */
public class MinCostForTickets {
    public int mincostTickets(int[] days, int[] costs) {
        int[] mem = new int[days.length];

        dfs(days, 0, costs, mem);
        return mem[0];
    }

    private int dfs(int[] days, int idx, int[] costs, int[] mem) {
        if (idx >= days.length) {
            return 0;
        }

        if (mem[idx] > 0) return mem[idx];

        int single = costs[0] + dfs(days, idx + 1, costs, mem); // just moves to next index

        int i = idx + 1;
        for (; i < days.length; i++) {

            if (days[i] >= days[idx] + 7) {
                i--;
                break;
            }
        }

        int week = costs[1] + dfs(days, i + 1, costs, mem);

        i = idx + 1;
        for (; i < days.length; i++) {
            if (days[i] >= days[idx] + 30) {
                i--;
                break;
            }
        }
        int months = costs[2] + dfs(days, i + 1, costs, mem);

        mem[idx] = Math.min(single, Math.min(week, months));
        return mem[idx];
    }

    @Test
    public void test1() {
        assertEquals(11, mincostTickets(new int[] {1,4,6,7,8,20}, new int[] {2, 7, 15}));
    }

    @Test
    public void test2() {
        assertEquals(17, mincostTickets(new int[] {1,2,3,4,5,6,7,8,9,10,30,31}, new int[] {2, 7, 15}));
    }
}
