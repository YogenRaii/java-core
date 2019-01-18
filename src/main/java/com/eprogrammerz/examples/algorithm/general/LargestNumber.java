package com.eprogrammerz.examples.algorithm.general;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

/**
 * @author Yogen Rai
 *
 * Given
 */
public class LargestNumber {
    public Optional<Integer> findLargest(int[] nums) {
        return Arrays.stream(nums).boxed().sorted(Comparator.reverseOrder()).reduce((s, n) -> s * 10 + n);
    }

    @Test
    public void testLargestNumber() {
        Optional<Integer> optionalInt = findLargest(new int[] {1,2,3,4});
        int actual = optionalInt.orElse(Integer.MIN_VALUE);
        assertEquals(4321, actual);
    }
}
