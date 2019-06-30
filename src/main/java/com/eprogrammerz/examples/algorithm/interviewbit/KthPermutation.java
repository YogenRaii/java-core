package com.eprogrammerz.examples.algorithm.interviewbit;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Given n, 1.. n and k, find permutation of n numbers at kth position
 */
public class KthPermutation {
    public String getPermutation(int n, int k) {
        List<Integer> num = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            num.add(i);
        }
        List<List<Integer>> per = new ArrayList<>();
        permutate(num, k, per, new ArrayList<>());
        List<Integer> p = per.get(per.size() - 1);
        StringBuilder res = new StringBuilder();
        for (int i : p) {
            res.append(i);
        }
        return res.toString();
    }

    private void permutate(List<Integer> num, int k, List<List<Integer>> per,
                           List<Integer> temp) {
        if (per.size() == k) return;

        if (num.size() == 0) {
            per.add(new ArrayList<>(temp));
        } else {
            for (int i = 0; i < num.size(); i++) {
                List<Integer> r1 = num.subList(0, i);
                List<Integer> r2 = num.subList(i + 1, num.size());

                List<Integer> r = new ArrayList<>();
                r.addAll(r1);
                r.addAll(r2);

                temp.add(num.get(i));
                permutate(r, k, per, temp);
                temp.remove(num.get(i));
            }
        }
    }

    @Test
    public void testKthPermutation() {
        String kth = getPermutation(3, 4);
        assertEquals("231", kth);
    }

    public String getKthPermutation(int n, int k) {
        List<Integer> num = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            num.add(i);
        }

        return getKthPermutation(num, k - 1);
    }

    private String getKthPermutation(List<Integer> num, int k) {
        int size = num.size();
        if (size == 0) return "";

        if (k > fact(size)) return "";

        int f = fact(size - 1);

        int pos = k / f;

        k = k % f;

        return String.valueOf(num.remove(pos)) + getKthPermutation(num, k);
    }

    private int fact(int n) {
        if (n == 0 || n == 1) return 1;
        return n * fact(n - 1);
    }

    @Test
    public void testKthPermutationBetter() {
        String kth = getKthPermutation(3, 4);
        assertEquals("231", kth);
    }
}
