package org.ginwithouta.leetcode.hot100;

import java.util.Arrays;

/**
 * @author Ginwithouta
 * Generate at 2024/2/19
 */
public class LeetCode_Hot_017_FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        /*
         * O(1) 空间复杂度
         */
        Arrays.sort(nums);
        int target = 0;
        for (int i = 0; i < nums.length; ) {
            if (nums[i] <= target) {
                ++i;
            } else {
                ++target;
                if (nums[i] > target) {
                    return target;
                }
            }
        }
        return target + 1;
    }

    public int firstMissingPositiveOptimization(int[] nums) {
        /*
         * O(N) 空间复杂度
         */
        int[] count = new int[nums.length + 1];
        for (int num : nums) {
            if (num > 0 && num <= nums.length) {
                ++count[num];
            }
        }
        for (int i = 1; i < count.length; ++i) {
            if (count[i] == 0) {
                return i;
            }
        }
        return count.length;
    }
}
