package com.eprogrammerz.examples.bootcamp.algorithms;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * program to reverse integer
 */
public class ReverseInt {
    public int reverseInt(int n) {
        int reversed = 0;

        while (n != 0) {
            reversed = reversed * 10 + n % 10;
            n = n / 10;
        }
        return reversed;
    }

    @Test
    public void testReverseInt() {
        assertEquals(12, reverseInt(21));
        assertEquals(-12, reverseInt(-21));
        assertEquals(-12, reverseInt(-210));
    }
}
