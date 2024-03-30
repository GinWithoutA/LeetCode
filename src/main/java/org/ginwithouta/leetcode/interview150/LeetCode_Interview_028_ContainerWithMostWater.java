package org.ginwithouta.leetcode.interview150;

/**
 * @author Ginwithouta
 * Generate at 2024/3/30
 * LeetCode 面试经典 150 盛水最多的容器
 */
public class LeetCode_Interview_028_ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, ans = 0, cur;
        while (left < right) {
            ans = Math.max(ans, Math.min(height[left], height[right]) * (right - left));
            if (height[left] <= height[right]) {
                cur = left;
                while (left < right && height[left] <= height[cur]) {
                    ++left;
                }
            } else {
                cur = right;
                while (left < right && height[cur] >= height[right]) {
                    --right;
                }
            }
        }
        return ans;
    }
}
