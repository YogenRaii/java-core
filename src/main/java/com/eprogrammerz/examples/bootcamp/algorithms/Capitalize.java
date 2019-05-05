package com.eprogrammerz.examples.bootcamp.algorithms;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * capitalize first letter of each word
 */
public class Capitalize {
    public String capitalizeWordFirstChar(String str) {
        boolean capitalize = true;
        for (char ch : str.toCharArray()) {
            if (ch == ' ') {
                capitalize = true;
            } else if (ch >= 'a' && ch <= 'z' && capitalize) {
                str = str.replace(ch, (char) (ch - 32));
                capitalize = false;
            }
        }
        return str;
    }

    @Test
    public void testCapitalizeWordFirstChar() {
        assertEquals("A Short Sentence!", capitalizeWordFirstChar("a short sentence!"));
        assertEquals("A Lazy Fox", capitalizeWordFirstChar("A lazy fox"));
    }
}
