package org.ginwithouta.leetcode.hot100;

/**
 * @author Ginwithouta
 * Generate at 2024/2/29
 * LeetCode Hot 100 数组中的第K个最大元素
 */
public class LeetCode_Hot_074_KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        /*
         * 可以利用三色旗来解决
         */
        if (nums.length == 1) {
            return nums[0];
        }
        int left = 0, right = nums.length - 1, index = nums.length - k;
        while (left < right) {
            int pivot = nums[left + (int) (Math.random() * (right - left + 1))];
            int[] range = partition(nums, left, right, pivot);
            if (index >= range[0] && index <= range[1]) {
                return nums[index];
            } else if (index < range[0]) {
                right = range[0] - 1;
            } else {
                left = range[1] + 1;
            }
        }
        return nums[left];
    }

    public int[] partition(int[] nums, int left, int right, int pivot) {
        int less = left - 1, more = right, index = left;
        while (index <= more) {
            if (nums[index] < pivot) {
                swap(nums, ++less, index++);
            } else if (nums[index] > pivot) {
                swap(nums, more--, index);
            } else {
                ++index;
            }
        }
        return new int[] {less + 1, more};
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
