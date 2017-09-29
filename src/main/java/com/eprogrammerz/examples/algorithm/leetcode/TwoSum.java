package com.eprogrammerz.examples.algorithm.leetcode;

import java.util.*;

public class TwoSum {

	public static void main(String[] args) {
	    int[] nums = {1, 3,3,4};
		System.out.println(Arrays.asList(twoSum(nums, 6)));

		int[] pair = twoSumMap(nums, 6);
		for(int i: pair) {
            System.out.println(i);
        }
	}
	
	public static int[] twoSum(int[] nums, int target) {
        List<Integer> numList = new ArrayList<Integer>();
        for(Integer num: nums) numList.add(num);
        
        for(int i = 0; i < nums.length; i++) {
            int y = target - nums[i];
            int index = numList.indexOf(y);
            if(index >= 0 && i != index) {
                return i < index ? new int[]{i, index} : new int[]{index, i};
            }
        }
        return null;
    }

    private static int[] twoSumMap(int[] nums, int target) {
	    //store element and its index and if two elements with same value, second will replace first
	    Map<Integer, Integer> elems = new HashMap<>();
	    for(int i = 0; i < nums.length; i++ ){
	        elems.put(nums[i], i);
        }

	    for(int i = 0; i < nums.length; i++) {
	        int pairY = target - nums[i];

	        if(elems.containsKey(pairY)) {
	            return new int[]{i,elems.get(pairY)};
            }
        }

        return null;
    }

}
