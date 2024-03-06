package org.ginwithouta.leetcode.hot100;

import java.util.Arrays;

/**
 * @author Ginwithouta
 * Generate at 2024/3/4
 * LeetCode Hot 100 最长递增子序列
 */
public class LeetCode_Hot_087_LongestIncresingSubsequence {
    public int lengthOfLIS(int[] nums) {

        if (nums.length == 1) {
            return 1;
        }
        int[] dp = new int[nums.length];
        int max = 1;
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
