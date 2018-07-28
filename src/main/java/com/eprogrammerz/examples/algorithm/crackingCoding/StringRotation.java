package com.eprogrammerz.examples.algorithm.crackingCoding;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author Yogen Rai
 *
 * String Rotation: Assume you have a method isSubstring() which checks if one word is a substring of another.
 * Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one call to isSubstring
 * (e.g., waterbottle is a rotation of erbottlewat).
 */
public class StringRotation {
    /**
     * xy -> s1
     * yx -> s2
     * xyxy -> yx is substring
     * @param s1
     * @param s2
     * @return
     */
    public boolean isRotationString(String s1, String s2) {
        int s1Len = s1.length();

        if (s1Len == s2.length() && s1Len != 0) {
            String s1s2 = s1 + s2;
            return isSubstring(s1s2, s2);
        }
        return false;
    }

    public boolean isSubstring(String s1, String s2) {
        return s1.contains(s2);
    }

    @Test
    public void testIsRotationString() {
        assertTrue(isRotationString("waterbottle", "erbottlewat"));
    }
}
