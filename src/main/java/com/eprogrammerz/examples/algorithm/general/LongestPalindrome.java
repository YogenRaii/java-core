package com.eprogrammerz.examples.algorithm.general;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

/**
 * find the longest possible palindrome substring in given string
 *
 * banana -> anana
 * racecar -> racecar
 *
 */
public class LongestPalindrome {
    public String findLongestPalindrome(String str) {
        String result = "";

        if (str == null) return result;

        for (int start = 0; start < str.length(); start++) {
            StringBuilder substr = new StringBuilder();
            substr.append(str.charAt(start));

            for (int end = start + 1; end < str.length(); end++) {
                substr.append(str.charAt(end));
                String possiblePalindrome = substr.toString();

                if (isPalindrome(possiblePalindrome) && possiblePalindrome.length() > result.length()) {
                    result = possiblePalindrome;
                }
            }
        }

        return result;
    }

    private boolean isPalindrome(String str) {
        String reverse = new StringBuilder(str).reverse().toString();
        return str.equals(reverse);
    }

    @Test
    public void testFindLongestPalindrome() {
        assertTrue(findLongestPalindrome("").isEmpty());
        assertTrue(findLongestPalindrome(null).isEmpty());
        assertEquals("anana", findLongestPalindrome("banana"));
        assertEquals("racecar", findLongestPalindrome("racecar"));
    }
}
