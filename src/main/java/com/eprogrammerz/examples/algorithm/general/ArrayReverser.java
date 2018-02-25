package com.eprogrammerz.examples.algorithm.general;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * 12345 -> 54321
 * 1234% -> 4321%
 * 1@345 -> 5@431
 *
 * a -> 97, A -> 65
 */
public class ArrayReverser {
    public char[] reverseArray(char[] chars) {
        if (chars == null) {
            throw new IllegalArgumentException("Input must be an array.");
        }

        if (chars.length == 0) return chars;

        int endIndex = chars.length - 1;

        for (int beginIndex = 0; beginIndex < endIndex; ) {
            int beginChar = chars[beginIndex];
            int endChar = chars[endIndex];

            if (beginChar < 65 || (beginChar > 90 && beginChar < 97) || beginChar > 122) {
                beginIndex++;
                continue;
            }

            if (endChar < 65 || (endChar > 90 && endChar < 97) || endChar > 122) {
                endIndex--;
                continue;
            }

            char headChar = chars[beginIndex];
            char temp = chars[endIndex];
            chars[endIndex] = headChar;
            chars[beginIndex] = temp;

            beginIndex++;
            endIndex--;
        }
        return chars;
    }

    @Test
    public void testArrayReversal() {
        assertArrayEquals("".toCharArray(), reverseArray("".toCharArray()));
        assertArrayEquals("fedcba".toCharArray(), reverseArray("abcdef".toCharArray()));
        assertArrayEquals("fec%ba".toCharArray(), reverseArray("abc%ef".toCharArray()));
        assertArrayEquals("@fedcb".toCharArray(), reverseArray("@bcdef".toCharArray()));
        assertArrayEquals("@fedcba".toCharArray(), reverseArray("@abcdef".toCharArray()));
    }
}
