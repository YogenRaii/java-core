package com.eprogrammerz.examples.algorithm.interviewbit;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * Given an array of strings, return all groups of strings that are anagrams. Represent a group by a list of integers representing the index in the original list.
 * Look at the sample case for clarification.
 *
 *  Anagram : a word, phrase, or name formed by rearranging the letters of another, such as 'spar', formed from 'rasp'
 *  Note: All inputs will be in lower-case.
 * Example :
 *
 * Input : cat dog god tca
 * Output : [[1, 4], [2, 3]]
 * cat and tca are anagrams which correspond to index 1 and 4.
 * dog and god are another set of anagrams which correspond to index 2 and 3.
 * The indices are 1 based ( the first element has index 1 instead of index 0).
 */
public class Anagrams {
    public List<List<Integer>> anagrams(final List<String> strings) {
        Map<String, List<Integer>> strIndex = new HashMap<>();
        for (int idx = 0; idx < strings.size(); idx++) {
            String key = makeKey(strings.get(idx));

            if (strIndex.containsKey(key)) {
                List<Integer> anas = strIndex.get(key);
                anas.add(idx + 1);
            } else {
                List<Integer> anas = new ArrayList<>();
                anas.add(idx + 1);

                strIndex.put(key, anas);
            }
        }

        return new ArrayList<>(strIndex.values());
    }

    private String makeKey(String str) {
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }

    @Test
    public void testAnagrams() {
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(1,4));
        expected.add(Arrays.asList(2,3));

        List<String> input = Arrays.asList("cat", "dog", "god", "tca");
        assertEquals(expected, anagrams(input));
    }
}
