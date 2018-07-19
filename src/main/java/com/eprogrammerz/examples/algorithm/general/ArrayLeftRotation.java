package com.eprogrammerz.examples.algorithm.general;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author Yogen Rai
 */
public class ArrayLeftRotation {
    // brute force
    // Time O(n*t)
    // in-place
    public static int[] rotateLeft(int[] elems, int n) {
        for (int time = 0; time < n; time++) {
            int first = elems[0];
            int index;
            for (index = 0; index < elems.length - 1; index++) {
                elems[index] = elems[index+1];
            }
            elems[index] = first;
        }
        return elems;
    }

    // Time O(n)
    // memory O(n)
    public static int[] rotateLeftBetter(int[] elems, int n) {
        int length = elems.length;
        int[] rotated = new int[length];
        for (int i = 0; i < length; i++) {
            rotated[(i - n + length) % length] = elems[i];
        }
        return rotated;
    }

    @Test
    public void testRotateLeft() {
        int[] elems = new int[] {1,2,3,4,5};
        int[] expected = new int[] {3,4,5,1,2};
        int[] rotated = rotateLeft(elems, 2);
        assertArrayEquals(expected, rotated);
    }

    @Test
    public void testRotateLeftBetter() {
        int[] elems = new int[] {1,2,3,4,5};
        int[] expected = new int[] {3,4,5,1,2};
        int[] rotated = rotateLeftBetter(elems, 2);
        assertArrayEquals(expected, rotated);
    }

    // 5 2
    // (5 + 0 - 2) % 5 = 3
    // (5 + 1 - 2) % 5 = 4
    // (5 + 2 - 2) % 5 = 0
    // (5 + 3 - 2) % 5 = 1
    // (5 + 4 - 2) % 5 = 2
}
