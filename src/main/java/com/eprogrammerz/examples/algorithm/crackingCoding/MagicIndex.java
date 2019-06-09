package com.eprogrammerz.examples.algorithm.crackingCoding;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * A magic index in an array A[ 0••• n -1] is defined to be an index such that A[ i] = i.
 * Given a sorted array of distinct integers, write a method to find a magic index, if one exists, in array A.
 */
public class MagicIndex {
    public int findMagicIndex(List<Integer> list) {
        return findMagicIndex(list, 0, list.size() - 1);
    }

    private int findMagicIndex(List<Integer> list, int start, int end) {
        if (start > end) return Integer.MIN_VALUE;

        int mid = start + (end - start) / 2;
        int elem = list.get(mid);
        if (elem == mid) return mid;

        if (elem > mid) {
            return findMagicIndex(list, start, mid - 1);
        } else {
            return findMagicIndex(list, mid + 1, end);
        }
    }

    @Test
    public void testFindMagicIndex() {
        assertEquals(2, findMagicIndex(Arrays.asList(-1, 0, 2, 4, 5, 10, 11)));
        assertEquals(1, findMagicIndex(Arrays.asList(-1, 1, 3, 4, 5, 6)));
        assertEquals(Integer.MIN_VALUE, findMagicIndex(Arrays.asList(1, 2, 7, 9, 10, 12)));
    }
}
