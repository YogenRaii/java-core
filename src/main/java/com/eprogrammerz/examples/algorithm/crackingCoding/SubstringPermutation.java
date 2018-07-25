package com.eprogrammerz.examples.algorithm.crackingCoding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Yogen Rai
 *
 *  Given a smaller string 5 and a bigger string b, design an algorithm to find all permutautions of
 *  the shorter string within the longer one. Print the location of each permutation.
 */
public class SubstringPermutation {

    // brute force
    // find the permutations for sub -- O(n!)
    // check if each permutations are substring of str -- O(k)
    // Time Complexity -- O(n! * k)


    // better solution
    // for each of substring with length of sub, make sure if that substring is permutation of sub
    // O(m * n) where m = length of str

    public static List<Integer> findPermutation(String str, String sub) {
        final List<Integer> indices = new ArrayList<>();

        for (int i = 0; i < str.length() - sub.length() + 1; i++) {
            String subStr = str.substring(i, i + sub.length());

            //check only if starting char in subStr is one of character in sub
            if (sub.indexOf(subStr.charAt(0)) >= 0 && isPermutation(subStr, sub)) {
                indices.add(i);
            }
        }
        return indices;
    }

    public static boolean isPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        final Map<Character, Long> charCount = s1.chars().mapToObj(ch -> (char)ch).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        for (char ch: s2.toCharArray()) {
            if (!charCount.containsKey(ch)) {
                return false;
            } else {
                long currentCount = charCount.get(ch) - 1;

                if (currentCount == 0) {
                    charCount.remove(ch);
                } else {
                    charCount.put(ch, charCount.get(ch) - 1);
                }
            }
        }
        return charCount.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(findPermutation("cbabadcbbabbcbabaabccbabc", "abbc")); // [0, 6, 9, 11, 12, 20, 21]
    }

}
