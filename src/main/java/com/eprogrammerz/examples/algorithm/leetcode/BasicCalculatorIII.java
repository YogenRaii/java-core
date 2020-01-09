package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/basic-calculator-iii/
 */
public class BasicCalculatorIII {
    public int calculate(String s) {
        s = s.trim();

        Stack<Integer> stack = new Stack<>();

        char sign = '#';

        int curr = 0;

        for (int i = 0; i < s.length();) {
            char ch = s.charAt(i);

            if (ch == ' ') {
                i++;
                continue;
            }

            if ('0' <= ch && ch <= '9') {
                curr = curr * 10 + (ch - '0');

                if (i + 1 < s.length()) {
                    i++;
                    continue;
                }
            } else if (ch == '(') {
                int j = i + 1;

                int open = 1;
                while (j < s.length()) {
                    char close = s.charAt(j);

                    if (close == '(') open++;
                    else if (close == ')') {
                        open--;
                        if (open == 0) {
                            break;
                        }
                    }
                    j++;
                }
                curr = calculate(s.substring(i + 1, j));
                i = j + 1;

                while (i < s.length()) {
                    ch = s.charAt(i);
                    if (ch == '-' || ch == '+' || ch == '*' || ch == '/') break;
                    i++;
                }
            }

            if (sign == '*') {
                int prev = stack.pop();
                stack.push(prev * curr);
            } else if (sign == '/') {
                int prev = stack.pop();
                stack.push(prev / curr);
            } else if (sign == '-') {
                stack.push((-1) * curr);
            } else {
                stack.push(curr);
            }

            sign = ch;
            curr = 0;
            i++;
        }

        int res = 0;

        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    @Test
    public void test() {
        assertEquals(2, calculate("1 + 1"));
        assertEquals(4, calculate(" 6-4 / 2 "));
        assertEquals(21, calculate("2*(5+5*2)/3+(6/2+8)"));
        assertEquals(-12, calculate("(2+6* 3+5- (3*14/7+2)*5)+3"));
    }
}
