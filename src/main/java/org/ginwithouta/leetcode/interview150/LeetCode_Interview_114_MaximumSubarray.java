package org.ginwithouta.leetcode.interview150;

/**
 * @author Ginwithouta
 * Generate at 2024/3/23
 * LeetCode 面试经典150 最大子数组和
 */
public class LeetCode_Interview_114_MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int pre = nums[0], cur = pre, ans = cur;
        for (int i = 1; i < nums.length; i++) {
            cur = Math.max(pre + nums[i], nums[i]);
            pre = cur;
            ans = Math.max(ans, cur);
        }
        return ans;
    }
}
