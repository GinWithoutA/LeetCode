package org.ginwithouta.leetcode.normal;

import java.awt.event.HierarchyBoundsAdapter;

/**
 * @author Ginwithouta
 * Generate at 2023/12/7
 * Problem 接雨水问题
 */
public class Problem_0042_TrappingRainWater {
    public int trap(int[] height) {
        /*
         * 这道题的思路很简单，就是判断每个位置能接多少水，因此我们所需要知道的就是两个值
         * 1. 左边最高的值
         * 2. 右边最高的值
         * 同时有两个剪枝，最左边肯定装不了水，最右边也肯定装不了水
         */
        if (height.length < 3) {
            return 0;
        }
        int[] rightMax = new int[height.length];
        int leftMax = 0, ans = 0;
        // 计算出每个位置右侧的最大值
        for (int i = rightMax.length - 2; i > 0; --i) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
        }
        // 对于每个位置，计算当前位置能放多少水，也就是左右高度的最小值减去当前高度
        for (int i = 1; i < height.length - 1; ++i) {
            leftMax = Math.max(leftMax, height[i - 1]);
            ans += Math.max(0, Math.min(leftMax, rightMax[i]) - height[i]);
        }
        return ans;
    }
}
