package com.eprogrammerz.examples.careercup;

import static org.junit.Assert.assertEquals;

public class RangeSumQueryMutable {
    private int[] sum;

    /**
     * Pre processing
     * O(n)
     * @param nums
     */
    public RangeSumQueryMutable(int[] nums) {
        sum = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = nums[i] + sum[i];
        }
    }

    /**
     * O(n)
     * @param i
     * @param val
     */
    public void update(int i, int val) {
        int diff = val - (sum[i + 1] - sum[i]);
        for (int idx = i + 1; idx < sum.length; idx++) {
            sum[idx] = sum[idx] + diff;
        }
    }

    /**
     * Query O(1)
     * @param i
     * @param j
     * @return
     */
    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5};
        RangeSumQueryMutable sumQueryMutable = new RangeSumQueryMutable(arr);

        assertEquals(9, sumQueryMutable.sumRange(0, 2));
        sumQueryMutable.update(1, 2);
        assertEquals(8, sumQueryMutable.sumRange(0, 2));
    }
}
