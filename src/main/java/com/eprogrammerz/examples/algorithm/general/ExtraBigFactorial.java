package com.eprogrammerz.examples.algorithm.general;

import java.math.BigInteger;

/**
 * @author Yogen Rai
 */
public class ExtraBigFactorial {
    // Complete the extraLongFactorials function below.
    static void extraLongFactorials(int n) {

        BigInteger result = new BigInteger("1");

        for (int i = 1; i <= n ; i++) {
            result = result.multiply(new BigInteger(String.valueOf(i)));
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        extraLongFactorials(30);
    }
}
