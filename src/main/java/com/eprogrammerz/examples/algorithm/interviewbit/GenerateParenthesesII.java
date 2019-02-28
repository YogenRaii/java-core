package com.eprogrammerz.examples.algorithm.interviewbit;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * https://www.interviewbit.com/problems/generate-all-parentheses-ii/
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses of length 2*n.
 *
 * For example, given n = 3, a solution set is:
 *
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 * Make sure the returned list of strings are sorted.
 */
public class GenerateParenthesesII {
    public List<String> generateParenthesis(int n) {
        List<String> parentheses = new ArrayList<>();
        generateParentheses("", 0, 0, parentheses, n);

        return parentheses;
    }

    private void generateParentheses(String output, int open, int close, List<String> parentheses, int n) {
        // if output is correct, then add to result
        if ( output.length() == 2 * n) {
            parentheses.add(output);
        } else {
            if (open < n) {
                generateParentheses(output + "(", open + 1, close, parentheses, n);
            }

            if (close < open) {
                generateParentheses(output + ")", open, close + 1, parentheses, n);
            }
        }
    }

    @Test
    public void testGenerateParentheses() {
        List<String> expected = Arrays.asList("((()))", "(()())", "(())()", "()(())", "()()()");
        assertEquals(expected, generateParenthesis(3));
    }
}
