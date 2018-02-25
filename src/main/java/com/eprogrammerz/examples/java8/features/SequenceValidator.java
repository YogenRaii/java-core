package com.eprogrammerz.examples.java8.features;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Yogen on 1/10/2018.
 *
 * In given string, if the input chars are in order in which they are in input string, then
 * return true, else false.
 * There may be case where you need to skip the sequence even though they are order.
 */
public class SequenceValidator {
    public boolean validateSequence(String str, char[] chars) {
        int lastIndex = -1;
        for (char ch: chars) {
            int index = str.indexOf(ch);

            if (index < lastIndex) {
                return false;
            }
            lastIndex = index;
        }
        return true;
    }

    @Test
    public void testValidateSequenceMethod() {
        assertTrue(validateSequence("abcd", new char[]{'a','b','c'}));
        assertTrue(validateSequence("abcd", new char[]{'a','c'}));
        assertTrue(validateSequence("abcd", new char[]{'c'}));
        assertTrue(validateSequence("abcd", new char[]{'a', 'd'}));
        assertFalse(validateSequence("abcd", new char[]{'b','a'}));
        assertFalse(validateSequence("abcd", new char[]{'c','a'}));
    }
}
