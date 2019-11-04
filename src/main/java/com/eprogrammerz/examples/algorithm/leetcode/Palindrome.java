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

    public boolean isPalindrome(int x) {
        int originalVal = x;
        int reversedX = 0;
        while(x != 0) {
            reversedX = reversedX * 10 + x % 10;
            x /= 10;
        }
        return originalVal == reversedX;
    }

    public boolean isPalindrome(String s) {
        if (s.isEmpty()) return true;
        int start = 0;
        int end = s.length() - 1;

        while (start <= end) {
            char startChar = s.charAt(start);
            char endChar = s.charAt(end);

            // startChar is lowercase
            if (startChar >= 'a' && startChar <= 'z') {
                startChar = (char)('A' + (startChar - 'a'));
            }

            if (endChar >= 'a' && endChar <= 'z') {
                endChar = (char)('A' + (endChar - 'a'));
            }

            if ((startChar < 'A' || startChar > 'Z') && (startChar < '0' || startChar > '9')) {
                start++;
                continue;
            }

            if ((endChar < 'A' || endChar > 'Z') && (endChar < '0' || endChar > '9')) {
                end--;
                continue;
            }

            if (startChar != endChar) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    @Test
    public void test() {
        assertTrue(isPalindrome("A man, a plan, a canal: Panama"));
    }
}
