package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import java.util.PriorityQueue;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/reorganize-string/
 */
public class ReorganizeString {
    public String reorganizeString(String S) {
        int n = S.length();

        int[] count = new int[26];

        for (char ch: S.toCharArray()) {
            count[ch - 'a']++;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> e1[1] == e2[1] ? e1[0] - e2[0] : e2[1] - e1[1]);

        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                if (count[i] > (n + 1) / 2) return "";
                pq.offer(new int[]{i, count[i]});
            }
        }

        StringBuilder sb = new StringBuilder();

        while (pq.size() >= 2) {
            int[] p = pq.poll();
            int[] q = pq.poll();

            sb.append((char) ('a' + p[0]));
            sb.append((char) ('a' + q[0]));

            if (--p[1] > 0) pq.offer(p);
            if (--q[1] > 0) pq.offer(q);
        }
        if (pq.size() > 0) sb.append((char) ('a' + pq.poll()[0]));

        return sb.toString();
    }

    @Test
    public void test() {
        assertEquals("aba", reorganizeString("aab"));
        assertEquals("", reorganizeString("aaab"));
    }
}
