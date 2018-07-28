package com.eprogrammerz.examples.algorithm.crackingCoding;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Yogen Rai
 * <p>
 * Given a string, write a function to check if it is a permutation of a palindrome.
 * <p>
 * Input: Tact Coa
 * Output: True (permutations:"taco cat'; "atco cta '; etc.)
 */
public class PalindromePermutation {
    /**
     * First approach: find permutations for given string and check if one of them is palindrome
     * Time O(n!)
     * <p>
     * Second approach: count each chars and make sure only none char has count greater than 0 if it has even length
     * else max one char has count 1
     * Time O(n)
     *
     * @param str
     * @return
     */
    public boolean isPalindromePermutation(String str) {
        final Map<Character, Integer> charCount = new HashMap<>();

        int singleCharCount = 0;

        for (char ch : str.toLowerCase().toCharArray()) {
            if (charCount.containsKey(ch)) {
                charCount.put(ch, charCount.get(ch) + 1);
                singleCharCount--;
            } else if (ch != ' ') { // if it is white space, ignore it
                charCount.put(ch, 1);
                singleCharCount++;
            }
        }

        return str.replaceAll(" ", "").length() % 2 == 0 ? singleCharCount == 0 : singleCharCount <= 1;
    }

    @Test
    public void testIsPalindromePermutation() {
        assertTrue(isPalindromePermutation("Tact Coa"));
        assertFalse(isPalindromePermutation("Tact doa"));
        assertFalse(isPalindromePermutation("Tactdoa")); //tacdoat
        assertFalse(isPalindromePermutation("TactdoaO")); //taocdoat
    }
}
