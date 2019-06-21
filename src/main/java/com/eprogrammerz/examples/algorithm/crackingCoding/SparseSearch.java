package com.eprogrammerz.examples.algorithm.crackingCoding;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Given a sorted array of strings that is interspersed with empty strings, write a method to find the location of a given string.
 * For example: {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""}
 * For target: "ball"
 * Output: 4
 */
public class SparseSearch {
    public int sparseSearch(String[] arr, String target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int midIdx = start + (end - start) / 2;
            String mid = arr[midIdx];

            if (mid.isEmpty()) {
                // traverse both back and front and determine start or end
                int left = midIdx - 1;
                int right = midIdx + 1;
                while (true) {
                    if (left < start && right > end) return -1;

                    if (right <= end && !arr[right].isEmpty()) {
                        midIdx = right;
                        break;
                    }

                    if (left >= start && !arr[left].isEmpty()) {
                        midIdx = left;
                        break;
                    }

                    left--;
                    right++;
                }
            }
            mid = arr[midIdx];

            if (mid.equals(target)) return midIdx;

            if (mid.compareTo(target) > 0) {
                end = midIdx - 1;
            } else {
                start = midIdx + 1;
            }

        }
        return -1;
    }

    @Test
    public void testSparseSearch() {
        String[] arr = new String[]{"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
        assertEquals(0, sparseSearch(arr, "at"));
        assertEquals(4, sparseSearch(arr, "ball"));
        assertEquals(7, sparseSearch(arr, "car"));
        assertEquals(10, sparseSearch(arr, "dad"));
        assertEquals(-1, sparseSearch(arr, "yogen"));
    }
}
