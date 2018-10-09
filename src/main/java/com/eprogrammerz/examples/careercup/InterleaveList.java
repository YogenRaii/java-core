package com.eprogrammerz.examples.careercup;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Yogen Rai
 *
 * Interleave list of lists in Java
Example:
input = [[1,2,3], [9, 0], [5], [-4,-5,-2,-3,-1]];
output = [1,9,5,-4,2,0,-5,3,-2,-3,-1]

 */
public class InterleaveList {
    public List<Integer> interleaveElements(List<List<Integer>> list) {
        List<Integer> result = new ArrayList<>();

        // find max length of string
        int maxLen = 0;
        for (List<Integer> l: list) {
            if (l.size() > maxLen) {
                maxLen = l.size();
            }
        }

        for (int i = 0; i < maxLen; i++) {   // O(n * l)
            // look into each list
            for (List<Integer> l: list) {    // O(l)
                // if it has element in that particular iteration, add to result
                if (i < l.size()) {
                    result.add(l.get(i));
                }
            }
        }
        return result;
    }

    @Test
    public void testInterleaveElements() {
        List<Integer> l1 = Arrays.asList(1,2,3);
        List<Integer> l2 = Arrays.asList(9,0);
        List<Integer> l3 = Arrays.asList(5);
        List<Integer> l4 = Arrays.asList(-4,-5,-2,-3,-1);
        List<List<Integer>> l = Arrays.asList(l1, l2, l3, l4);

        List<Integer> result = interleaveElements(l);

        List<Integer> expected = Arrays.asList(1, 9, 5, -4, 2, 0, -5, 3, -2, -3, -1);

        assertEquals(expected, result);
    }
}
