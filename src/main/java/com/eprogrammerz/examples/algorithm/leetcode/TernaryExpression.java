package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/ternary-expression-parser/
 */
public class TernaryExpression {
    public String parseTernary(String expression) {
        int n = expression.length();
        if (n <= 1) return expression;

        char first = expression.charAt(0);

        int i = 1;
        int ques = 0;

        while (i < n) {
            if (expression.charAt(i) == ':') {
                ques--;
                if (ques == 0) break;
            } else if (expression.charAt(i) == '?') ques++;

            i++;
        }

        if (first == 'T') {
            // take first part

            return parseTernary(expression.substring(2, i));
        } else {
            // take second part
            return parseTernary(expression.substring(i + 1));
        }

    }

    @Test
    public void test() {
        assertEquals("2", parseTernary("T?2:3"));
        assertEquals("4", parseTernary("F?1:T?4:5"));
        assertEquals("F", parseTernary("T?T?F:5:3"));
    }
}
