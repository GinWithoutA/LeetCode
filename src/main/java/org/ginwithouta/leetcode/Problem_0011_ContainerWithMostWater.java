package org.ginwithouta.leetcode;

/**
 * @author Ginwithouta
 * Generate at 2023/12/2
 * Problem 能容纳的水量
 */
public class Problem_0011_ContainerWithMostWater {
    public int maxArea(int[] height) {
        /*
         * 一个利用双指针的经典面试题
         * 能容纳的水量决定因素是哪一边的柱子更矮，利用双指针，一个在头，一个在尾，遍历整个数组，一定能找到最大的那个水量
         */
        int left = 0, right = height.length - 1, water = 0;
        while (left < right) {
            water = Math.max(water, Math.min(height[left], height[right]) * (right - left));
            // 以短边为基准，小的遍进行 ++，长边不是影响因素，要防止后续有更长的边能够带来更大的容量
            if (height[left] < height[right]) {
                ++left;
            } else {
                --right;
            }
        }
        return water;
    }
}
