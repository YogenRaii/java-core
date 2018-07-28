package com.eprogrammerz.examples.algorithm.crackingCoding;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Yogen Rai
 */
public class StringCompressor {
    public String compressString(String str) {
        // loop over each char in str
        // if it is same as earlier, add count
        // else add count to result

        String name = "yogen=rai";
        System.out.println(name.split("=")[0]);

        StringBuilder result = new StringBuilder();

        int i = 0;
        int count = 1;
        for (i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                count++;
            } else {
                result.append(str.charAt(i)).append(count);
                count = 1;
            }
        }
        result.append(str.charAt(i)).append(count);

        return result.toString().length() >= str.length() ? str : result.toString();
    }

    @Test
    public void testCompressString() {
        assertEquals("a2b1c5a3",compressString("aabcccccaaa"));
        assertEquals("abcdef",compressString("abcdef"));
    }
}
