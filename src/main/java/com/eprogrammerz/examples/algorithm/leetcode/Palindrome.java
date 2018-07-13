package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Yogen on 9/28/2017.
 */
public class Palindrome {
    @Test
    public void testIsPalindrome() {
        assertTrue(isPalindrome(-121));
        assertTrue(isPalindrome(-1221));
        assertTrue(isPalindrome(-12321));
        assertTrue(isPalindrome(12321));
        assertFalse(isPalindrome(122321));
    }

    public static boolean isPalindrome(int x) {
        int originalVal = x;
        int reversedX = 0;
        while(x != 0) {
            reversedX = reversedX * 10 + x % 10;
            x /= 10;
        }
        return originalVal == reversedX;
    }
}
