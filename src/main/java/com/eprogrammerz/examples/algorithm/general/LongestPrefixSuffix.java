package com.eprogrammerz.examples.algorithm.general;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Given a string str, find length of the longest string which proper prefix and also proper suffix of str.
 * Prefix and Suffix are proper if length is less than length of str
 *
 * Examples:
 *
 * Input : aabcdaabc
 * Output : 4
 * The string "aabc" is the longest
 * prefix which is also suffix.
 *
 * Input : abcab
 * Output : 2
 *
 * Input : aaaa
 * Output : 3
 */
public class LongestPrefixSuffix {
    /**
     * Time O(n^2)
     * Space O(n)
     *
     * @param str
     * @return
     */
    public int findLongestPrefixSuffixLen(String str) {
        if (str == null) throw new IllegalArgumentException("Null input!");

        int lpsLen = 0;
        if (str.length() < 2) return lpsLen;

        Set<String> prefixes = new HashSet<>();

        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < str.length() - 1; i++) {
            prefix.append(str.charAt(i));
            prefixes.add(prefix.toString());
        }

        StringBuilder suffix = new StringBuilder();
        for (int i = str.length() - 1; i > 0; i--) {
            suffix.insert(0, str.charAt(i));
            if (prefixes.contains(suffix.toString()) && suffix.length() > lpsLen) {
                lpsLen = suffix.length();
            }
        }
        return lpsLen;
    }

    @Test
    public void testFindLongestPrefixSuffixLen() {
        assertEquals(4, findLongestPrefixSuffixLen("aabcdaabc")); // aabc
        assertEquals(2, findLongestPrefixSuffixLen("abcab")); // ab
        assertEquals(3, findLongestPrefixSuffixLen("aaaa")); // aaa
        assertEquals(6, findLongestPrefixSuffixLen("blablabla")); // blabla
    }

    /**
     * Time O(n)
     * Space O(1)
     *
     * @param str
     * @return
     */
    public int findLongestPrefixSuffixLenKmp(String str)
    {
        if (str == null) throw new IllegalArgumentException("Null input!");

        int prefix = 0;

        // we start with prefix and suffix length and start matching left and right string.
        // If they are equal increase size of lps string else try for shorter lengths on both sides.
        int len = str.length();
        int suffix = 1;

        int[] lps = new int[len];

        // lps[0] is always 0
        lps[0] = 0;

        // the loop calculates lps[i]
        // for suffix = 1 to len-1
        while (suffix < len)
        {
            if (str.charAt(prefix) == str.charAt(suffix)) {
                prefix++;
                suffix++;

                lps[suffix] = prefix;
            } else {
                if (prefix == 0) {
                    lps[suffix] = 0;
                    suffix++;
                } else {
                    prefix = lps[prefix-1];
                }
            }
        }

        return lps[len-1];
    }

    @Test
    public void testFindLongestPrefixSuffixLenKmp() {
        assertEquals(4, findLongestPrefixSuffixLenKmp("aabcdaabc")); // aabc
        assertEquals(2, findLongestPrefixSuffixLenKmp("abcab")); // ab
        assertEquals(3, findLongestPrefixSuffixLenKmp("aaaa")); // aaa
        assertEquals(6, findLongestPrefixSuffixLenKmp("blablabla")); // blabla
    }

    /**
     * Time O(n)
     * Space O(1)
     *
     * @param str
     * @return
     */
    public int findLongestPrefixSuffixLenBetter(String str) {
        if (str == null) throw new IllegalArgumentException("Null input!");

        int prefix = 0;

        if (str.length() < 2) return prefix;

        // we start with prefix and suffix length and start matching left and right string.
        // If they are equal increase size of lps string else try for shorter lengths on both sides.
        int len = str.length();
        int suffix = 1;

        while (suffix < len) {
            if (str.charAt(prefix) == str.charAt(suffix)) {
                prefix++;
                suffix++;
            } else {
                if (prefix == 0) {
                    suffix++;
                } else {
                    prefix--;
                }
            }
        }

        return prefix;
    }

    @Test
    public void testFindLongestPrefixSuffixLenBetter() {
        assertEquals(4, findLongestPrefixSuffixLenBetter("aabcdaabc")); // aabc
        assertEquals(2, findLongestPrefixSuffixLenBetter("abcab")); // ab
        assertEquals(3, findLongestPrefixSuffixLenBetter("aaaa")); // aaa
        assertEquals(6, findLongestPrefixSuffixLenBetter("blablabla")); // blabla
    }
}
