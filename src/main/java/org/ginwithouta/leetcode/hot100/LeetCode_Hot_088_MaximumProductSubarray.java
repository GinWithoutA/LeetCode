package org.ginwithouta.leetcode.hot100;

/**
 * @author Ginwithouta
 * Generate at 2024/3/4
 * LeetCode Hot 100 乘积最大的子数组
 */
public class LeetCode_Hot_088_MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int min = nums[0], max = nums[0], ans = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            int curMin = Math.min(nums[i], Math.min(min * nums[i], max * nums[i]));
            int curMax = Math.max(nums[i], Math.max(min * nums[i], max * nums[i]));
            min = curMin;
            max = curMax;
            ans = Math.max(ans, max);
        }
        return ans;
    }
}
