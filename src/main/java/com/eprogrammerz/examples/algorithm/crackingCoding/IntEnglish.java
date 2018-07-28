package com.eprogrammerz.examples.algorithm.crackingCoding;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * @author Yogen Rai
 *
 * 123 -> One Hundred Twenty Three
 */
public class IntEnglish {
    private final static Map<Integer, String> UPTO_NINETY = new HashMap<>();
    private final static Map<Integer, String> HUNDREDS = new HashMap<>();

    static {
        UPTO_NINETY.put(1, "One");
        UPTO_NINETY.put(2, "Two");
        UPTO_NINETY.put(3, "Three");
        UPTO_NINETY.put(4, "Four");
        UPTO_NINETY.put(5, "Five");
        UPTO_NINETY.put(6, "Six");
        UPTO_NINETY.put(7, "Seven");
        UPTO_NINETY.put(8, "Eight");
        UPTO_NINETY.put(9, "Nine");
        UPTO_NINETY.put(10, "Ten");
        UPTO_NINETY.put(11, "Eleven");
        UPTO_NINETY.put(12, "Twelve");
        UPTO_NINETY.put(13, "Thirteen");
        UPTO_NINETY.put(14, "Fourteen");
        UPTO_NINETY.put(15, "Fifteen");
        UPTO_NINETY.put(16, "Sixteen");
        UPTO_NINETY.put(17, "Seventeen");
        UPTO_NINETY.put(18, "Eighteen");
        UPTO_NINETY.put(19, "Nineteen");
        UPTO_NINETY.put(20, "Twenty");
        UPTO_NINETY.put(30, "Thirty");
        UPTO_NINETY.put(40, "Forty");
        UPTO_NINETY.put(50, "Fifty");
        UPTO_NINETY.put(60, "Sixty");
        UPTO_NINETY.put(70, "Seventy");
        UPTO_NINETY.put(80, "Eighty");
        UPTO_NINETY.put(90, "Ninety");
        HUNDREDS.put(100, "Hundred");
        HUNDREDS.put(1000, "Thousand");
        HUNDREDS.put(100000, "Million");
    }

    public String mapIntToString(int n) {
        final List<String> strings = new LinkedList<>();

        // 123 -> 1 * 100 + 2 * 10 + 3

        for (int i = 0; n != 0; i++) {
            int digit = n % 10;
            int posVal = (int) Math.pow(10, i);
            if (posVal >= 100) {
                if (digit != 0) {
                    strings.add(0, UPTO_NINETY.get(digit));
                    strings.add(1, HUNDREDS.get(posVal));
                }
            } else {
                strings.add(0, UPTO_NINETY.get(digit * posVal));
            }
            n = n / 10;
        }
        return String.join(" ", strings);
    }

    @Test
    public void testMapIntToString() {
        assertEquals("One Hundred Twenty Four", mapIntToString(124));
        assertEquals("One Hundred Forty Four", mapIntToString(144));
        assertEquals("One Thousand One Hundred Twenty Four", mapIntToString(1124));
        assertEquals("Nine Thousand Two Hundred Twenty Four", mapIntToString(9224));
        assertEquals("Two Million One Thousand Two Hundred Twenty Four", mapIntToString(201224));
        assertEquals("Two Million One Thousand Twenty Four", mapIntToString(201024));
    }
}
