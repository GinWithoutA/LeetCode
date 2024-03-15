package org.ginwithouta.leetcode.company.byteDance;

/**
 * @author Ginwithouta
 * Generate at 2024/3/15
 * LeetCode 字节跳动 搜索旋转排序数组
 */
public class LeetCode_ByteDance_0033_SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        /*
         * 由于进行了旋转，在进行二分查找的时候，肯定至少有一部分是有序的，要么是 0 到 mid，要么是 mid 到末尾
         * 首先找到有序的部分，然后判断 target 是否在这个区间内，如果不在，则跳到另一边
         */
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                if (target >= nums[0] && target <= nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target >= nums[mid] && target <= nums[nums.length - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
