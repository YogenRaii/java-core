package com.eprogrammerz.examples.algorithm.general;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertEquals;

/**
 * return max possible value of n by inserting 5
 *
 * for example: 0 -> 50
 * 2345 -> 52345
 * -99 -> -599
 * -23 -> -235
 */
public class MaxPossibleValue {
    public int maxPossibleValue(int n) {
        if (n == 0) return 50;
        if (n < 0) return (-1) * findValue(-n, false);
        return findValue(n, true);
    }

    private int findValue(int n, boolean isMax) {
        Stack<Integer> stack = new Stack<>();
        while (n != 0) {
            stack.push(n % 10);
            n /= 10;
        }

        int num = 0;
        boolean added = false;
        while (!stack.isEmpty()) {
            int digit = stack.pop();
            if (!added) {
                if (isMax && digit <= 5) {
                    num = num * 10 + 5;
                    added = true;
                }

                if (!isMax && digit > 5) {
                    num = num * 10 + 5;
                    added = true;
                }
            }
            num = num * 10 + digit;
        }

        if (!added) num = num * 10 + 5;

        return num;
    }

    @Test
    public void test() {
        assertEquals(5268, maxPossibleValue(268));
        assertEquals(50, maxPossibleValue(0));
        assertEquals(550, maxPossibleValue(50));
        assertEquals(6750, maxPossibleValue(670));
        assertEquals(9995, maxPossibleValue(999));
        assertEquals(-5999, maxPossibleValue(-999));
    }
}
