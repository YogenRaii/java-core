package com.eprogrammerz.examples.careercup;

import org.junit.Test;

import java.util.TreeMap;

import static org.junit.Assert.assertEquals;

/**
 * @author Yogen Rai
 *
 * if x > 1000; div = x / 1000; addSymbol ("M", div times)
 * repeat if (x - div) != 0
 */
public class IntegerToRoman {
    private static TreeMap<Integer, String> integerToRoman = new TreeMap<>();

    static {
        integerToRoman.put(1, "I");
        integerToRoman.put(4, "IV");
        integerToRoman.put(5, "V");
        integerToRoman.put(9, "IX");
        integerToRoman.put(10, "X");
        integerToRoman.put(40, "XL");
        integerToRoman.put(50, "L");
        integerToRoman.put(90, "XC");
        integerToRoman.put(100, "C");
        integerToRoman.put(400, "CD");
        integerToRoman.put(500, "D");
        integerToRoman.put(900, "CM");
        integerToRoman.put(1000, "M");
    }

    public String integerToRoman(int num) {
        int largest = integerToRoman.floorKey(num);

        if (num == largest) {
            return integerToRoman.get(largest);
        }

        return integerToRoman.get(largest) + integerToRoman(num - largest);
    }

    public String integerToRomanIterative(int num) {
        StringBuilder sb = new StringBuilder();

        while (num != 0) {
            int largest = integerToRoman.floorKey(num);
            sb.append(integerToRoman.get(largest));
            num -= largest;
        }

        return sb.toString();
    }

    @Test
    public void testIntegerToRoman() {
        assertEquals("III", integerToRoman(3));
        assertEquals("IV", integerToRoman(4));
        assertEquals("V", integerToRoman(5));
        assertEquals("VI", integerToRoman(6));
        assertEquals("IX", integerToRoman(9));
        assertEquals("XI", integerToRoman(11));
        assertEquals("XIV", integerToRoman(14));
        assertEquals("XV", integerToRoman(15));
        assertEquals("XXIV", integerToRoman(24));
        assertEquals("XXVIII", integerToRoman(28));
        assertEquals("XCVII", integerToRoman(97));
        assertEquals("MM", integerToRoman(2000));
        assertEquals("MMI", integerToRoman(2001));
    }

    @Test
    public void testIntegerToRomanIterative() {
        assertEquals("III", integerToRomanIterative(3));
        assertEquals("IV", integerToRomanIterative(4));
        assertEquals("V", integerToRomanIterative(5));
        assertEquals("VI", integerToRomanIterative(6));
        assertEquals("IX", integerToRomanIterative(9));
        assertEquals("XI", integerToRomanIterative(11));
        assertEquals("XIV", integerToRomanIterative(14));
        assertEquals("XV", integerToRomanIterative(15));
        assertEquals("XXIV", integerToRomanIterative(24));
        assertEquals("XXVIII", integerToRomanIterative(28));
        assertEquals("XCVII", integerToRomanIterative(97));
        assertEquals("MM", integerToRomanIterative(2000));
        assertEquals("MMI", integerToRomanIterative(2001));
    }
}
