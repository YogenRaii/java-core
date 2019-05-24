package com.eprogrammerz.examples.careercup;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://www.hackerrank.com/challenges/crush/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
 *
 */
public class ArrayManipulation {
    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
        long[] arr = new long[n + 1];
        long max = Long.MIN_VALUE;

        for (int[] query: queries) {
            int start = query[0] - 1;
            int end = query[1];
            int val = query[2];

            arr[start] = arr[start] + val;
            arr[end] = arr[end] - val;
        }

        long sum = 0;

        for (long num : arr) {
            sum += num;

            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }

    @Test
    public void testArrayManipulation() {
        int[][] queries = new int[3][3];
        queries[0][0] = 1;
        queries[0][1] = 2;
        queries[0][2] = 100;

        queries[1][0] = 2;
        queries[1][1] = 5;
        queries[1][2] = 100;

        queries[2][0] = 3;
        queries[2][1] = 4;
        queries[2][2] = 100;

        assertEquals(200, arrayManipulation(5, queries));


        queries = new int[3][3];
        queries[0][0] = 1;
        queries[0][1] = 5;
        queries[0][2] = 3;

        queries[1][0] = 4;
        queries[1][1] = 8;
        queries[1][2] = 7;

        queries[2][0] = 6;
        queries[2][1] = 9;
        queries[2][2] = 1;

        assertEquals(10, arrayManipulation(10, queries));
    }
}
