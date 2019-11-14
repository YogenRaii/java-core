package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/edit-distance/
 *
 * Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
 *
 * You have the following 3 operations permitted on a word:
 *
 * Insert a character
 * Delete a character
 * Replace a character
 * Example 1:
 *
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {


        int m = word1.length();
        int n = word2.length();

        int[][] mem = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    mem[i][j] = j;
                } else if (j == 0) {
                    mem[i][j] = i;
                } else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    mem[i][j] = mem[i - 1][j - 1];
                } else {
                    mem[i][j] = 1 + Math.min(mem[i - 1][j - 1], Math.min(
                            mem[i - 1][j], mem[i][j - 1]));
                }
            }
        }
        return mem[m][n];


        /*

        // recursive
        // if charAt(0) are same for both, then keep going
        // else, min(change, delete on s1, delete on s2)

        if (word1.length() == 0 && word2.length() == 0) return 0;
        if (word1.length() == 0) return word2.length();
        if (word2.length() == 0) return word1.length();

        int count = 0;
        if (word1.charAt(0) == word2.charAt(0)) {
            count += minDistance(word1.substring(1), word2.substring(1));
        } else {
            count += 1 + Math.min(minDistance(word1.substring(1), word2.substring(1)), Math.min(minDistance(word1.substring(1), word2),
                                 minDistance(word1, word2.substring(1))));
        }
        return count;
        */
    }

    @Test
    public void test() {
        assertEquals(3, minDistance("horse", "ros"));
        assertEquals(5, minDistance("intention", "execution"));
        assertEquals(6, minDistance("dinitrophenylhydrazine","acetylphenylhydrazine"));
    }
}
