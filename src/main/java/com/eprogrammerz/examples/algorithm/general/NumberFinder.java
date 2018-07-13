package com.eprogrammerz.examples.algorithm.general;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * return numbers within range (inclusive) if the given digit is there in number
 *
 * for example:
 * input: 3,5,23
 * output: 13 23
 */

public class NumberFinder {
    public String findNumbers(int digit, int start, int end) {
        if(start > end) {
            int temp = start;
            start = end;
            end = temp;
        }

        final List<String> result = new ArrayList<>();

        for (int i = start; i <=  end; i++) {
            if (contains(i, digit)) {
                result.add(String.valueOf(i));
            }
        }
        return String.join(" ", result);
    }

    private boolean contains(int num, int digit) {
        while (num > 0) {
            int div = num % 10;
            if (digit == div) {
                return true;
            }
            num = num / 10;
        }
        return false;
    }

    @Test
    public void testFindNumbers() {
        assertEquals("13 23", findNumbers(3,5,23));
        assertEquals("13 23", findNumbers(3,23,5));
        assertEquals("10 11 12 13 14 15 16 17 18 19 21", findNumbers(1,23,5));
        assertEquals("12 20 21 22 23", findNumbers(2,5,23));
        assertEquals("9 19", findNumbers(9, 5, 23));
        assertTrue(findNumbers(0,5,7).isEmpty());
    }
}
