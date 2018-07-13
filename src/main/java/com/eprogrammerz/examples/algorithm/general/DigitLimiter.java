package com.eprogrammerz.examples.algorithm.general;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DigitLimiter {
    @Test
    public void testLimitDigits() {
        assertEquals("123", limitDigits(123232));
        assertEquals("023", limitDigits(23));
    }

    public  String limitDigits(int n) {
        while (n > 1000) {
            n = n/ 10;
        }
        return String.format("%03d", n);
    }


}
