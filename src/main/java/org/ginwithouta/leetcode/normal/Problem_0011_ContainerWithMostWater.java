package org.ginwithouta.leetcode.normal;

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

    /**
     * 剪枝版本
     */
    public int maxAreaPrune(int[] height) {
        /*
         * 在上面的版本中，每个元素都操作都是找到当前短的边，然后短的边加 1
         * 此时就可能遇到后面的边比当前的边还小，那么这种情况肯定不会是答案，因此我们可以提前进行一次判断，减少后续操作的次数
         */
        int left = 0, right = height.length - 1, ans = 0, curLeft, curRight;
        while (left < right) {
            ans = Math.max(ans, Math.min(height[left], height[right]) * (right - left));
            if (height[left] <= height[right]) {
                curLeft = height[left];
                while (left < right && height[left] <= curLeft) {
                    ++left;
                }
            } else {
                curRight = height[right];
                while (left < right && height[right] <= curRight) {
                    --right;
                }
            }
        }
        return ans;
    }
}
