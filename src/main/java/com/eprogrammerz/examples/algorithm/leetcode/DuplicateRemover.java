package com.eprogrammerz.examples.algorithm.leetcode;

/**
 * Created by Yogen on 9/28/2017.
 */
public class DuplicateRemover {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1,1,2,2}));
    }
    public static int removeDuplicates(int[] nums) {
        if(nums.length == 0) {
            throw new IllegalArgumentException("Input number array must of length > 0");
        }

        int j = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }
        }
        return j+1;
    }

    public int removeElement(int[] nums, int val) {

        return 0;
    }
}
