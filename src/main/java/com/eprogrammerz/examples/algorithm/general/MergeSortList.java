package com.eprogrammerz.examples.algorithm.general;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Merge sort
 */
public class MergeSortList {
    public void sort(List<Integer> l) {
        if (l == null || l.size() == 1) return;
        int mid = l.size() / 2;
        List<Integer> left = new ArrayList<>(l.subList(0, mid));
        List<Integer> right = new ArrayList<>(l.subList(mid, l.size()));

        sort(left);
        sort(right);
        merge(left, right, l);
    }

    private void merge(List<Integer> left, List<Integer> right, List<Integer> list) {
        int leftIndex = 0;
        int rightIndex = 0;
        int listIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (left.get(leftIndex) < right.get(rightIndex)) {
                list.set(listIndex++, left.get(leftIndex++));
            } else {
                list.set(listIndex++, right.get(rightIndex++));
            }
        }
        while (leftIndex < left.size()) {
            list.set(listIndex++, left.get(leftIndex++));
        }
        while (rightIndex < right.size()) {
            list.set(listIndex++, right.get(rightIndex++));
        }
    }

    @Test
    public void test1() {
        List<Integer> actual = Arrays.asList(1,4,3,2,7,5,6,8);
        sort(actual);
        assertThat(actual, is(Arrays.asList(1,2,3,4,5,6,7,8)));
    }
}
