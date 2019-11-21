package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Given two strings representing two complex numbers.
 *
 * You need to return a string representing their multiplication. Note i2 = -1 according to the definition.
 *
 * Example 1:
 * Input: "1+1i", "1+1i"
 * Output: "0+2i"
 * Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.
 *
 *
 * https://leetcode.com/problems/complex-number-multiplication/
 */
public class ComplexNumberMul {
    public String complexNumberMultiply(String a, String b) {
        String[] arr = a.split("\\+");
        int x1 = Integer.valueOf(arr[0]);
        int y1 = Integer.valueOf(arr[1].substring(0, arr[1].length() - 1));

        String[] brr = b.split("\\+");
        int x2 = Integer.valueOf(brr[0]);
        int y2 = Integer.valueOf(brr[1].substring(0, brr[1].length() - 1));

        int x = x1 * x2 - y1 * y2;
        int y = x1 * y2 + x2 * y1;

        return x + "+" + y + "i";
    }

    @Test
    public void test() {
        assertEquals("0+2i", complexNumberMultiply("1+1i", "1+1i"));
    }
}
