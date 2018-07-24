package com.eprogrammerz.examples.algorithm.general;

import java.util.*;

/**
 * @author Yogen Rai
 *
 * Program to find all the unique substrings with length len
 */
public class SubStrings {
    public static List<String> findSubStrings(String input, int len) {
        final Set<String> result = new LinkedHashSet<>();

        for (int i = 0; i < input.length() - len + 1; i++) {
            String subStr = input.substring(i, i + len);
            if (!hasUniqueChars(subStr)) {
                result.add(subStr);
            }
        }
        return new ArrayList<>(result);
    }

    private static boolean hasUniqueChars(String str) {
        final Set<Character> chars = new HashSet<>();
        for (char ch: str.toCharArray()) {
            if (chars.contains(ch)) return true;
            chars.add(ch);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(findSubStrings("abc", 2));
        System.out.println(findSubStrings("examplestringxamp", 4));
        System.out.println(findSubStrings("examplestringxamp", 40));
    }
}
