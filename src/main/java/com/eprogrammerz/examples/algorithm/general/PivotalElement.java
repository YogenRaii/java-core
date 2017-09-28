package com.eprogrammerz.examples.algorithm.general;

/**
 * Created by Yogen on 9/28/2017.
 */
public class PivotalElement {
    public static void main(String[] args) {
        int[] nums = {5,3,1,4,4};

        System.out.println(findPivotalElement(nums));

        System.out.println(findPivotalBruteforce(nums));

        //5 9
        //8 8
    }

    //this provides pivotal element with O(n)
    private static int findPivotalElement(int[] nums) {
        int sumLeft = 0;
        int sumRight = 0;

        for(int i = 1; i < nums.length; i++) {
            sumRight += nums[i];
        }

        for(int i = 1; i < nums.length; i++) {
            sumLeft += nums[i - 1];
            sumRight -= nums[i];
            if(sumLeft == sumRight) {
                System.out.println("Pivot Index: " + i + " and elem: "+nums[i]);
                return nums[i];
            }
        }
        return -1;
    }

    //this takes time of O(n^2)
    private static int findPivotalBruteforce(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            int sumLeft = 0;
            int sumRight = 0;
            for(int j = 0; j < nums.length; j++) {
                if(j < i) {
                    sumLeft += nums[j];
                } else if(j > i) {
                    sumRight += nums[j];
                }
            }

            if(sumLeft == sumRight) {
                return nums[i];
            }
        }
        return -1;
    }
}
