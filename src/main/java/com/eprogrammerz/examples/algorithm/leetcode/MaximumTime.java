package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * You are given a string that represents time in the format hh:mm. Some of the digits are blank (represented by ?).
 * Fill in ? such that the time represented by this string is the maximum possible. Maximum time: 23:59, minimum time: 00:00.
 * You can assume that input string is always valid.
 *
 * Example 1:
 *
 * Input: "?4:5?"
 * Output: "14:59"
 * Example 2:
 *
 * Input: "23:5?"
 * Output: "23:59"
 * Example 3:
 *
 * Input: "2?:22"
 * Output: "23:22"
 * Example 4:
 *
 * Input: "0?:??"
 * Output: "09:59"
 * Example 5:
 *
 * Input: "??:??"
 * Output: "23:59"
 */
public class MaximumTime {
    public String maxTime(String time) {
        char[] arr = time.toCharArray();

        if (arr[0] == '?') {
            if (arr[1] == '?') {
                arr[0] = '2';
                arr[1] = '3';
            } else {
                if (arr[1] < '4') {
                    arr[0] = '2';
                } else {
                    arr[0] = '1';
                }
            }
        }

        if (arr[1] == '?') {
            if (arr[0] == '2') {
                arr[1] = '3';
            } else {
                arr[1] = '9';
            }
        }

        if (arr[3] == '?') {
            if (arr[4] == '?') {
                arr[3] = '5';
                arr[4] = '9';
            } else {
                arr[3] = '5';
            }
        }

        if (arr[4] == '?') {
            arr[4] = '9';
        }

        return new String(arr);
    }

    @Test
    public void test() {
        assertEquals("14:59", maxTime("?4:5?"));
        assertEquals("23:59", maxTime("23:5?"));
        assertEquals("23:22", maxTime("2?:22"));
        assertEquals("09:59", maxTime("0?:??"));
        assertEquals("23:59", maxTime("??:??"));
    }
}
