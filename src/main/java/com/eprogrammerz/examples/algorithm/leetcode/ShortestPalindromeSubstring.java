package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/shortest-palindrome/
 *
 * Given a string s, you are allowed to convert it to a palindrome by adding characters in front of it.
 * Find and return the shortest palindrome you can find by performing this transformation.
 *
 * Example 1:
 *
 * Input: "aacecaaa"
 * Output: "aaacecaaa"
 * Example 2:
 *
 * Input: "abcd"
 * Output: "dcbabcd"
 */
public class ShortestPalindromeSubstring {
    public String shortestPalindrome(String s) {
        if (s.length() <= 1) return s;
        // find longest palindrome p substring in s
        // if indexof(p) == 0
        //  app chars from p.length() .. s.length()
        // else add chars from 1 .. s.length()

        int longest = longestPalindromeSubstringKmp(s);
        if (longest == s.length()) return s;

        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(longest));

        return sb.reverse().toString() + s;
    }

    private int longestPalindromeSubstringKmp(String s) {
        int[] lps = findLps(s + "#" + new StringBuilder(s).reverse().toString());
        return lps[lps.length - 1];
    }

    private int[] findLps(String s) {
        int[] lps = new int[s.length()];

        lps[0] = 0;
        int j = 0;
        int i = 1;

        while (i < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                j++;
                lps[i] = j;
                i++;
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }


    /**
     * Time O(n^2)
     * Space O(1)
     *
     * @param s
     * @return
     */
    private String longestPalindromeSubstring(String s) {
        int n = s.length();

        int start = 0;
        int end = n - 1;

        int palindrome = end;

        while (start < end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                start = 0;
                end = palindrome - 1;
                palindrome = end;
            }

        }

        return s.substring(0, palindrome + 1);
    }

    @Test
    public void test() {
        assertEquals("ababbabbbababbbabbaba", shortestPalindrome("ababbbabbaba"));
        assertEquals("aba", shortestPalindrome("aba"));
        assertEquals("dcbabcd", shortestPalindrome("abcd"));
        assertEquals("aaacecaaa", shortestPalindrome("aacecaaa"));
        assertEquals("bbabb", shortestPalindrome("abb"));
        assertEquals("abbaabba", shortestPalindrome("aabba"));
        assertEquals("abbbaaaabbba", shortestPalindrome("aaaabbba"));
        assertEquals("abbbaaaaabbba", shortestPalindrome("aaaaabbba"));
    }
}
