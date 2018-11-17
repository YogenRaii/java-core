package com.eprogrammerz.examples.algorithm.general;

import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author Yogen Rai
 * <p>
 * https://www.hackerrank.com/challenges/missing-numbers/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=7-day-campaign
 */
public class MissingNumbers {
    public int[] missingNumbers(int[] arr, int[] brr) {
        if (arr.length == brr.length) return new int[]{};

        // map out input to (elem, count)
        final Map<Integer, Integer> inputs = new TreeMap<>();
        for (int input : brr) {
            if (inputs.containsKey(input)) {
                inputs.put(input, inputs.get(input) + 1);
            } else {
                inputs.put(input, 1);
            }
        }

        // now compare with output array and construct result
        for (int output : arr) {
            int count = inputs.get(output);
            if (count > 1) {
                inputs.put(output, count - 1);
            } else {
                inputs.remove(output);
            }
        }

        int[] resultArr = new int[inputs.size()];
        int index = 0;
        for (int elem : inputs.keySet()) {
            resultArr[index++] = elem;
        }
        return resultArr;
    }

    @Test
    public void testMissingNumbers() {
        int[] arr1 = new int[]{7, 2, 5, 3, 5, 3};
        int[] brr1 = new int[]{7, 2, 5, 4, 6, 3, 5, 3};
        int[] missing1 = new int[]{4, 6};
        assertArrayEquals(missing1, missingNumbers(arr1, brr1));

        int[] arr2 = new int[]{203, 204, 205, 206, 207, 208, 203, 204, 205, 206};
        int[] brr2 = new int[]{203, 204, 204, 205, 206, 207, 205, 208, 203, 206, 205, 206, 204};
        int[] missing2 = new int[]{204, 205, 206};
        assertArrayEquals(missing2, missingNumbers(arr2, brr2));
    }
}
