package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/score-of-parentheses/
 */
public class ScoreOfParentheses {
    public int scoreOfParentheses(String S) {
        // at i, open = 1, go on till open = 0 at j
        // sofar = 2 * substring (i + 1, j)
        // ans += sofar

        int n = S.length();

        if (n == 0) return 0;

        if (n == 2) return 1;

        int ans = 0;

        for (int i = 0; i < n;) {
            int open = 1;
            int j = i + 1;
            while(j < n) {
                if (S.charAt(j) == '(') open++;
                else {
                    open--;
                    if (open == 0) break;
                }
                j++;
            }
            String rem = S.substring(i + 1, j);
            ans += (rem.length() == 0 ? 1 : 2 * scoreOfParentheses(rem));
            i = j + 1;
        }

        return ans;
    }

    @Test
    public void test() {
        assertEquals(2, scoreOfParentheses("()()"));
        assertEquals(2, scoreOfParentheses("(())"));
        assertEquals(3, scoreOfParentheses("()(())"));
        assertEquals(6, scoreOfParentheses("(()(()))"));
    }
}
