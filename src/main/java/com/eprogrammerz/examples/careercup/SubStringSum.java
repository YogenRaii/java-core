package com.eprogrammerz.examples.careercup;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Yogen Rai
 *
 * Write a function that receives string with decimal number
 * (i.e. all characters are decimal digits) and prints the sum of all possible substring-numbers,
 * example: sum(“123”) = 123 + 12 + 23 + 1 + 2 + 3 = 164
 *
 * len from len(string) - 1 to 0
 *   for each len
 *      sum += substr(str)
 */
public class SubStringSum {
    public int sumSubStrings(String str) {
        int sum = 0;
        for (int len = str.length(); len > 0; len--) {
            for (int i = 0; i <= str.length() - len; i++) {
                String num = str.substring(i, i + len);
                sum += Integer.valueOf(num);
            }
        }
        return sum;
    }

    @Test
    public void testSumSubStrings() {
        assertEquals(164, sumSubStrings("123"));
    }
}
