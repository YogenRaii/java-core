package com.eprogrammerz.examples.algorithm.interviewbit;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., 0 1 2 4 5 6 7  might become 4 5 6 7 0 1 2 ).
 *
 * You are given a target value to search. If found in the array, return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Input : [4 5 6 7 0 1 2] and target = 4
 * Output : 0
 */
public class RotatedSortedArraySearch {
    public int searchRecursive(final List<Integer> list, int target) {
        return binarySearch(list, target, 0, list.size() - 1);
    }

    public int binarySearch(List<Integer> input, int target, int low, int high) {
        if (low > high) return -1;

        int mid = low + (high - low) / 2;
        if (input.get(mid) == target) return mid;

        // if low-mid sorted
        if (input.get(low) <= input.get(mid)) {
            if (target >= input.get(low) && target <= input.get(mid))
                return binarySearch(input, target, low, mid - 1);
            return binarySearch(input, target, mid + 1, high);
        }

        // if not sorted

        if (target > input.get(mid) && target <= input.get(high)) {
            return binarySearch(input, target, mid + 1, high);
        }
        return binarySearch(input, target, low, mid + 1);
    }

    @Test
    public void testSearch() {
        assertEquals(0, searchRecursive(Arrays.asList(4, 5, 6, 7, 0, 1, 2), 4));
        assertEquals(5, searchRecursive(Arrays.asList(4, 5, 6, 7, 0, 1, 2), 1));
        assertEquals(6, searchRecursive(Arrays.asList(4, 5, 6, 7, 0, 1, 2), 2));
        assertEquals(6, searchRecursive(Arrays.asList(4, 5, 6, 7, 8, 9, 2), 2));
        assertEquals(2, searchRecursive(Arrays.asList(6, 7, 1, 2, 3, 4, 5), 1));
        assertEquals(43, searchRecursive(Arrays.asList(180, 181, 182, 183, 184, 187, 188, 189, 191, 192, 193, 194, 195, 196, 201, 202, 203, 204, 3, 4, 5, 6, 7, 8, 9, 10, 14, 16, 17, 18, 19, 23, 26, 27, 28, 29, 32, 33, 36, 37, 38, 39, 41, 42, 43, 45, 48, 51, 52, 53, 54, 56, 62, 63, 64, 67, 69, 72, 73, 75, 77, 78, 79, 83, 85, 87, 90, 91, 92, 93, 96, 98, 99, 101, 102, 104, 105, 106, 107, 108, 109, 111, 113, 115, 116, 118, 119, 120, 122, 123, 124, 126, 127, 129, 130, 135, 137, 138, 139, 143, 144, 145, 147, 149, 152, 155, 156, 160, 162, 163, 164, 166, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177), 42));
    }

    public int searchIterative(List<Integer> list, int target) {

        int low = 0;
        int high = list.size() - 1;
        while (low <= high) {

            // if remaining list is sorted, we can do binary search
            int mid = low + (high - low) / 2;
            int midElem = list.get(mid);

            if (midElem == target) return mid;

            if (list.get(low) <= midElem) {
                if (target >= list.get(low) && target < list.get(mid)) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            else {
                if (target > list.get(mid) && target <= list.get(high)) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }

    @Test
    public void testSearchIterative() {
        assertEquals(0, searchIterative(Arrays.asList(4, 5, 6, 7, 0, 1, 2), 4));
        assertEquals(5, searchIterative(Arrays.asList(4, 5, 6, 7, 0, 1, 2), 1));
        assertEquals(6, searchIterative(Arrays.asList(4, 5, 6, 7, 0, 1, 2), 2));
        assertEquals(6, searchIterative(Arrays.asList(4, 5, 6, 7, 8, 9, 2), 2));
        assertEquals(2, searchIterative(Arrays.asList(6, 7, 1, 2, 3, 4, 5), 1));
        assertEquals(43, searchIterative(Arrays.asList(180, 181, 182, 183, 184, 187, 188, 189, 191, 192, 193, 194, 195, 196, 201, 202, 203, 204, 3, 4, 5, 6, 7, 8, 9, 10, 14, 16, 17, 18, 19, 23, 26, 27, 28, 29, 32, 33, 36, 37, 38, 39, 41, 42, 43, 45, 48, 51, 52, 53, 54, 56, 62, 63, 64, 67, 69, 72, 73, 75, 77, 78, 79, 83, 85, 87, 90, 91, 92, 93, 96, 98, 99, 101, 102, 104, 105, 106, 107, 108, 109, 111, 113, 115, 116, 118, 119, 120, 122, 123, 124, 126, 127, 129, 130, 135, 137, 138, 139, 143, 144, 145, 147, 149, 152, 155, 156, 160, 162, 163, 164, 166, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177), 42));
    }
}
