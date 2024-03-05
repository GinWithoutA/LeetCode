package org.ginwithouta.leetcode.normal;

/**
 * @author Ginwithouta
 * Generate at 2023/12/19
 * Problem 寻找峰值
 */
public class Problem_0162_FindPeakElement {
    public int findPeakElement(int[] nums) {
        /*
         * 这道题可以用二分法进行求解
         * 数组中的每个数值都不一样，并且一定存在一个峰值，那么我们可以使用二分的方式
         * 每次往所找到的数值的更高的方向进行二分，一定会找到一个合适的点
         */
        if (nums.length == 1 || nums[0] > nums[1]) {
            return 0;
        }
        if (nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums.length - 1;
        }
        int left = 1, right = nums.length - 2;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            if (nums[mid + 1] >= nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
