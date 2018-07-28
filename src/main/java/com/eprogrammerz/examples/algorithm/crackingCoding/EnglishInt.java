package com.eprogrammerz.examples.algorithm.crackingCoding;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * @author Yogen Rai
 *
 * "123" -> One Hundred Twenty Three
 *
 * [1-20][30,40,50,60,70,80,90,1000,100000]
 */
public class EnglishInt {
    private final static Map<String, Integer> UPTO_NINETY = new HashMap<>();
    private final static Map<String, Integer> HUNDREDS = new HashMap<>();

    static {
        UPTO_NINETY.put("One", 1);
        UPTO_NINETY.put("Two", 2);
        UPTO_NINETY.put("Three", 3);
        UPTO_NINETY.put("Four", 4);
        UPTO_NINETY.put("Five", 5);
        UPTO_NINETY.put("Six", 6);
        UPTO_NINETY.put("Seven", 7);
        UPTO_NINETY.put("Eight", 8);
        UPTO_NINETY.put("Nine", 9);
        UPTO_NINETY.put("Ten", 10);
        UPTO_NINETY.put("Eleven", 11);
        UPTO_NINETY.put("Twelve", 12);
        UPTO_NINETY.put("Thirteen", 13);
        UPTO_NINETY.put("Fourteen", 14);
        UPTO_NINETY.put("Fifteen", 15);
        UPTO_NINETY.put("Sixteen", 16);
        UPTO_NINETY.put("Seventeen", 17);
        UPTO_NINETY.put("Eighteen", 18);
        UPTO_NINETY.put("Nineteen", 19);
        UPTO_NINETY.put("Twenty", 20);
        UPTO_NINETY.put("Thirty", 30);
        UPTO_NINETY.put("Forty", 40);
        UPTO_NINETY.put("Fifty", 50);
        UPTO_NINETY.put("Sixty", 60);
        UPTO_NINETY.put("Seventy", 70);
        UPTO_NINETY.put("Eighty", 80);
        UPTO_NINETY.put("Ninety", 90);
        HUNDREDS.put("Hundred", 100);
        HUNDREDS.put("Thousand", 1000);
        HUNDREDS.put("Million", 100000);
    }

    public int mapEnglishToInt(String str) {
        // One hundred twenty four
        int value = 0;
        String[] words = str.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (HUNDREDS.containsKey(words[i])) {
                int val = HUNDREDS.get(words[i]);
                if (value > 100) {
                    int lastDigit = value % 10;
                    value = (value - lastDigit) + lastDigit * val;
                } else {
                    value = value * val;
                }
            } else {
                value = value + UPTO_NINETY.get(words[i]);
            }
        }

        return value;
    }

    @Test
    public void testMapEnglishToInt() {
        assertEquals(124, mapEnglishToInt("One Hundred Twenty Four"));
        assertEquals(144, mapEnglishToInt("One Hundred Forty Four"));
        assertEquals(1124, mapEnglishToInt("One Thousand One Hundred Twenty Four"));
        assertEquals(9224, mapEnglishToInt("Nine Thousand Two Hundred Twenty Four"));
        assertEquals(201224, mapEnglishToInt("Two Million One Thousand Two Hundred Twenty Four"));
        assertEquals(201024, mapEnglishToInt("Two Million One Thousand Twenty Four"));
    }
}
