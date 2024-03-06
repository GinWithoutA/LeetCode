package org.ginwithouta.leetcode.hot100;

import java.util.Arrays;

/**
 * @author Ginwithouta
 * Generate at 2024/3/4
 * LeetCode Hot 100 分割等和子集
 */
public class LeetCode_Hot_089_PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        /*
         * 首先有两个基本条件，如果数组和不是偶数，那么一定是 false，如果数组中最大的数超过了数组和的一半，
         * 那么剩余的数字和一定小于数组的一半，也是false，如果最大的数字等于数组和的一半，那么可以直接返回true
         *
         */

        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        if ((sum & 1) == 1) {
            return false;
        }
        int target = sum / 2;
        if (maxNum > target) {
            return false;
        }
        if (maxNum == target) {
            return true;
        }
        return process(nums, 0, target);
    }
    public boolean process(int[] nums, int idx, int target) {
        if (target < 0 || idx == nums.length) {
            return false;
        }
        if (nums[idx] == target) {
            return true;
        }
        return process(nums, idx + 1, target)
                || process(nums, idx + 1, target - nums[idx]);
    }

    /**
     * 记忆化搜索
     */
    public boolean canPartition1(int[] nums) {
        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        if ((sum & 1) == 1) {
            return false;
        }
        int target = sum / 2;
        if (maxNum > target) {
            return false;
        }
        if (target == maxNum) {
            return true;
        }
        int[][] dp = new int[nums.length + 1][target + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return process1(nums, 0, target, dp);
    }

    public boolean process1(int[] nums, int idx, int target, int[][] dp) {
        if (target < 0) {
            return false;
        }
        if (idx == nums.length) {
            dp[idx][target] = 0;
            return false;
        }
        if (nums[idx] == target) {
            dp[idx][target] = 1;
            return true;
        }
        dp[idx][target] = (process1(nums, idx + 1, target, dp) || process1(nums, idx + 1, target - nums[idx], dp)) ? 1 : 0;
        return dp[idx][target] == 1;
    }

    /**
     * 改成dp
     */
    public boolean canPartition2(int[] nums) {
        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(num, maxNum);
        }
        if ((sum & 1) == 1) {
            return false;
        }
        int target = sum / 2;
        if (maxNum > target) {
            return false;
        }
        if (target == maxNum) {
            return true;
        }
        int[][] dp = new int[nums.length][target + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        for (int i = dp.length - 1; i >= 0; --i) {
            for (int j = 0; j <= target; ++j) {
                if (nums[i] == j) {
                    dp[i][j] = 1;
                } else {
                    int p1 = i + 1 < dp.length ? dp[i + 1][j] : 0;
                    int p2 = (i + 1 < dp.length && j - nums[i] > 0) ? dp[i + 1][j - nums[i]] : 0;
                    dp[i][j] = (p1 == 1 || p2 == 1) ? 1 : 0;
                }
            }
        }
        return dp[0][target] == 1;
    }



}
