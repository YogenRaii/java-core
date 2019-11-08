package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/implement-strstr/
 */
public class StrStr {
    public int strStr(String haystack, String needle) {
        if (haystack == null
                || needle == null || needle.length() == 0) return 0;

        // pre-processing of needle
        char[] s = new char[256];
        for (char ch : needle.toCharArray()) {
            s[ch]++;
        }

        int h = haystack.length();
        int n = needle.length();
        for (int i = 0; i + n < h; ) {
            if (s[haystack.charAt(n - 1 + i)] > 0) { // haystack matches character, so look within
                boolean matches = true;
                int iEnd = n - 1 + i;
                for (int j = n - 1; j >= 0; j--, iEnd--) {
                    if (needle.charAt(j) != haystack.charAt(iEnd)) {
                        matches = false;
                        break;
                    }
                }
                if (matches) return i;
                i++;
            } else {
                i += n;
            }
        }
        return -1;
    }

    @Test
    public void test1() {
        assertEquals(2, strStr("hello", "ll"));
    }
}
