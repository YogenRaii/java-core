package com.eprogrammerz.examples.algorithm.bitManipulation;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Yogen Rai
 */
public class BitTasks {
    int getBit(int num, int i) {
        // n = 9            --> 0000 1001
        // i = 5 --> 1 << 4 --> 0001 0000

        return (num & (1 << i)) != 0 ? 1 : 0;
    }

    // n = 9            --> 0000 1001
    // i = 5 --> 1 << 4 --> 0001 0000
    // |                    0001 1001
    int setBit(int num, int i) {
        return num | (1 << i);
    }

    @Test
    public void testGetBit() {
        assertEquals(0, getBit(9, 5));
        assertEquals(0, getBit(9, 4));
        assertEquals(1, getBit(9, 3));
        assertEquals(1, getBit(9, 0));
    }

    @Test
    public void testSetBit() {
        assertEquals(25, setBit(9, 4));
    }
}
