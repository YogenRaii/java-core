package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * 570. Find the Missing Number II

 * Giving a string with number from 1-n in random order, but miss 1 number.Find that number.
 *
 * Example
 * Example1
 *
 * Input: n = 20 and str = 19201234567891011121314151618
 * Output: 17
 * Explanation:
 * 19'20'1'2'3'4'5'6'7'8'9'10'11'12'13'14'15'16'18
 * Example2
 *
 * Input: n = 6 and str = 56412
 * Output: 3
 * Explanation:
 * 5'6'4'1'2
 * Notice
 * n <= 30
 * Data guarantees have only one solution
 *
 *
 * https://www.lintcode.com/problem/find-the-missing-number-ii/description
 */
public class MissingNumber2 {
    public int findMissing2(int n, String str) {
        // 1 920123 1 9 20123 1 9 2
        // 19 20123
        // write your code here
        List<Integer> l = new ArrayList<>();
        dfs(n, str, l, 0, new ArrayList<>());

        int res = n;
        for (int i = 0; i < l.size(); i++) {
            res ^= (i + 1) ^ l.get(i);
        }
        return res;
    }

    private void dfs(int n, String str, List<Integer> l, int start, List<Integer> temp) {
        if (str.length() == start) {
            if (temp.size() == n - 1) {
                l.clear();
                l.addAll(temp);
            }

            return;
        }
        int val = 0;
        for (int i = start; i < str.length(); i++) {
            val = val * 10 + (str.charAt(i) - '0');
            if (temp.contains(val)) continue;

            if (val > 0 && val <= n) {
                temp.add(val);
                dfs(n, str, l, i + 1, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }

    @Test
    public void test() {
        assertEquals(17, findMissing2(20, "19201234567891011121314151618"));
        assertEquals(3, findMissing2(6, "56412"));
    }
}
