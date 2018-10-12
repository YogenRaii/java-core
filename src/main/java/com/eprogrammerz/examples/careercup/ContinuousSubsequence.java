package com.eprogrammerz.examples.careercup;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Yogen Rai
 */
public class ContinuousSubsequence {
    public int countContinuousSubseq(int[] seq, int[] pair) {
        int count = 0; // track count
        for (int len = seq.length; len > 0; len --) { // subsequence length
            for (int i = 0; i <= (seq.length - len); i++) { // for given subseq, start from 0 and go to length of subseq
                int sum = 0;
                for (int index = i; index < (i + len); index++) { // for give subseq, find sume and see if it falls under range
                    sum += seq[index];
                }

                if (pair[0] <= sum && sum <= pair[1]) {
                    count++;
                }
            }
        }
        return count;
    }

    @Test
    public void testCountContinuousSubseq() {
        assertEquals(4, countContinuousSubseq(new int[]{1,2,3}, new int[]{3,6}));
        assertEquals(7, countContinuousSubseq(new int[]{1,2,3,4}, new int[]{3,9})); //(1,2,3),(2,3,4),(1,2),(2,3),(3,4),(3),(4)
    }
}
