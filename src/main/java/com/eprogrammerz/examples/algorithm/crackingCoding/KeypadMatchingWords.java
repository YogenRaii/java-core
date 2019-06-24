package com.eprogrammerz.examples.algorithm.crackingCoding;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class KeypadMatchingWords {
    /**
     * O(4^n)
     *
     * @param number
     * @param validWords
     * @return
     */
    public List<String> getMatchingWords(String number, Set<String> validWords) {
        List<String> matchingWords = new ArrayList<>();
        getMatchingWords(number, 0, "", matchingWords, validWords);
        return matchingWords;
    }

    private void getMatchingWords(String number, int idx, String prefix, List<String> matchingWords, Set<String> validWords) {
        if (number.length() == idx) {
            if (validWords.contains(prefix)) {
                matchingWords.add(prefix);
            }
            return;
        }

        char[] digitToChars = getChars(number.charAt(idx));
        for (char ch: digitToChars) {
            getMatchingWords(number, idx + 1, prefix + ch, matchingWords, validWords);
        }
    }

    private char[] getChars(char charAt) {
        Map<Character, char[]> digitToChars = new HashMap<>();
        digitToChars.put('1', new char[]{});
        digitToChars.put('2', new char[]{'a', 'b', 'c'});
        digitToChars.put('3', new char[]{'d', 'e', 'f'});
        digitToChars.put('4', new char[]{'g', 'h', 'i'});
        digitToChars.put('5', new char[]{'j', 'k', 'l'});
        digitToChars.put('6', new char[]{'m', 'n', 'o'});
        digitToChars.put('7', new char[]{'p', 'q', 'r', 's'});
        digitToChars.put('8', new char[]{'t', 'u', 'v'});
        digitToChars.put('9', new char[]{'w', 'x', 'y', 'z'});
        digitToChars.put('0', new char[]{});
        return digitToChars.get(charAt);
    }

    @Test
    public void testFindMatchingWords() {
        List<String> matching = Arrays.asList("tree", "used");
        Set<String> validWords = new HashSet<>();
        validWords.add("used");
        validWords.add("tree");
        validWords.add("love");
        validWords.add("mine");
        assertEquals(matching, getMatchingWords("8733", validWords));
    }

    /**
     * if we store valid words in trie, then we can terminate the extra on words that is not valid
     *
     * public List<String> getMatchingWords(String number, Trie validWords) {
     *         List<String> matchingWords = new ArrayList<>();
     *         getMatchingWords(number, 0, "", matchingWords, validWords.getRoot());
     *         return matchingWords;
     * }
     *
     * private void getMatchingWords(String number, int idx, String prefix, List<String> matchingWords, TrieNode trieNode) {
     *      // . . .
     *      for(char ch: digitToChars) {
     *           TrieNode child = trieNode.getChild(ch);
     *           if(child != null) {
     *               getMatchingWords(number, idx + 1, prefix + ch, matchingWords, child);
     *           }
     *       }
     * }
     *
     */


    /**
     * Better!
     *
     * Map words to digit "used" -> 8733 & "tree" -> 8733
     * Map digits to word 8733 -> ["used", "tree"]
     */
}
