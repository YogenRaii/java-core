package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * There are some processes that need to be executed. Amount of a load that process causes on a server that runs it,
 * is being represented by a single integer. Total load caused on a server is the sum of the loads of all the processes that run on that server.
 * You have at your disposal two servers, on which mentioned processes can be run.
 * Your goal is to distribute given processes between those two servers in the way that, absolute difference of their loads will be minimized.
 * <p>
 * Given an array of n integers, of which represents loads caused by successive processes, return the minimum absolute difference of server loads.
 * <p>
 * Example 1:
 * <p>
 * Input: [1, 2, 3, 4, 5]
 * Output: 1
 * Explanation:
 * We can distribute the processes with loads [1, 2, 4] to the first server and [3, 5] to the second one,
 * so that their total loads will be 7 and 8, respectively, and the difference of their loads will be equal to 1.
 */
public class MinDifferenceServerLoads {

    public int distributeLoad(int[] loads) {
        // b1 1 3
        // b2 2 4

        // 1 2 3 4 5
        // 1 (2 3 4 5) [b1 = 1, b2 = 0]

        Map<String, Integer> mem = new HashMap<>();
        return dfs(loads, 0, 0, 0, mem);
    }

    private int dfs(int[] loads, int idx, int b1, int b2, Map<String, Integer> mem) {
        int diff = Math.abs(b1 - b2);
        if (idx == loads.length) {
            return diff;
        }

        String key = idx + "#" + diff;

        if (!mem.containsKey(key)) {

            mem.put(key, Math.min(dfs(loads, idx + 1, b1 + loads[idx], b2, mem),
                    dfs(loads, idx + 1, b1, b2 + loads[idx], mem)));
        }


        return mem.get(key);
    }

    @Test
    public void test() {
        assertEquals(1, distributeLoad(new int[]{1, 2, 3, 4, 5}));
        assertEquals(1, distributeLoad(new int[]{1, 1, 1, 1, 1}));
        assertEquals(0, distributeLoad(new int[]{10, 10, 9, 9 ,2})); // [10,10], [9,9,2]
    }
}
