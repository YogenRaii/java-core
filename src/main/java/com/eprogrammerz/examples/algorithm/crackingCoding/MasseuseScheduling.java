package com.eprogrammerz.examples.algorithm.crackingCoding;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MasseuseScheduling {
    int findMaxBookTime(int[] schedules) {
        int[] mem = new int[schedules.length];
        return findMaxBookTime(schedules, 0, mem);
    }

    private int findMaxBookTime(int[] schedules, int idx, int[] mem) {
        if (schedules.length <= idx) return 0;

        if (mem[idx] == 0) {
            int withThisReservation = schedules[idx] + findMaxBookTime(schedules, idx + 2, mem);

            int withoutThisReservation = findMaxBookTime(schedules, idx + 1, mem);
            mem[idx] = Math.max(withThisReservation, withoutThisReservation);
        }
        return mem[idx];
    }

    @Test
    public void testFindMaxBookTime() {
        int[] input = new int[]{30, 15, 60, 75, 45, 15, 15, 45};
        assertEquals(180, findMaxBookTime(input));
    }
}
