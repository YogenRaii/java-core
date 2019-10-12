package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * Implement a basic calculator to evaluate a simple expression string.
 *
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.
 *
 * Example 1:
 *
 * Input: "3+2*2"
 * Output: 7
 */
public class BasicCalculatorII {
    private List<Character> symbols = Arrays.asList('/', '*', '+', '-');

    public int calculate(String str) {
        str = str.replaceAll(" ", "");
        if (str.length() == 0) return 0;
        if (str.length() == 1) return Integer.valueOf(str);

        int start = 0;
        int end = 0;

        Stack<Integer> s = new Stack<>();
        char lastOp = '#';
        while (end < str.length()) {

            while (end < str.length()) {
                if (symbols.contains(str.charAt(end))) {
                    break;
                }
                end++;
            }
            // if the expression starts with '-', then it has to be taken care
            if (end != 0) {
                int n = Integer.valueOf(str.substring(start, end));
                if (lastOp == '*') {
                    int mul = s.isEmpty() ? 1 : s.pop();
                    s.push(mul * n);
                } else if (lastOp == '/') {
                    int mul = s.isEmpty() ? 0 : s.pop();
                    s.push(mul / n);
                } else if (lastOp == '-') {
                    s.push((-1) * n);
                } else {
                    s.push(n);
                }
            }
            if (end < str.length()) {
                lastOp = str.charAt(end);
                end = end + 1;
                start = end;
            }

        }

        int res = 0;
        while (!s.isEmpty()) {
            res += s.pop();
        }
        return res;
    }

    @Test
    public void test() {
        assertEquals(7, calculate("3+2*2"));
        assertEquals(1, calculate("-3+2*2"));
        assertEquals(1, calculate("1-1+1"));
        assertEquals(27, calculate("3+2*2+4*5"));
        assertEquals(5, calculate(" 3+5 / 2 "));
        assertEquals(-2147483647, calculate("0-2147483647"));
    }
}
