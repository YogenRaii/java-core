package com.eprogrammerz.examples.algorithm.general;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertArrayEquals;

public class ArrayDuplicateRemover {
    public int[] removeDuplicates(int[] inputs) {
        Set<Integer> inputMap = new LinkedHashSet<>();

        for (int i = 0; i < inputs.length; i++) {
            inputMap.add(inputs[i]);
        }

        int[] arrayWODuplicate = new int[inputMap.size()];
        for (int i = 0, j = 0; i < inputMap.size(); i++) {
            arrayWODuplicate[j++] = inputs[i];
        }
        return arrayWODuplicate;
    }

    @Test
    public void testRemoveDuplicates() {
        int[] arr1 = {1, 2, 3, 4, 4, 3, 2, 1};
        assertArrayEquals(new int[]{1, 2, 3, 4}, removeDuplicates(arr1));
    }
}
