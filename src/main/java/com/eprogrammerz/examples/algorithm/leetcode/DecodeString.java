package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/decode-string/
 */
public class DecodeString {
    /**
     * Do recursive call if there is nested string to form input format
     *
     * @param s
     * @return
     */
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>(); //
        StringBuilder num = new StringBuilder();
        StringBuilder str = new StringBuilder();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                num.append(s.charAt(i)); // nums = '2'
                if (str.length() > 0) {
                    res.append(str.toString());
                    str = new StringBuilder();
                }
            } else if (s.charAt(i) == '[') {
                stack.push(num.toString()); // stack = ['3']
                // find close and call
                int start = ++i; // 1
                int open = 0;
                for (; i < s.length(); i++) {
                    if (s.charAt(i) == '[') {
                        open++;
                    } else if (s.charAt(i) == ']') {
                        if (open == 0) {

                            break;
                        }
                        open--;
                    }
                }
                str.append(decodeString(s.substring(start, i)));
                num = new StringBuilder(); // nums = ''
                i--;
            } else if (s.charAt(i) == ']') {
                String curr = stack.pop();
                try {
                    Integer times = Integer.valueOf(curr);
                    for (int j = 0 ; j < times; j++) {
                        res.append(str.toString());
                    }

                } catch (NumberFormatException nfe) {

                }
                str = new StringBuilder();
            } else {
                str.append(s.charAt(i));
            }
        }
        res.append(str.toString());
        return res.toString();
    }

    @Test
    public void test1() {
        assertEquals("accaccacc", decodeString("3[a2[c]]"));
    }
}
