package com.eprogrammerz.examples.algorithm.crackingCoding;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Yogen Rai
 *
 * Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?
 *
 * "amazon" -> false
 * "yogen" -> true
 */
public class UniqueCharString {
    // for only ASCII char string
    // Time: O(1) since max times loop runs is 256
    // Space: O(1) since max array size is 256
    public boolean isUnique(String str) {
        if (str.length() > 256) return  false;

        boolean[] possibleChars = new boolean[256];

        for(int i = 0; i < str.length(); i++) {
            if (possibleChars[str.charAt(i)]) return false;
            possibleChars[str.charAt(i)] = true;
        }
        return true;
    }

    @Test
    public void testIsUnique() {
        assertTrue(isUnique("yogen"));
        assertFalse(isUnique("amazon"));
    }

}
