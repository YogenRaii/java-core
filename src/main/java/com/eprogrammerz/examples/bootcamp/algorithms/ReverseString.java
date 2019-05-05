package com.eprogrammerz.examples.bootcamp.algorithms;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * program to reverse string
 */
public class ReverseString {
    public String reverseString(String input) {
        if (input == null || input.isEmpty()) return input;

        char[] chars = input.toCharArray();

        for (int start = 0, end = chars.length - 1; start < end; start++, end--) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
        }
        return new String(chars);
    }

    @Test
    public void testReverseString() {
        assertEquals("strings", reverseString("sgnirts"));
        assertEquals("string", reverseString("gnirts"));
    }
}
