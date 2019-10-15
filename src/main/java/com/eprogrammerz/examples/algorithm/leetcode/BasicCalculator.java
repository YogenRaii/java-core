package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertEquals;

/**
 * Implement a basic calculator to evaluate a simple expression string.
 *
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .
 *
 * Example 1:
 *
 * Input: "1 + 1"
 * Output: 2
 * Example 2:
 *
 * Input: " 2-1 + 2 "
 * Output: 3
 * Example 3:
 *
 * Input: "(1+(4+5+2)-3)+(6+8)"
 * Output: 23
 */
public class BasicCalculator {
    public int calculate(String s) {
        s = s.replaceAll(" ", "");

        Stack<Integer> stack = new Stack<>();

        int start = 0;
        int mul = 1;
        int end = 0;
        for (end = 0; end < s.length(); end++) {
            if (s.charAt(end) == '+' || s.charAt(end) == '-') {
                if (start < end) {
                    int n = mul * Integer.valueOf(s.substring(start, end));
                    stack.push(n);
                }

                mul = s.charAt(end) == '-' ? -1: 1;
                start = end + 1;
            } else if (s.charAt(end) == '(') {
                // find closing
                int close = end + 1;
                int openBrace = 0;
                while (++end < s.length()) {
                    if (s.charAt(end) == '(') openBrace++;
                    if (s.charAt(end) == ')' && openBrace == 0) break;
                    else if (s.charAt(end) == ')') openBrace--;
                }
                stack.push(mul * calculate(s.substring(close, end)));
                start = end + 1;
            }
        }
        if (start < end) stack.push(mul * Integer.valueOf(s.substring(start)));

        int sum = 0;
        while(!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }

    @Test
    public void test1() {
        assertEquals(2, calculate("1 + 1"));
        assertEquals(3, calculate("2 - 1 +2"));
        assertEquals(-11, calculate("-12 - 1 +2"));
        assertEquals(-9, calculate("-(12 - 1) +2"));
        assertEquals(23, calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}
