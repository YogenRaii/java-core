package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).
 * <p>
 * Each LED represents a zero or one, with the least significant bit on the right.
 * <p>
 * <p>
 * For example, the above binary watch reads "3:25".
 * <p>
 * Given a non-negative integer n which represents the number of LEDs that are currently on, return all possible times the watch could represent.
 * <p>
 * Example:
 * <p>
 * Input: n = 1
 * Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
 * <p>
 * https://leetcode.com/problems/binary-watch/
 */
public class BinaryWatch {
    private int[] vals = new int[]{1, 2, 4, 8, 1, 2, 4, 8, 16, 32};

    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        backTrack(num, res, 0, 0, 0);
        return res;
    }

    private void backTrack(int n, List<String> res, int hour, int min, int start) {
        if (n == 0) {
            res.add(hour + ":" + (min < 10 ? "0" + min : min));
        } else {
            for (int i = start; i < vals.length; i++) {
                if (hour > 11 || min > 59) continue;
                if (i <= 3)
                    backTrack(n - 1, res, hour + vals[i], min, i + 1);
                else
                    backTrack(n - 1, res, hour, min + vals[i], i + 1);
            }
        }
    }


    @Test
    public void test() {
        List<String> actual = readBinaryWatch(1);
        List<String> expected = Arrays.asList("1:00, 2:00, 4:00, 8:00, 0:01, 0:02, 0:04, 0:08, 0:16, 0:32".split(", "));
        assertThat(actual, is(expected));
    }
}
