package com.eprogrammerz.examples.bootcamp.algorithms;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;

/**
 * count vowels in given string
 */
public class VowelCounter {
    public int countVowels(String str) {
        Pattern p = Pattern.compile("[aeiou]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(str);

        int count = 0;
        while (m.find()) {
            count++;
        }
        return count;
    }

    @Test
    public void testCountVowels() {
        assertEquals(3, countVowels("Hi there!"));
        assertEquals(3, countVowels("HI THERE!"));
        assertEquals(4, countVowels("Why do you ask?"));
    }
}
