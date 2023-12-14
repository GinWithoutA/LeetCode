package org.ginwithouta.leetcode;

/**
 * @author Ginwithouta
 * Generate at 2023/12/13
 */
public class Problem_0209_MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        /*
         * 滑动窗口经典问题，只要不断往后移动窗口就行，小于 target 就移动右窗口，大于等于 target 就移动左窗口
         */
        if (nums.length == 1) {
            return nums[0] >= target ? 1 : 0;
        }
        int len = 0, sum = nums[0], left = 0, right = 0;
        while (true) {
            if (sum >= target) {
                len = len == 0 ? right - left + 1 : Math.min(len, right - left + 1);
                sum -= nums[left++];
            } else {
                if (right == nums.length - 1) {
                    return len;
                }
                sum += nums[++right];
            }
        }
    }
}
