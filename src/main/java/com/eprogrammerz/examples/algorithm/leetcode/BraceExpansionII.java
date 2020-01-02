package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * https://leetcode.com/problems/brace-expansion-ii/
 */
public class BraceExpansionII {
    public List<String> braceExpansionII(String expression) {
        if (expression.length() == 0) return Collections.emptyList();
        if (expression.length() == 1) return Collections.singletonList(expression);

        Set<String> l = new HashSet<>();

        if (expression.charAt(0) == '{') {
            int i = 1;
            int open = 1;
            while (i < expression.length()) {
                if (expression.charAt(i) == '{') {
                    open++;
                } else if (expression.charAt(i) == '}') {
                    open--;
                    if (open == 0) break;
                }
                i++;
            }

            String curr = expression.substring(1, i);

            List<String> parts = new ArrayList<>();

            int start = 0;
            open = 0;

            int j = 0;
            for (; j < curr.length(); j++) {
                if (curr.charAt(j) == '{') {
                    open++;
                } else if (curr.charAt(j) == '}') {
                    open--;

                } else if (curr.charAt(j) == ',' && open == 0) {
                    parts.addAll(braceExpansionII(curr.substring(start, j)));
                    start = j + 1;
                    open = 0;
                }
            }
            parts.addAll(braceExpansionII(curr.substring(start, j)));

            List<String> rem = braceExpansionII(expression.substring(i + 1));

            for (String part: parts) {
                if (rem.size() > 0) {
                    for (String sPart: rem) {
                        l.add(part + sPart);
                    }
                } else {
                    l.add(part);
                }
            }
        } else {
            String prefix = "";


            int i = 0;
            for (; i < expression.length(); i++) {
                if (expression.charAt(i) == '{') {
                    break;
                } else {
                    prefix += expression.charAt(i);
                }
            }

            List<String> parts = braceExpansionII(expression.substring(i));

            if (parts.size() > 0) {
                for (String part: parts) {
                    l.add(prefix + part);
                }
            } else {
                l.add(prefix);
            }

        }

        List<String> formed = new ArrayList<>(l);
        formed.sort(Comparator.naturalOrder());
        return formed;
    }

    @Test
    public void test() {
        List<String> expected = Arrays.asList("a","ab","ac","z");
        assertThat(braceExpansionII("{{a,z},a{b,c},{ab,z}}"), is(expected));
    }
}
