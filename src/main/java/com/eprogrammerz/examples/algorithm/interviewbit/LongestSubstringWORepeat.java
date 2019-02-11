package com.eprogrammerz.examples.algorithm.interviewbit;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;


/**
 * Given a string,
 * find the length of the longest substring without repeating characters.
 *
 * Example:
 *
 * The longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.
 *
 * For "bbbbb" the longest substring is "b", with the length of 1.
 */

public class LongestSubstringWORepeat {
    public int lengthOfLongestSubstring(String str) {
        if (str == null || str.isEmpty()) return 0;

        int uniqueSubstrCount = 0;
        for (int start = 0; start < str.length(); start++) {
            Set<Character> chars = new HashSet<>();
            chars.add(str.charAt(start));

            for (int end = start + 1; end < str.length(); end++) {
                if (chars.contains(str.charAt(end))) {
                    break;
                } else {
                    chars.add(str.charAt(end));
                }
            }

            if (chars.size() > uniqueSubstrCount) {
                uniqueSubstrCount = chars.size();
            }
        }
        return uniqueSubstrCount;
    }

    @Test
    public void testLengthOfLongestSubstring() {
        assertEquals(0, lengthOfLongestSubstring(""));
        assertEquals(1, lengthOfLongestSubstring("u"));
        assertEquals(1, lengthOfLongestSubstring("bbbbbbbb"));
        assertEquals(3, lengthOfLongestSubstring("abcabcbb"));
    }
}
