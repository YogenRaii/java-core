package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Yogen Rai
 */
public class Divider {
    public int divide(int dividend, int divisor) {
        int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;

        long div = Math.abs((long)dividend);
        long dor = Math.abs((long)divisor);

        long quotient = dor == 1 ? div : 0;
        while (div >= dor && quotient != div) {
            div -= dor;
            quotient++;
        }
        if (sign * quotient > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return sign * (int) quotient;
    }

    @Test
    public void testDivide() {
        assertEquals(2147483647, divide(-2147483648, -1));
        assertEquals(-2147483648,divide(-2147483648, 1));
    }
}
