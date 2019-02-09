package com.eprogrammerz.examples.algorithm.interviewbit;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class MaxNonNegativeArray {
    public int[] maxSet(int[] A) {
        long resultSum = 0;
        int resultLen = 0;
        int startIdx = 0;

        int subArrLen = 0;
        long subArrSum = 0;
        int subArrStartIdx = 0;

        for (int idx = 0; idx < A.length; idx++) {
            if (A[idx] < 0) {
                if (subArrSum > resultSum) {
                    resultSum = subArrSum;
                    resultLen = subArrLen;

                    startIdx = subArrStartIdx;
                } else if (subArrSum == resultSum && subArrLen > resultLen) {
                    resultLen = subArrLen;

                    startIdx = subArrStartIdx;
                }

                subArrLen = 0;
                subArrSum = 0;

                subArrStartIdx = idx + 1;
            } else {
                subArrLen++;
                subArrSum += A[idx];
            }
        }

        // to cover last elements
        if (subArrSum > resultSum) {
            resultLen = subArrLen;

            startIdx = subArrStartIdx;
        } else if (subArrSum == resultSum && subArrLen > resultLen) {
            resultLen = subArrLen;

            startIdx = subArrStartIdx;
        }

        int[] result = new int[resultLen];

        for (int idx = 0; idx < resultLen; idx++) {
            result[idx] = A[startIdx++];
        }

        return result;
    }

    @Test
    public void testMaxSet() {
        assertArrayEquals(new int[]{1, 2, 5}, maxSet(new int[]{1, 2, 5, -7, 2, 3}));
        assertArrayEquals(new int[]{2, 3}, maxSet(new int[]{1, 2, -3, 2, 3}));
        assertArrayEquals(new int[]{1424268980}, maxSet(new int[]{756898537, -1973594324, -2038664370, -184803526, 1424268980}));
        assertArrayEquals(new int[]{1967513926, 1540383426}, maxSet(new int[]{1967513926, 1540383426, -1303455736, -521595368}));
        assertArrayEquals(new int[]{61113, 29593, 98354}, maxSet(new int[]{69955, 37107, 40000, -45035, 61113, 29593, 98354, -25357, -13729, 76563, -60917}));
        assertArrayEquals(new int[]{76770, 29094, 87844, 40534 }, maxSet(new int[]{24831, 53057, 19790, -10679, 77006, -36098, 75319, -45223, -56760, -86126, -29506, 76770, 29094, 87844, 40534, -15394, 18738, 59590, -45159, -64947, 7217, -55539, 42385, -94885, 82420, -31968, -99915, 63534, -96011, 24152, 77295}));
    }
}
