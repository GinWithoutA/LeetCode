package org.ginwithouta.leetcode.interview150;

/**
 * @author Ginwithouta
 * Generate at 2024/3/27
 * LeetCode 面试经典 150 跳跃游戏
 */
public class LeetCode_Interview_009_JumpGame {
    public boolean canJump(int[] nums) {
        int maxRight = nums[0];
        for (int i = 1; i < nums.length && maxRight < nums.length; ++i) {
            if (i > maxRight) {
                return false;
            }
            maxRight = Math.max(maxRight, i + nums[i]);
        }
        return true;
    }
}
