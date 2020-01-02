package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * https://leetcode.com/problems/brace-expansion/
 */
public class BraceExpansion {
    public String[] expand(String S) {
        if (S.length() == 0) return new String[0];
        if (S.length() == 1) return new String[] {S};
        // if start {, then
        List<String> l = new ArrayList<>();

        if (S.charAt(0) == '{') {
            int i = 1;
            while (S.charAt(i) != '}') {
                i++;
            }
            String[] parts = S.substring(1, i).split(",");
            Arrays.sort(parts); // to make words in lexicographical order

            String rem = S.substring(i + 1);

            String[] more = expand(rem);

            for (i = 0; i < parts.length; i++) {
                if (more.length > 0) {
                    for (int j = 0; j < more.length; j++) {
                        l.add(parts[i] + more[j]);
                    }
                } else {
                    l.add(parts[i]);
                }

            }
        } else {
            String[] more = expand(S.substring(1));
            for (String str: more) {
                l.add(S.charAt(0) + str);
            }

        }
        return l.toArray(new String[l.size()]);
    }

    @Test
    public void test1() {
        String[] expected = {"acdf","acef","bcdf","bcef"};
        assertThat(expand("{a,b}c{d,e}f"), is(expected));
    }

    @Test
    public void test2() {
        String[] expected = {"abcd"};
        assertThat(expand("abcd"), is(expected));
    }
}
