package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * https://leetcode.com/problems/ambiguous-coordinates/
 */
public class AmbiguousCoordinates {
    public List<String> ambiguousCoordinates(String S) {
        List<String> l = new ArrayList<>();
        String num = S.substring(1, S.length() - 1);

        for (int i = 1; i < num.length(); i++) {
            // we try to put comma at each index
            // and see if x and y are valid
            String x = num.substring(0, i);
            String y = num.substring(i);

            boolean validX = valid(x);
            boolean validY = valid(y);
            if (validX && validY) {
                l.add("(" + x + ", " + y + ")");
            }

            for (int j = 1; j < x.length(); j++) {
                String decimal = x.substring(0, j);
                String fraction = x.substring(j);
                String newX = decimal + "." + fraction;

                boolean validNewX = valid(newX);
                if (validNewX && validY) {
                    l.add("(" + newX + ", " + y + ")");
                }

                if (validNewX) {
                    for (int k = 1; k < y.length(); k++) {
                        decimal = y.substring(0, k);
                        fraction = y.substring(k);
                        String newY = decimal + "." + fraction;
                        if (valid(newY)) {
                            l.add("(" + newX + ", " + newY + ")");
                        }
                    }
                }

            }

            for (int j = 1; j < y.length(); j++) {
                String decimal = y.substring(0, j);
                String fraction = y.substring(j);
                String newY = decimal + "." + fraction;
                if (validX && valid(newY)) {
                    l.add("(" + x + ", " + newY + ")");
                }
            }
        }

        return l;
    }

    private boolean valid(String s) {
        if (s.length() == 0) return false;
        if (s.length() == 1) return true;

        if (s.charAt(0) == '0' && s.charAt(1) != '.') return false;

        int nonZero = 0;
        boolean hasPoint = false;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch > '0' && ch <= '9') {
                nonZero++;
            } else if (ch == '.') {
                nonZero = 0;
                hasPoint = true;
            }
        }

        if (hasPoint && s.charAt(s.length() -1) == '0') return false;
        return nonZero > 0;
    }

    @Test
    public void test() {
        assertThat(ambiguousCoordinates("(123)"), hasItems("(1, 23)", "(12, 3)", "(1.2, 3)", "(1, 2.3)"));
        assertThat(ambiguousCoordinates("(00011)"), hasItems("(0.001, 1)", "(0, 0.011)"));
        assertThat(ambiguousCoordinates("(0123)"), hasItems("(0, 123)", "(0, 12.3)", "(0, 1.23)", "(0.1, 23)", "(0.1, 2.3)", "(0.12, 3)"));
        assertThat(ambiguousCoordinates("(100)"), hasItems("(10, 0)"));
        assertThat(ambiguousCoordinates("(0010)"), hasItems("(0.01, 0)"));
        System.out.println(ambiguousCoordinates("(0101)"));
    }
}
