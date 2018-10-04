package com.eprogrammerz.examples.algorithm.general;

import java.util.Arrays;

/**
 * @author Yogen Rai
 */
public class VeryBigSum {
    // Complete the aVeryBigSum function below.
    static long aVeryBigSum(long[] ar) {
        return Arrays.stream(ar).boxed().mapToLong(v -> v).sum();
    }

    public static void main(String[] args) {
        System.out.println(aVeryBigSum(new long[] {1000000001, 1000000002, 1000000003, 1000000004, 1000000005}));
    }
}
