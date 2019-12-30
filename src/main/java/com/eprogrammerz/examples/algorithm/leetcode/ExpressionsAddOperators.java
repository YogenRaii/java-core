package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * https://leetcode.com/problems/expression-add-operators/
 *
 *
 * Given a string that contains only digits 0-9 and a target value, return all possibilities to
 * add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.
 *
 * Example 1:
 *
 * Input: num = "123", target = 6
 * Output: ["1+2+3", "1*2*3"]
 */
public class ExpressionsAddOperators {
    public List<String> addOperators(String num, int target) {
        List<String> l = new ArrayList<>();
        if (num.length() == 0) return l;

        bt(num, target, l, 1, "" + num.charAt(0));
        return l;
    }

    private void bt(String num, int target, List<String> l, int i, String exp) {
        if (i == num.length()) {
            if (evaluate(exp) == target) {
                l.add(exp);
            }
            return;
        }

        bt(num, target, l, i + 1, exp + num.charAt(i)); // no op
        bt(num, target, l, i + 1, exp + "+" + num.charAt(i));
        bt(num, target, l, i + 1, exp + "-" + num.charAt(i));
        bt(num, target, l, i + 1, exp + "*" + num.charAt(i));
    }

    private long evaluate(String exp) {

        Stack<Long> stack = new Stack<>();

        char lastExp = '#';

        long curr = 0;
        for (int i = 0; i < exp.length(); i++) {
            if ('0' <= exp.charAt(i) && exp.charAt(i) <= '9') {
                if (curr == 0 && exp.charAt(i) == '0'
                        && (i + 1) < exp.length()
                        && '0' <= exp.charAt(i + 1) && exp.charAt(i + 1) <= '9')
                    return Integer.MAX_VALUE;

                curr = curr * 10 + (exp.charAt(i) - '0');
                continue;
            }

            if (lastExp == '*') {
                stack.push(stack.pop() * curr);
            } else if (lastExp == '-') {
                stack.push(-curr);
            } else {
                stack.push(curr);
            }
            lastExp = exp.charAt(i);
            curr = 0;
        }

        if (lastExp == '*') {
            stack.push(stack.pop() * curr);
        } else if (lastExp == '-') {
            stack.push(-curr);
        } else {
            stack.push(curr);
        }


        long val = 0;

        while (!stack.isEmpty()) {
            val += stack.pop();
        }
        return val;
    }

    @Test
    public void test() {
        assertThat(addOperators("123", 6), is(Arrays.asList("1+2+3", "1*2*3")));
        assertThat(addOperators("105", 5), is(Arrays.asList("10-5", "1*0+5")));
    }
}
