package com.eprogrammerz.examples.algorithm.graphs;

import com.eprogrammerz.examples.algorithm.trees.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.assertEquals;

/**
 * You are given an integer N. You have to find smallest multiple of N which consists of digits 0 and 1 only.
 * Since this multiple could be large, return it in form of a string.
 *
 * Note:
 *
 * Returned string should not contain leading zeroes.
 *
 * For N = 55, 110 is smallest multiple consisting of digits 0 and 1.
 * For N = 2, 10 is the answer.
 */
public class SmallestMultiple {

    public String multiple(int n) {
        Queue<Long> queue = new LinkedList<>();
        queue.add(1L);

        String res = "";

        while (!queue.isEmpty()) {
            long multiple = queue.poll();
            long rem = multiple % n;
            if (rem == 0) {
                res += multiple;
                break;
            }

            long left = multiple * 10;
            if (n % left  == 0) {
                queue.add(left);
            }
            long right = multiple * 10 + 1;
            if (n % right == 0) {
                queue.add(right);
            }
        }
        return res;
    }

    @Test
    public void testMultiple() {
        assertEquals("110", multiple(55));
        assertEquals("10", multiple(5));
        assertEquals("10", multiple(2));
    }
}
