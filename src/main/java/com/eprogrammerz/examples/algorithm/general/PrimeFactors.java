package com.eprogrammerz.examples.algorithm.general;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Find the prime factors of give number
 *
 * For example: 12 = 2 * 2 * 3
 *
 *
 * Solution:
 * Start with smallest prime and see if it is factor,
 * if so, add to list and update number
 * else keep on looking if next prime is factor
 *
 * 12 -> 2
 * 6 -> 2
 * 3 -> 3
 */
public class PrimeFactors {
    public List<Integer> getPrimeFactors(int num) {
        if (isPrime(num)) return Collections.singletonList(num);

        List<Integer> result = new ArrayList<>();
        while (num != 1) {
            for (int factor = 2; factor <= num; factor++) {
                if (isPrime(factor) && num % factor == 0) {
                    result.add(factor);
                    num = num / factor;
                    break;
                }
            }
        }
        return result;
    }

    private boolean isPrime(int num) {
        if (num < 2) return false;
        for (int divisor = 2; divisor <= (num/2); divisor++) {
            if (num % divisor == 0) return false;
        }
        return true;
    }

    @Test
    public void testGetPrimeFactors() {
        assertEquals(Arrays.asList(2,2,3), getPrimeFactors(12));
        assertEquals(Arrays.asList(5), getPrimeFactors(5));
        assertEquals(Arrays.asList(2,3,5), getPrimeFactors(30));
    }
}
