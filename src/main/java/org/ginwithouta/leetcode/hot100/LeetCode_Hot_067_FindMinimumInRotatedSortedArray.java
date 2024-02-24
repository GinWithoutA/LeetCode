package org.ginwithouta.leetcode.hot100;

/**
 * @author Ginwithouta
 * Generate at 2024/2/24
 * LeetCode Hot 100 寻找旋转排序数组中的最小值
 */
public class LeetCode_Hot_067_FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        /*
         * 数组被分成两个有序的区间，如果 mid 小于 right，说明这个区间是有序的，那么最小值一定在小于等于 mid 的地方
         * 如果 mid > right 那么这个区间是旋转的 中间肯定有一个最小值 left = mid + 1
         */
        if (nums.length == 1) {
            return nums[0];
        }
        int left = 0, right = nums.length - 1, mid;
        if (nums[left] < nums[right]) {
            return nums[left];
        }
        while (left < right) {
            mid = (left + right) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }
}
