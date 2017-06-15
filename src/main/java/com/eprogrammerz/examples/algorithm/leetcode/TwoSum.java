package com.eprogrammerz.examples.algorithm.leetcode;

import java.util.*;

public class TwoSum {

	public static void main(String[] args) {
		System.out.println(Arrays.asList(twoSum(new int[]{1, 2,3,4}, 6)));
	}
	
	public static int[] twoSum(int[] nums, int target) {
        List<Integer> numList = new ArrayList<Integer>();
        for(Integer num: nums) numList.add(num);
        
        for(int i = 0; i < nums.length; i++) {
            int y = target - nums[i];
            int index = numList.indexOf(y);
            if(index >= 0 && nums[i] != y) {
                return i < index ? new int[]{i, index} : new int[]{index, i};
            }
        }
        return null;
    }

}
