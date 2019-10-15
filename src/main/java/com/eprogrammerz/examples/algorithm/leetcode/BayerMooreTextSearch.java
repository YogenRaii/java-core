package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Given string text t of length m and pattern p of length n, find all the indices
 * of the starting of p in t
 *
 * example:
 * Text: abcabcdefabc
 * P: abc
 *
 * output: [0,3,9]
 */
public class BayerMooreTextSearch {
    public List<Integer> searchPatterns(String t, String p) {
        List<Integer> l = new ArrayList<>();

        if (t.length() < p.length()) return l;

        Set<Character> set = new HashSet<>();
        for (char ch: p.toCharArray()) {
            set.add(ch);
        }

        int end = p.length() - 1;

        while (end < t.length()) {
            if (t.charAt(end) == p.charAt(p.length() - 1)) {
                // do back search
                boolean found = true;
                int tIdx = 0;
                for (int i = p.length() - 1; i >= 0; i--) {
                    if (t.charAt(end - tIdx++) != p.charAt(i)) {
                        found = false;
                        break;
                    }
                }
                if (found) {
                    l.add(end - p.length() + 1);
                }
                end++;
            } else {
                // if t.charAt(end) is one of char in p, then end++
                // else jump by p.length()
                if (set.contains(t.charAt(end))) {
                    end++;
                } else {
                    end += p.length();
                }
            }
        }
        return l;
    }

    @Test
    public void test1() {
        List<Integer> expected = Arrays.asList(0, 3, 9);
        List<Integer> actual = searchPatterns("abcabcdefabc", "abc");
        assertThat(actual, is(expected));
    }

    @Test
    public void test2() {
        List<Integer> expected = Arrays.asList(0, 2, 4, 6, 8);
        List<Integer> actual = searchPatterns("abababababa", "aba");
        assertThat(actual, is(expected));
    }
}
