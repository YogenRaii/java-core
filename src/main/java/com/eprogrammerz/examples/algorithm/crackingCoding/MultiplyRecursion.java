package com.eprogrammerz.examples.algorithm.crackingCoding;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Yogen Rai
 */
public class MultiplyRecursion {
    public int multiply(int a, int b) {
        if (b == 1) return a;
        return a + multiply(a, b - 1);
    }

    @Test
    public void testMultiply() {
        assertEquals(6, multiply(2,3));
        assertEquals(60, multiply(6,10));
        assertEquals(90, multiply(30,3));
    }
}
