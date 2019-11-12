package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/brick-wall/
 */
public class BrickWall {
    public int leastBricks(List<List<Integer>> wall) {
        int m = wall.size();
        int n = 0;
        for (int w: wall.get(0)) {
            n += w;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> row: wall) {
            int brickSum = 0;
            for (int w: row) {
                brickSum += w;
                map.put(brickSum, map.getOrDefault(brickSum, 0) + 1);
            }
        }

        int res = Integer.MAX_VALUE;
        for (int w: map.keySet()) {
            int count = map.get(w);
            if (w < n) {
                count = m - count;
            }
            res = Math.min (count, res);
        }

        return res;
    }

    @Test
    public void test1() {
        List<List<Integer>> wall = asList(asList(1,2,2,1),
        asList(3,1,2),
        asList(1,3,2),
        asList(2,4),
        asList(3,1,2),
        asList(1,3,1,1));
        int count = leastBricks(wall);
        assertEquals(2, count);
    }
}
