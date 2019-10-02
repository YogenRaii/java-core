package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AddStrings {
    /**
     * Add numbers represented by strings
     * 123 + 980 = 1103
     * @param num1
     * @param num2
     * @return
     */
    public String addStrings(String num1, String num2) {
        StringBuilder sb1 = new StringBuilder(num1).reverse();
        StringBuilder sb2 = new StringBuilder(num2).reverse();
        StringBuilder sb = new StringBuilder();

        int n1 = 0;
        int n2 = 0;
        int carry = 0;


        while (n1 < sb1.length() || n2 < sb2.length()) {
            int x = n1 < sb1.length() ? sb1.charAt(n1) - 48 : 0;
            int y = n2 < sb2.length() ? sb2.charAt(n2) - 48 : 0;

            int sum = x + y + carry;

            carry = sum / 10;
            sum = sum % 10;

            sb.append(sum);

            n1++;
            n2++;
        }

        if (carry > 0) {
            sb.append(carry);
        }

        return sb.reverse().toString();
    }

    @Test
    public void test() {
        assertEquals("1110", addStrings("123", "987"));
        assertEquals("218", addStrings("120", "98"));
        assertEquals("107", addStrings("98", "9"));
    }
}
