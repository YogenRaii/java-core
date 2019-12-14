package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/palindrome-partitioning-iii/
 */
public class PalindromePartitionIII {
    private Map<String, Integer> map = new HashMap<>();

    public int palindromePartition(String s, int k) {

        for (int start = 0; start < s.length(); start++) {
            for (int end = start; end < s.length(); end++) {
                String sub = s.substring(start, end + 1);
                if (!map.containsKey(sub)) {
                    map.put(sub, makePalindrome(sub));
                }
            }
        }

        Map<MemKey, Integer> mem = new HashMap<>();
        split(s, k, mem);

        return mem.get(new MemKey(s, k));
    }

    private int split(String s, int k, Map<MemKey, Integer> mem) {

        if (s.length() <= 1) {
            return 0;
        }

        MemKey key = new MemKey(s, k);

        if (mem.containsKey(key)) {
            return mem.get(key);
        }

        if (k == 1) {
            int count =  map.get(s);
            mem.put(key, count);
            return count;
        }

        int count = Integer.MAX_VALUE;
        for (int i = 1; i < s.length(); i++) {
            String first = s.substring(0, i);
            String second = s.substring(i);

            count = Math.min(count, map.get(first) + split(second, k - 1, mem));
        }
        mem.put(key, count);
        return count;
    }

    private int makePalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        int count = 0;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                count++;
            }
            start++;
            end--;
        }
        return count;
    }

    class MemKey {
        String str;
        int k;
        MemKey(String str, int k) {
            this.str = str;
            this.k = k;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof MemKey)) return false;
            MemKey that = (MemKey) obj;

            return this.str.equals(that.str) && this.k == that.k;
        }

        @Override
        public int hashCode() {
            int code = 17;
            code = code * 17 + this.str.hashCode();
            code = code * 17 + this.k;
            return code;
        }
    }

    @Test
    public void test1() {
        assertEquals(0, palindromePartition("aabbcc", 3));
    }

    @Test
    public void test2() {
        assertEquals(0, palindromePartition("aabbaa", 1));
    }

    @Test
    public void test3() {
        assertEquals(1, palindromePartition("abc", 2));
    }

    @Test
    public void test4() {
        assertEquals(0, palindromePartition("faaglagedtwnejzpuarkgwgoefwra", 27));
    }

    @Test
    public void test5() {
        assertEquals(6, palindromePartition("spsvmwkvwyfnrrfklevvyxsayc", 6));
    }
}
