package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

/**
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 *
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 *
 * The order of output does not matter.
 *
 * Example 1:
 *
 * Input:
 * s: "cbaebabacd" p: "abc"
 *
 * Output:
 * [0, 6]
 *
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 */
public class FindAllAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> l = new ArrayList<>();
        if (s.length() < p.length()) return l;
        Map<Character, Integer> map = new HashMap<>();
        for (char ch: p.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int end = p.length() - 1;

        while (end < s.length()) {
            if (map.containsKey(s.charAt(end))) {
                // match
                Map<Character, Integer> temp = new HashMap<>(map);

                int j = 0;
                for (int i = p.length() - 1; i >= 0; i--) {
                    char ch = s.charAt(end - j++);
                    if (!temp.containsKey(ch)) {
                        break;
                    }

                    int count = temp.get(ch) - 1;
                    if (count == 0) temp.remove(ch);
                    else temp.put(ch, count);
                }

                if (temp.isEmpty()) {
                    l.add(end - p.length() + 1);
                }
                end++;
            } else {
                end += p.length();
            }
        }
        return l;
    }

    @Test
    public void test1() {
        List<Integer> expected = Arrays.asList(0, 6);
        List<Integer> actual = findAnagrams("cbaebabacd", "abc");
        assertThat(actual, is(expected));
    }

    @Test
    public void test2() {
        List<Integer> expected = Arrays.asList(0, 1, 2);
        List<Integer> actual = findAnagrams("abab", "ab");
        assertThat(actual, is(expected));
    }
}
