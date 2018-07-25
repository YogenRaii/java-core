package com.eprogrammerz.examples.algorithm.general;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yogen Rai
 *
 * Find permutations of characters in given string
 */
public class PermutationFinder {
    public static List<String> findPermutations(String str) {
        List<String> permutations = new ArrayList<>();
        findPermutations(str, "", permutations);
        return permutations;
    }

    public static void findPermutations(String str, String prefix, List<String> permutations) {
        if (str.length() == 0) {
            permutations.add(prefix);
        } else {
            for (int i = 0; i < str.length(); i++) {
                String rem = str.substring(0, i) + str.substring(i + 1);
                findPermutations(rem, prefix + str.charAt(i), permutations);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(findPermutations("abc"));
        System.out.println(findPermutations("abcde"));
    }
}
