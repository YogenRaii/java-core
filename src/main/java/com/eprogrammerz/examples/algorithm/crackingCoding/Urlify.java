package com.eprogrammerz.examples.algorithm.crackingCoding;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Yogen Rai
 *
 * Write a method to replace all spaces in a string with '%20:
 *
 * Input: Mr John Smith
 * Output: Mr%20John%20Smith
 */
public class Urlify {
    public static String urlify(String url) {
        return url.trim().replaceAll(" ", "%20");
    }

    @Test
    public void testUrlify() {
        assertEquals("Mr%20John%20Smith", urlify("Mr John Smith  "));
    }
}
