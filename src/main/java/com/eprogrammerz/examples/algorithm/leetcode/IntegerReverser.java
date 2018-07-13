package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IntegerReverser {

	public static int reverse(int x) {
		
		long result = 0;
		while(x != 0) {
			result = result * 10 + x % 10;
			x /= 10;
		}
		
		return result > Integer.MAX_VALUE || result < Integer.MIN_VALUE? 0 : (int) result;  
	}

	@Test
	public void testReverse() {
		assertEquals(42321, reverse(12324));
		assertEquals(-42321, reverse(-12324));
		assertEquals(0, reverse(Integer.MAX_VALUE));
	}
}
