package com.eprogrammerz.examples.algorithm.general;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * you are given N integers. You need to find the maximum number of unique integers among all the possible contiguous subarrays of size M.
 *
 * Sample Input
 *
 * 6 3
 * 5 3 5 2 3 2
 * Sample Output
 *
 * 3
 *
 */
public class UniqueElementInSubArr {

    public int maxElementSubArr(int[] arr, int m) {
        // deque so that element can be removed from first and added at last
        Deque<Integer> deque = new ArrayDeque<>();

        // map to track elem count
        Map<Integer, Integer> map = new HashMap<>();

        int res = 0;

        for (int elem : arr) {
            deque.addLast(elem);

            if (map.containsKey(elem)) {
                map.put(elem, map.get(elem) + 1);
            } else {
                map.put(elem, 1);
            }

            // if we get to the window size, then need to adjust list and map
            if (deque.size() == m) {
                if (map.size() > res) {
                    res = map.size();
                }
                int head = deque.removeFirst();
                int newCount = map.get(head) - 1;
                if (newCount == 0) {
                    map.remove(head);
                } else {
                    map.put(head, newCount);
                }
            }
        }

        return res;
    }

    @Test
    public void testMaxElementSubArr() {
        int[] input1 = new int[] {5, 3, 5, 2, 3, 2};
        assertEquals(3, maxElementSubArr(input1, 3));

        int[] input2 = new int[] {1, 2, 3};
        assertEquals(3, maxElementSubArr(input2, 3));

        int[] input3 = new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        assertEquals(1, maxElementSubArr(input3, 3));
    }
}
