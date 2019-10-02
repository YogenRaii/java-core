package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;
import org.w3c.dom.ls.LSException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> r = new ArrayList<>();
        if (numRows == 0) return r;

        List<Integer> r1 = Collections.singletonList(1);
        r.add(r1);
        if (numRows == 1) {
            return r;
        }

        for (int rn = 2; rn <= numRows; rn++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int i = 1, s = 0; i < rn - 1; i++, s++) {
                int ith = r.get(rn - 2).get(s) + r.get(rn - 2).get(s + 1);
                row.add(ith);
            }
            row.add(1);
            r.add(row);
        }
        return r;
    }

    @Test
    public void testGenerate() {
        List<List<Integer>> actual = generate(5);
        List<List<Integer>> expected = asList(asList(1), asList(1,1), asList(1,2,1),asList(1,3,3,1), asList(1,4,6,4,1));
        assertThat(actual, is(expected));
    }
}
