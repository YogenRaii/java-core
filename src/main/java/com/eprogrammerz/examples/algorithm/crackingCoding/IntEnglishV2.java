package com.eprogrammerz.examples.algorithm.crackingCoding;

import org.junit.Test;

import java.util.TreeMap;

import static org.junit.Assert.assertEquals;

public class IntEnglishV2 {
    private final static TreeMap<Integer, String> DEFAULTS = new TreeMap<>();

    static {
        DEFAULTS.put(1, "One");
        DEFAULTS.put(2, "Two");
        DEFAULTS.put(3, "Three");
        DEFAULTS.put(4, "Four");
        DEFAULTS.put(5, "Five");
        DEFAULTS.put(6, "Six");
        DEFAULTS.put(7, "Seven");
        DEFAULTS.put(8, "Eight");
        DEFAULTS.put(9, "Nine");
        DEFAULTS.put(10, "Ten");
        DEFAULTS.put(11, "Eleven");
        DEFAULTS.put(12, "Twelve");
        DEFAULTS.put(13, "Thirteen");
        DEFAULTS.put(14, "Fourteen");
        DEFAULTS.put(15, "Fifteen");
        DEFAULTS.put(16, "Sixteen");
        DEFAULTS.put(17, "Seventeen");
        DEFAULTS.put(18, "Eighteen");
        DEFAULTS.put(19, "Nineteen");
        DEFAULTS.put(20, "Twenty");
        DEFAULTS.put(30, "Thirty");
        DEFAULTS.put(40, "Forty");
        DEFAULTS.put(50, "Fifty");
        DEFAULTS.put(60, "Sixty");
        DEFAULTS.put(70, "Seventy");
        DEFAULTS.put(80, "Eighty");
        DEFAULTS.put(90, "Ninety");
        DEFAULTS.put(100, "Hundred");
        DEFAULTS.put(1000, "Thousand");
        DEFAULTS.put(100000, "Million");
    }

    public String translate(int val) {
        int floor = DEFAULTS.floorKey(val);
        if (floor == val) {
            return DEFAULTS.get(val);
        }
        int multiplier = val / floor;
        return (val > 100 ? DEFAULTS.get(multiplier) + " " : "") + DEFAULTS.get(floor) + " " + translate(val - floor * multiplier);
    }

    @Test
    public void testMapIntToString() {
        assertEquals("Twelve Thousand Three Hundred Forty Five", translate(12345));
        assertEquals("One Hundred Eleven", translate(111));
        assertEquals("Two Hundred Eleven", translate(211));
        assertEquals("One Hundred Twenty Four", translate(124));
        assertEquals("One Hundred Forty Four", translate(144));
        assertEquals("One Thousand One Hundred Twenty Four", translate(1124));
        assertEquals("Nine Thousand Two Hundred Twenty Four", translate(9224));
    }
}
