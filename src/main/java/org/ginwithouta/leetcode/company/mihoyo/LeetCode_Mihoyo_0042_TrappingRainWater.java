package org.ginwithouta.leetcode.company.mihoyo;

/**
 * @author Ginwithouta
 * Generate at 2024/3/16
 * LeetCode 米哈游 接雨水
 */
public class LeetCode_Mihoyo_0042_TrappingRainWater {
    public int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }
        int leftMax = height[0], ans = 0;
        int[] rightMax = new int[height.length];
        for (int i = height.length - 2; i >= 0; --i) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
        }
        for (int i = 1; i < height.length - 1; ++i) {
            ans += Math.max(0, Math.min(leftMax, rightMax[i]) - height[i]);
            leftMax = Math.max(leftMax, height[i]);
        }
        return ans;
    }
}
