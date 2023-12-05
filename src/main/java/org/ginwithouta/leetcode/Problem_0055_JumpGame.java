package org.ginwithouta.leetcode;

/**
 * @author Ginwithouta
 * Generate at 2023/12/5
 * Problem 跳跃问题
 */
public class Problem_0055_JumpGame {
    public boolean canJump(int[] nums) {
        /*
         * 抓住一个重点，定义一个变量 maxRight 看最远能跳到的位置，每个位置都需要判断
         * 是否能够提升当前 maxRight 的值
         *
         * 要注意，maxRight 不是叠加，而是看当前位置加上跳跃距离是否能推高 maxRight
         */
        int maxRight = nums[0];
        for (int i = 0; i < nums.length; ++i) {
            if (i > maxRight) {
                return false;
            }
            maxRight = Math.max(maxRight, i + nums[i]);
            if (maxRight >= nums.length - 1) {
                return true;
            }
        }
        return true;
    }
}
