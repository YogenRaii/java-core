package com.eprogrammerz.examples.algorithm.crackingCoding;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * Given a string band an array of smaller strings T, design a method to search b for each small string in T.
 * return oneAway;
 * <p>
 * Let's start with an example:
 * T = {"is", "ppi", "hi", "sis", "i", "ssippi"}
 * b = "mississippi"
 */
public class MultiSearch {
    /**
     * O(n * k * t)
     * where n = number of elements in array
     * k = size of big string
     * t = size of small string
     *
     * @param smalls
     * @param big
     * @return
     */
    Map<String, List<Integer>> searchAll(String[] smalls, String big) {
        // go over each of small
        // find locations for them in big
        // add to result map
        Map<String, List<Integer>> map = new HashMap<>();

        for (String small : smalls) { // O(n * k * t)
            List<Integer> locations = lookupString(big, small);
            map.put(small, locations);
        }
        return map;
    }

    private List<Integer> lookupString(String big, String small) {
        List<Integer> locations = new ArrayList<>();
        for (int i = 0; i < (big.length() - small.length() + 1); i++) { // O(k * t)
            if (big.charAt(i) == small.charAt(0) && matches(big, i, small)) {
                // there is possibility, to look for all string and if it matches, then add i to locations
                locations.add(i);
            }
        }
        return locations;
    }

    private boolean matches(String big, int start, String small) {
        for (int i = 0; i < small.length(); i++) { // O(t)
            if (small.charAt(i) != big.charAt(start++)) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testSearchAll() {
        String[] arr = new String[]{"is", "ppi", "hi", "sis", "i", "ssippi"};
        Map<String, List<Integer>> locations = searchAll(arr, "mississippi"); // {hi=[], ssippi=[5], ppi=[8], i=[1, 4, 7, 10], is=[1, 4], sis=[3]}
        assertEquals(Arrays.asList(1, 4, 7, 10), locations.get("i"));
        assertEquals(Arrays.asList(8), locations.get("ppi"));
    }
}
