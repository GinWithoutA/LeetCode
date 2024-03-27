package org.ginwithouta.leetcode.interview150;

/**
 * @author Ginwithouta
 * Generate at 2024/3/27
 * LeetCode 面试经典 150 跳跃游戏Ⅱ
 */
public class LeetCode_Interview_010_JumpGameII {
    public int jump(int[] nums) {
        /*
         * 用一个变量记录当前能到的最远距离，然后遍历的过程中不断右阔，当遍历到当前能到
         * 的最远距离的时候，就需要跳跃一次，此时将当前能到达的最远距离变为更新后的最远距离
         */
        int cur = 0, maxRight = nums[0], count = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i > cur) {
                cur = maxRight;
                ++count;
            }
            maxRight = Math.max(maxRight, i + nums[i]);
        }
        return count;
    }
}
