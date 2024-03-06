package org.ginwithouta.leetcode.hot100;

/**
 * @author Ginwithouta
 * Generate at 2024/3/4
 * LeetCode Hot 100 打家劫舍
 */
public class LeetCode_Hot_083_HouseRobber {
     public int rob(int[] nums) {
         if (nums.length == 1) {
             return nums[0];
         }
         int [] dp = new int[nums.length];
         dp[0] = nums[0];
         dp[1] = Math.max(nums[1], nums[0]);
         for (int i = 2; i < nums.length; ++i) {
             dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
         }
         return dp[nums.length - 1];
     }

    /**
     * 常数优化
     */
     public int robBetter(int[] nums) {
         int cur = 0, pre = 0, prePre = 0;
         for (int i = 0; i < nums.length; ++i) {
             cur = Math.max(pre, (i - 2 >= 0 ? prePre : 0) + nums[i]);
             prePre = pre;
             pre = cur;
         }
         return cur;
     }
}
