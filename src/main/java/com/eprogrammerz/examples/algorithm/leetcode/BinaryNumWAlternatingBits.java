package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * https://leetcode.com/problems/binary-number-with-alternating-bits/
 *
 */
public class BinaryNumWAlternatingBits {
    public boolean hasAlternatingBits(int n) {
        boolean one = (n & 1) == 1;
        while (n > 0) {
            n = n >> 1;
            int curr = n & 1;
            if ((curr == 1 && one) || (curr == 0 && !one)) {
                return false;
            }
            one = !one;
        }
        return true;
    }

    @Test
    public void test() {
        assertTrue(hasAlternatingBits(1));
        assertTrue(hasAlternatingBits(2));
        assertFalse(hasAlternatingBits(4));
        assertTrue(hasAlternatingBits(5));
        assertFalse(hasAlternatingBits(7));
        assertFalse(hasAlternatingBits(8));
        assertTrue(hasAlternatingBits(10));
        assertFalse(hasAlternatingBits(11));
    }
}
