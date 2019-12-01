package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstrWORep {
    public int lengthOfLongestSubstring(String s) {
        // use map to track index of that character, and if it there in map,
        // then start looking into element next to it

        int[] indices = new int[256];
        Arrays.fill(indices, -1);

        int len = 0;
        int start = 0;

        int i = 0;
        while (i < s.length()) {

            char ch = s.charAt(i);

            int index = indices[ch];

            if (i > start && index >= start) {
                if (i - start > len) len = i - start;

                start = index + 1;
            }
            indices[ch] = i;
            i++;
        }
        return Math.max(i - start, len);

        /*
        Map<Character, Integer> map = new HashMap<>();
        int len = 0;
        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (map.containsKey(ch)) {
                if (map.size() > len) len = map.size();
                i = map.get(ch);
                map.clear();
            } else {
                map.put(ch, i);
            }
        }
        return Math.max(map.size(), len);

        */
    }

    @Test
    public void test() {

        assertEquals(5, lengthOfLongestSubstring("anviaj"));
        assertEquals(3, lengthOfLongestSubstring("dvdf"));
        assertEquals(3, lengthOfLongestSubstring("pwwkew"));
        assertEquals(3, lengthOfLongestSubstring("abcabcbb"));
        assertEquals(1, lengthOfLongestSubstring("bbbbb"));
        assertEquals(1, lengthOfLongestSubstring("  "));
        assertEquals(1, lengthOfLongestSubstring(" "));
        assertEquals(2, lengthOfLongestSubstring("abba"));
        assertEquals(5, lengthOfLongestSubstring("qrsvbspk"));
        assertEquals(2, lengthOfLongestSubstring("aab"));
        assertEquals(2, lengthOfLongestSubstring("au"));
    }
}
