package org.ginwithouta.leetcode.hot100;

/**
 * @author Ginwithouta
 * Generate at 2024/2/17
 * LeetCode Hot 100 接雨水
 *
 */
public class LeetCode_Hot_0042_TrappingRainWater {
    public int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }
        int ans = 0, leftMax = 0;
        int[] rightMax = new int[height.length];
        for (int i = rightMax.length - 2; i > 0; --i) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
        }
        for (int i = 1; i < height.length - 1; ++i) {
            leftMax = Math.max(leftMax, height[i - 1]);
            ans += Math.max(0, Math.min(leftMax, rightMax[i]) - height[i]);
        }
        return ans;
    }
}
