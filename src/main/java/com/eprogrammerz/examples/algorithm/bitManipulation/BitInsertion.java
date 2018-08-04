package com.eprogrammerz.examples.algorithm.bitManipulation;

/**
 * @author Yogen Rai
 *
 * Insertion: You are given two 32-bit numbers, Nand M, and two bit positions, i and j.
 * Write a method to insert Minto Nsuch that Mstarts at bit j and ends at bit i.
 * You can assume that the bits j through i have enough space to fit all of M.
 * That is, if M= 18811, you can assume that there are at least 5 bits between j and i.
 * You would not, for example, have j = 3 and i = 2, because Mcould not fully fit between bit 3 and bit 2.
 * EXAMPLE
 * Input: N
 * Output: N = 18881881188
 */
public class BitInsertion {
    /**
     * 1. Clear the bits j through i in N
     * 2. Shift Mso that it lines up with bits j through i
     * 3. Merge M and N.
     * @param n
     * @param m
     * @param i
     * @param j
     * @return
     */
    int updateBits(int n, int m, int i, int j) {
        int allOnes = ~0;
        int mask = allOnes << (j + 1) | ((1 << i) - 1);

        int nCleared = n & mask;
        int mShifted = m << i;

        return nCleared | mShifted;
    }
}
