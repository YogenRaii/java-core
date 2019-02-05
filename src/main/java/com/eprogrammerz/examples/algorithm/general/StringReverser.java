package com.eprogrammerz.examples.algorithm.general;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * https://www.programcreek.com/2014/05/leetcode-reverse-words-in-a-string-ii-java/
 *
 * Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.
 */
public class StringReverser {

    public String reverseWords(String str) {
        if (str == null || str.isEmpty()) return null;

        String[] words = str.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int idx = words.length - 1; idx >0 ; idx--) {
            sb.append(words[idx]);
            sb.append(" ");
        }
        sb.append(words[0]);
        return sb.toString();
    }

    @Test
    public void testReverseWords() {
        assertNull(reverseWords(null));
        assertEquals("blue is sky the", reverseWords("the sky is blue"));
        assertEquals("blue is  sky the", reverseWords("the sky  is blue"));
    }
}
