package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Find if you can make a string palindrome by removing atmost one character
 *
 * https://leetcode.com/problems/valid-palindrome-ii/
 */
public class ValidPalindromeII {

    public boolean validPalindrome(String s) {
        if (s == null || s.isEmpty() || s.length() == 1) return true;
        int start = 0;
        int end = s.length() - 1;
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {

                return validPalindrome(s, start + 1, end)
                        || validPalindrome(s, start, end - 1);
            }
            start++;
            end--;
        }
        return true;
    }

    private boolean validPalindrome(String s, int start, int end) {
        if (s.isEmpty()) return true;
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    @Test
    public void test1() {
        assertTrue(validPalindrome("abda"));
        assertFalse(validPalindrome("abbcda"));
        assertTrue(validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
    }
}
