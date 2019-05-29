package com.eprogrammerz.examples.careercup;

import static org.junit.Assert.assertEquals;

/**
 * Solution with segmented tree
 *
 * Tree with left and right of data:
 *
 * [(i+j)/2, (i+j)/2 + 1]
 */
public class RangeSumQueryMutableOptimal {
    private int[] tree;
    private int n;

    /**
     * Pre processing
     * O(n)
     * @param nums
     */
    public RangeSumQueryMutableOptimal(int[] nums) {
        n = nums.length;
        tree = new int[n * 2];

        if (n > 0) {
            buildTree(nums);
        }
    }

    private void buildTree(int[] nums) {
        for (int i = n, j = 0; i < n * 2; i++, j++) {
            tree[i] = nums[j];
        }

        for (int i = n - 1; i > 0; i--) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }
    }

    /**
     * O(log n)
     * @param i
     * @param val
     */
    public void update(int i, int val) {
        i += n;
        tree[i] = val;

        while (i > 0) {
            int left = i;
            int right = i;

            if (i % 2 == 0) {
                right = i + 1;
            } else {
                left = i - 1;
            }

            tree[i / 2] = tree[left] + tree[right];
            i /= 2;
        }
    }

    /**
     * Query O(logn)
     * @param i
     * @param j
     * @return
     */
    public int sumRange(int i, int j) {
        i += n;
        j += n;

        int sum = 0;
        while (i <= j) {
            if (i % 2 == 1) {
                sum+=tree[i];
                i++;
            }

            if (j % 2 == 0) {
                sum+=tree[j];
                j--;
            }

            i /= 2;
            j /= 2;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5};
        RangeSumQueryMutableOptimal sumQueryMutable = new RangeSumQueryMutableOptimal(arr);

        assertEquals(9, sumQueryMutable.sumRange(0, 2));
        sumQueryMutable.update(1, 2);
        assertEquals(8, sumQueryMutable.sumRange(0, 2));
    }
}
