package org.ginwithouta.leetcode.interview150;

/**
 * @author Ginwithouta
 * Generate at 2024/3/29
 * LeetCode 面试经典 150 接雨水
 */
public class LeetCode_Interview_016_TrappingRainWater {
    public int trap(int[] height) {
        /*
         * 每个位置能接的雨水数量就是左边最高和右边最高的较小值减去自己的高度，如果大于0就是有水，否则没水
         */
        if (height.length < 3) {
            return 0;
        }
        int[] rightMax = new int[height.length];
        for (int i = rightMax.length - 2; i >= 0; --i) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
        }
        int ans = 0, leftMax = height[0];
        for (int i = 1; i < height.length; ++i) {
            ans += Math.max(0, Math.min(leftMax, rightMax[i]) - height[i]);
            leftMax = Math.max(leftMax, height[i]);
        }
        return ans;
    }
}
