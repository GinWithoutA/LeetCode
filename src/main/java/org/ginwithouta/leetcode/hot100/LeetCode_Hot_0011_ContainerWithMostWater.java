package org.ginwithouta.leetcode.hot100;

/**
 * @author Ginwithouta
 * Generate at 2024/2/17
 * LeetCode Hot 100 盛水最多的容器
 */
public class LeetCode_Hot_0011_ContainerWithMostWater {
    public int maxArea(int[] height) {
        /*
         * 若后续的值比当前的值小，是没有必要操作的，直接加速剪枝
         */
        if (height.length == 2) {
            return Math.min(height[0], height[1]);
        }
        int left = 0, right = height.length - 1, ans = 0;
        while (left < right) {
            ans = Math.max(ans, Math.min(height[left], height[right]) * (right - left));
            int leftNum = height[left], rightNum = height[right];
            if (leftNum <= rightNum) {
                while (left < right && height[left] <= leftNum) {
                    ++left;
                }
            } else {
                while (left < right && height[right] <= rightNum) {
                    --right;
                }
            }
        }
        return ans;
    }
}
