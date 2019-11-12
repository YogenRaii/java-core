package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/remove-k-digits/
 */
public class RemoveKDigits {
    /**
     * if encounter digits less than previous, then remove all of them until it becomes non-decreasing
     *
     * @param num
     * @param k
     * @return
     */
    public String removeKdigits(String num, int k) {
        Stack<Character> s = new Stack<>();
        for (char n: num.toCharArray()) {

            while (k > 0 && !s.isEmpty() && s.peek() > n) {
                s.pop();
                k--;
            }
            if (s.isEmpty()) {
                if (n != '0')
                    s.push(n);
            } else {
                s.push(n);
            }
        }

        while (k > 0 && !s.isEmpty()) {
            s.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while (!s.isEmpty()) {
            sb.append(s.pop());
        }

        return sb.length() > 0 ? sb.reverse().toString(): "0";
    }

    @Test
    public void test() {
        assertEquals("0", removeKdigits("10", 2));
        assertEquals("1219", removeKdigits("1432219", 3));
        assertEquals("200", removeKdigits("10200", 1));
        assertEquals("0", removeKdigits("10", 2));
        assertEquals("123450", removeKdigits("1234567890", 4));
        assertEquals("0", removeKdigits("1234", 4));
        assertEquals("0", removeKdigits("9", 1));
        assertEquals("1111", removeKdigits("1111111", 3));
    }
}
