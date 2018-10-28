package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Yogen Rai
 *
 * Encode string with following rules:
 * 1. Letters have value ignoring case A=a=0,B=b=1... Z=z=25
 * 2. Numbers have value 9 minus themsleves 0=9,1=8,,, 9=0
 * 3. First letter and number should be the same
 * 4. Later letters should be encoded by adding a value of previously changed letter. If letter shifts past 'Z' or 'z', it restarts at 'A' or 'a'
 * 5. Later numbers should be encoded by by adding value of previously changed number. If number shifts past '9', it restarts at 0
 * 6. Other characters should remain same
 */
public class Ciphertext {
    public String encodeString(String str) {
        // if first char or num, let it be same
        boolean firstChar = true;
        boolean firstNum = true;
        // track last num and char position
        int lastNumPos = 0;
        int lastCharPos = 0;

        StringBuilder result = new StringBuilder();

        for (char ch: str.toCharArray()) {

            // ascii value
            int asciiVal = (int) ch;
            // if number
            if (48 <= asciiVal && asciiVal <= 57) {
                if (firstNum) {
                    firstNum = false;
                    lastNumPos = 9 - (ch - 48);
                    result.append(ch);
                } else {
                    int newVal = ((asciiVal - 47) + lastNumPos) % 10;
                    lastCharPos = 9 - newVal;
                    result.append(newVal);
                }
            }
            // if char A-Z
            else if (65 <= asciiVal && asciiVal <= 90) {
                if (firstChar) {
                    firstChar = false;
                    lastCharPos = (ch - 65);
                    result.append(ch);
                } else {
                    int newVal = (asciiVal + lastCharPos);
                    if (newVal > 90) {
                        newVal = (newVal % 90) + 64;
                    }
                    lastCharPos = newVal - 65;
                    result.append((char) newVal);
                }
            }
            // if char a-z
            else if (97 <= asciiVal && asciiVal <= 122) {
                if(firstChar) {
                    firstChar = false;
                    lastCharPos = ch - 97;
                    result.append(ch);
                } else {
                    int newVal = (asciiVal + lastCharPos);
                    if (newVal > 122) {
                        newVal = (newVal % 122) + 96;
                    }
                    lastCharPos = newVal - 97;
                    result.append((char) newVal);
                }
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    @Test
    public void testEncodeString() {
        assertEquals("ePb", encodeString("eLm"));
        assertEquals("x1 = v0", encodeString("x1 = y1"));
        assertEquals("Hlwhv Rfwhk!", encodeString("Hello World!"));
    }
}
