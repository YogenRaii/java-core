package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/fruit-into-baskets/
 */
public class FruitsIntoBaskets {
    public int totalFruit(int[] tree) {
        if (tree.length <= 2) return tree.length;

        int n = tree.length;

        int start = 0;

        int b1 = tree[start];
        int b2 = tree[start];

        int end = 1;
        while (end < n) {
            b2 = tree[end];
            if (b1 != b2) break;
            end++;
        }

        int max = end - start;

        int nextStart = end;

        while (end < tree.length) {
            if (tree[end] == b1 || tree[end] == b2) {
                end++;
            } else {
                max = Math.max(end - start, max);
                // update b1, b2
                // update start and end
                start = nextStart;
                b1 = tree[start];
                b2 = tree[start];

                end = start + 1;
                while (end < n) {
                    b2 = tree[end];
                    if (b1 != b2) break;

                    end++;
                }

                nextStart = end;
            }
        }
        return Math.max(max, end - start);
    }

    @Test
    public void test() {
        assertEquals(3, totalFruit(new int[] {0,1,2,2}));
        assertEquals(4, totalFruit(new int[] {1,2,3,2,2}));
        assertEquals(5, totalFruit(new int[] {3,3,3,1,2,1,1,2,3,3,4}));
    }
}
