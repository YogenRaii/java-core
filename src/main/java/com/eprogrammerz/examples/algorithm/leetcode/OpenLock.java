package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/open-the-lock/
 */
public class OpenLock {
    public int openLock(String[] deadends, String target) {
        Set<String> s = new HashSet<>();
        Collections.addAll(s, deadends);

        Queue<String> q = new LinkedList<>();
        q.add("0000");

        Set<String> checked = new HashSet<>();

        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String str = q.poll();
                if (target.equals(str)) return step;

                if (s.contains(str) || checked.contains(str)) continue;

                checked.add(str);

                for (int j = 0; j < 4; j++) {
                    char curr = str.charAt(j);
                    char left = (char) (curr - 1);
                    if (curr - '0' - 1 == -1) {
                        // set 9
                        left = '9';
                    }
                    // rotate left

                    q.add(str.substring(0, j) + left + str.substring(j + 1));
                    // rotate right
                    char right = (char) (curr + 1);
                    if (curr - '0' + 1 == 10) {
                        right = '0';
                    }
                    q.add(str.substring(0, j) + right + str.substring(j + 1));
                }
            }

            step++;
        }
        return -1;
    }

    @Test
    public void test() {
        String[] deadends = new String[]{"0201", "0101", "0102", "1212", "2002"};
        assertEquals(6, openLock(deadends, "0202"));
    }

    @Test
    public void test1() {
        String[] deadends = new String[] {"8888"};
        assertEquals(1, openLock(deadends, "0009"));
    }
}
