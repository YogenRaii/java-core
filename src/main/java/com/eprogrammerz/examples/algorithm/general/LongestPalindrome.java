package com.eprogrammerz.examples.algorithm.general;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

/**
 * find the longest possible palindrome substring in given string
 *
 * banana -> anana
 * racecar -> racecar
 * ac -> a
 * bb -> bb
 */
public class LongestPalindrome {
    /**
     * O(n^3)
     * @param str
     * @return longest palindrome substring
     */
    public String findLongestPalindrome(String str) {
        String result = "";

        if (str == null) return result;

        for (int start = 0; start < str.length(); start++) {
            StringBuilder substr = new StringBuilder();
            substr.append(str.charAt(start));

            for (int end = start + 1; end <= str.length(); end++) {
                String possiblePalindrome = substr.toString();

                if (isPalindrome(possiblePalindrome) && possiblePalindrome.length() > result.length()) {
                    result = possiblePalindrome;
                }

                if (end < str.length()) {
                    substr.append(str.charAt(end));
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
        assertEquals("a", findLongestPalindrome("a"));
        assertEquals("bb", findLongestPalindrome("bb"));
        assertEquals("anana", findLongestPalindrome("banana"));
        assertEquals("racecar", findLongestPalindrome("racecar"));
    }

    /**
     * O(n^2)
     *
     * This approach considers each char as mid and find the possible palindrome out of it
     * This has to be taken care for both odd and even centric chars
     *
     * @param str
     * @return LPS
     */
    public String findLongestPalindromeBetter(String str) {
        if (str == null || str.isEmpty()) return "";
        if (str.length() == 1) return str;

        int start = 0;
        int len = 1;

        for (int idx = 1; idx < str.length(); idx++) {
            // considering odd center
            int low = idx - 1;
            int high = idx;

            while (low >= 0 && high < str.length() && str.charAt(low) ==  str.charAt(high)) {
                if (high - low + 1 > len) {
                    start = low;
                    len = high - low + 1;
                }
                low--;
                high++;
            }

            // considering even at center
            low = idx - 1;
            high = idx + 1;
            while (low >= 0 && high < str.length() && str.charAt(low) ==  str.charAt(high)) {
                if (high - low + 1 > len) {
                    start = low;
                    len = high - low + 1;
                }
                low--;
                high++;
            }
        }

        return str.substring(start, start + len);
    }

    @Test
    public void testFindLongestPalindromeBetter() {
        assertTrue(findLongestPalindromeBetter("").isEmpty());
        assertTrue(findLongestPalindromeBetter(null).isEmpty());
        assertEquals("a", findLongestPalindromeBetter("a"));
        assertEquals("a", findLongestPalindromeBetter("ac"));
        assertEquals("bb", findLongestPalindromeBetter("bb"));
        assertEquals("anana", findLongestPalindromeBetter("banana"));
        assertEquals("racecar", findLongestPalindromeBetter("racecar"));
    }
}
