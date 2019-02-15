package com.eprogrammerz.examples.algorithm.interviewbit;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * With given an array of n+1 elements where values are from 1 to n with one value being repeated.
 *
 * Find the repeated element
 */
public class DuplicateInArray {
    public int repeatedNumber(final List<Integer> list) {
        Set<Integer> input = new HashSet<>();
        for (int n: list) {
            if(!input.add(n)) {
                return n;
            }
        }
        return -1;
    }

    @Test
    public void testRepeatedNumber() {
        assertEquals(1, repeatedNumber(Arrays.asList(1,2,3,1,4)));
        assertEquals(1, repeatedNumber(Arrays.asList(1,2,3,4,1,4)));
        assertEquals(-1, repeatedNumber(Arrays.asList(1,2,3,4)));
    }

    public int repeatedNumberArr(final List<Integer> list) {
        int[] count = new int[list.size() + 1];
        for (int idx = 0; idx < list.size(); idx++) {
            count[list.get(idx)]++;
            if(count[list.get(idx)] > 1) {
                return list.get(idx);
            }
        }
        return -1;
    }

    @Test
    public void testRepeatedNumberArr() {
        assertEquals(1, repeatedNumberArr(Arrays.asList(1,2,3,1,4)));
        assertEquals(1, repeatedNumberArr(Arrays.asList(1,2,3,4,1,4)));
        assertEquals(-1, repeatedNumberArr(Arrays.asList(1,2,3,4)));
    }
}
