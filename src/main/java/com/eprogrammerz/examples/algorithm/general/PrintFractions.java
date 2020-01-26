package com.eprogrammerz.examples.algorithm.general;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

/**
 * Print all the fractions from 0 to 1 with N being the highest denominator. The fractions must be printed in order.
 * If duplicate fraction values are found, then print the fraction in the lowest form. For example, If you have 1/2 and 5/10, then only 1/2 would printed.
 *
 * Example
 *
 * Input: n = 4
 * Output: ["0/1", "1/4", "1/3", "1/2", "2/3", "3/4", "1/1"]
 */
public class PrintFractions {
    /**
     * Time O(n^2)
     * Space O(1)
     *
     * @param n
     * @return
     */
    public List<String> fractions(int n) {
        List<String> l = new ArrayList<>();

        if (n == 0) return l;

        List<int[]> pairs = new ArrayList<>();

        for (int den = 1; den <= n; den++) {
            for (int num = 1; num <= den; num++) {
                if (gcd(den, num) == 1) {
                    pairs.add(new int[] {num, den});
                }
            }
        }

        // O(k * logk)
        pairs.sort((p1, p2) -> p1[0] * p2[1] - p1[1] * p2[0]);

        l.add("0/1");
        for (int[] pair: pairs) {
            l.add(String.format("%d/%d", pair[0], pair[1]));
        }
        return l;
    }

    private int gcd(int a, int b) {
//        if (b == 0) return a;
//        return gcd(b, a % b);
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    @Test
    public void test() {
        assertEquals(asList("0/1", "1/4", "1/3", "1/2", "2/3", "3/4", "1/1"), fractions(4));
    }
}
