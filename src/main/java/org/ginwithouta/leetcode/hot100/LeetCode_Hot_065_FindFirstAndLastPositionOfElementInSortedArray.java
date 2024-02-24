package org.ginwithouta.leetcode.hot100;

/**
 * @author Ginwithouta
 * Generate at 2024/2/24
 * LeetCode Hot 100 在排序数组中查找元素的第一个和最后一个位置
 */
public class LeetCode_Hot_065_FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int left = process(nums, target, true), right = process(nums, target, false) - 1;
        if (left <= right && right < nums.length && nums[left] == target) {
            return new int[] {left, right};
        }
        return new int[] {-1, -1};
    }
    public int process(int[] nums, int target, boolean flag) {
        int left = 0, right = nums.length - 1, mid, ans = nums.length;
        while (left <= right) {
            mid = (left + right) / 2;
            // flag = true 用来找第一个是 target 的
            // flag = false 用来找第一个大于 target 的
            if (nums[mid] > target || (flag && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

}
