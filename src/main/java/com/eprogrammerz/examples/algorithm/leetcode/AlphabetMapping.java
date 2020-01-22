package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/decrypt-string-from-alphabet-to-integer-mapping/
 */
public class AlphabetMapping {
    public String freqAlphabets(String s) {
        int start = 0;


        StringBuilder sb = new StringBuilder();

        while (start < s.length()) {

            int val = 0;
            int end = start;
            for (; end < s.length(); end++) {
                if (s.charAt(end) == '#' || val > 26) {
                    if (val <= 26) {
                        sb.append((char) (val - 1 + 'a'));
                        start = end + 1;
                    } else {
                        sb.append((char)(s.charAt(start) - '0' - 1 + 'a'));
                        start++;
                    }
                    break;
                }
                val = val * 10 + (s.charAt(end) - '0'); // val = 10
            }

            if (end == s.length() && s.charAt(end - 1) != '#') {
                while (start < s.length()) {
                    sb.append((char)(s.charAt(start) - '0' - 1 + 'a'));
                    start++;
                }
            }
        }

        return sb.toString();
    }

    @Test
    public void test() {
        assertEquals("jkab",freqAlphabets("10#11#12"));
        assertEquals("jkl",freqAlphabets("10#11#12#"));
        assertEquals("acz",freqAlphabets("1326#"));
        assertEquals("abcdefghijklmnopqrstuvwxyz",freqAlphabets("12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"));
    }
}
