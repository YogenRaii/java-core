package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/
 */
public class LongestWordInDict {
    public String findLongestWord(String s, List<String> d) {
        String res = "";
        for (String word: d) {
            if (canForm(word, s)) {
                if (word.length() > res.length())
                    res = word;
                else if (word.length() == res.length() && word.compareTo(res) < 0) {
                    res = word;
                }
            }
        }
        return res;
    }

    private boolean canForm(String word, String str) {
        int i = 0;
        int j = 0;

        while (i < word.length() && j < str.length()) {
            if (word.charAt(i) == str.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        return i == word.length();
    }

    @Test
    public void test() {
        assertEquals("apple", findLongestWord("abpcplea", Arrays.asList("ale","apple","monkey","plea")));
    }
}
