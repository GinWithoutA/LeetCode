package org.ginwithouta.leetcode.company.byteDance;

/**
 * @author Ginwithouta
 * Generate at 2024/3/15
 * LeetCode 字节跳动 数组中的第K个最大元素
 */
public class LeetCode_ByteDance_0215_KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        int left = 0, right = nums.length - 1, target = nums.length - k;
        while (left < right) {
            int pivot = nums[left + (int) (Math.random() * (right - left + 1))];
            int[] range = partition(nums, left, right, pivot);
            if (target >= range[0] && target <= range[1]) {
                return nums[target];
            } else if (target < range[0]) {
                right = range[0] - 1;
            } else {
                left = range[1] + 1;
            }
        }
        return nums[left];
    }

    private int[] partition(int[] nums, int left, int right, int pivot) {
        int less = left - 1, more = right, idx = left;
        while (idx <= more) {
            if (nums[idx] < pivot) {
                swap(nums, ++less, idx++);
            } else if (nums[idx] == pivot) {
                ++idx;
            } else {
                swap(nums, idx, more--);
            }
        }
        return new int[] { less + 1, more };
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
