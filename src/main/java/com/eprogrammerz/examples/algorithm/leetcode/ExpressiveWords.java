package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/expressive-words/
 */
public class ExpressiveWords {
    public int expressiveWords(String S, String[] words) {
        int count = 0;
        for (String word : words) {
            if (sketchy(word, S)) count++;
        }
        return count;
    }

    private boolean sketchy(String word, String sketch) {

        int i = 0, j = 0;
        while (i < word.length() && j < sketch.length()) {
            char p = word.charAt(i);
            char q = sketch.charAt(j);

            if (p != q) return false;

            int pc = 0;
            int qc = 0;
            while (i < word.length() && p == word.charAt(i)) {
                pc++;
                i++;
            }

            while (j < sketch.length() && q == sketch.charAt(j)) {
                qc++;
                j++;
            }

            if (pc > qc) return false;

            int diff = qc - pc;

            if (diff != 0 && diff + pc < 3) return false;
        }

        return i == word.length() && j == sketch.length();
    }

    @Test
    public void test() {
        assertEquals(3, expressiveWords("dddiiiinnssssssoooo", new String[] {"dinnssoo","ddinso","ddiinnso","ddiinnssoo","ddiinso","dinsoo","ddiinsso","dinssoo","dinso"}));
        assertEquals(1, expressiveWords("heeellooo", new String[]{"hello", "hi", "helo"}));
    }
}
