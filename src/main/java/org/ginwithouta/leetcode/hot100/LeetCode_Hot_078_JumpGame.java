package org.ginwithouta.leetcode.hot100;

/**
 * @author Ginwithouta
 * Generate at 2024/2/29
 * LeetCode Hot 100 跳跃游戏
 */
public class LeetCode_Hot_078_JumpGame {
    public boolean canJump(int[] nums) {
        int maxRight = nums[0];
        for (int i = 1; i < nums.length && maxRight < nums.length - 1; ++i) {
            if (i > maxRight) {
                return false;
            }
            maxRight = Math.max(maxRight, i + nums[i]);
        }
        return true;
    }
}
