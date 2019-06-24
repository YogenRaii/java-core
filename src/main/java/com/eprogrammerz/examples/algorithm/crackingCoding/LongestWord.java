package com.eprogrammerz.examples.algorithm.crackingCoding;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * Given a list of words, write a program to find the longest word made of other words in the list.
 */
public class LongestWord {
    String findLongestWord(String[] words) {
        Arrays.sort(words, (s1, s2) -> s2.length() - s1.length());

        Set<String> wordExists = new HashSet<>(Arrays.asList(words));

        for (String word : words) {
            if (isValid(wordExists, word, 1, false)) {
                return word;
            }
        }
        return "";
    }

    private boolean isValid(Set<String> wordExists, String word, int idx, boolean isPart) {
        if (isPart && wordExists.contains(word)) return true;
        if (word.length() <= idx) return false;

        String left = word.substring(0, idx);
        String right = word.substring(idx);

        if (wordExists.contains(left) && isValid(wordExists, right, 1, true)) {
            return true;
        } else {
            return isValid(wordExists, word, idx + 1, false);
        }
    }

    @Test
    public void testFindLongestWord() {
        String[] arr = "cat, banana, dog, nana, walk, walker, dogwalker, dogwalkercate, dogwalkercat".split(", ");
        String actual = findLongestWord(arr);
        assertEquals("dogwalkercat", actual);
    }


    /**
     * This one is better version since it is more readable
     *
     * @param words
     * @return
     */
    String longestWord(String[] words) {
        Arrays.sort(words, (w1, w2) -> w2.length() - w1.length());

        Map<String, Boolean> map = new HashMap<>();

        for (String word : words) {
            map.put(word, true);
        }

        for (String word : words) {
            if (canBuild(word, true, map)) {
                return word;
            }
        }
        return "";
    }

    private boolean canBuild(String word, boolean isOriginalWord, Map<String, Boolean> map) {
        if (!isOriginalWord && map.containsKey(word)) return map.get(word);

        for (int i = 1; i < word.length(); i++) {
            String left = word.substring(0, i);
            String right = word.substring(i);

            if (map.containsKey(left) && map.get(left) && canBuild(right, false, map)) {
                return true;
            }
        }

        map.put(word, false);

        return false;
    }

    @Test
    public void testLongestWord() {
        String[] arr = "cat, banana, dog, nana, walk, walker, dogwalker, dogwalkercate, dogwalkercat".split(", ");
        String actual = longestWord(arr);
        assertEquals("dogwalkercat", actual);
    }
}
