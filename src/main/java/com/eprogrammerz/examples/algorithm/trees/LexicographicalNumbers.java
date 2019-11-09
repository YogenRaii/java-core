package com.eprogrammerz.examples.algorithm.trees;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.hasItems;

/**
 * Given an integer n, return 1 - n in lexicographical order.
 *
 * For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].
 *
 * Please optimize your algorithm to use less time and space. The input size may be as large as 5,000,000.
 *
 * https://leetcode.com/problems/lexicographical-numbers/
 */
public class LexicographicalNumbers {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> l = new LinkedList<>();
        for (int i = 1; i <= 9; i++) {
            dfs(n, l, i);
        }
        return l;
    }

    private void dfs(int n, List<Integer> l, int start) {
        if (start > n) return;
        l.add(start);
        for (int i = 0; i <= 9; i++) {
            dfs(n, l, start * 10 + i);
        }
    }

    @Test
    public void test1() {
        List<Integer> numbers = lexicalOrder(20);
        assertEquals(20, numbers.size());
    }

    @Test
    public void test2() {
        List<Integer> numbers = lexicalOrder(10);
        assertEquals(10, numbers.size());
        assertThat(numbers, hasItems(1,10,2,3,4,5,6,7,8,9));
    }
}


