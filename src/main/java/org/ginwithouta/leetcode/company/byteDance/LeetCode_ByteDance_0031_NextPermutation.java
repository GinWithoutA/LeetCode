package org.ginwithouta.leetcode.company.byteDance;

/**
 * @author Ginwithouta
 * Generate at 2024/3/16
 * LeetCode 字节跳动 下一个排列
 */
public class LeetCode_ByteDance_0031_NextPermutation {
    public void nextPermutation(int[] nums) {
        /*
         * 下一个排列一定是第一个比当前数大的排列，因此我们需要找到第一个顺序对，确认当前主元素是哪个
         * 然后，从后往前找第一个比主元素大的元素，交换，将主元素后续的所有元素变为非递减排列
         */
        int idx = nums.length - 2;
        while (idx >= 0 && nums[idx] >= nums[idx + 1]) {
            --idx;
        }
        if (idx < 0) {
            reverse(nums, 0);
            return;
        }
        for (int i = nums.length - 1; i > idx; --i) {
            if (nums[i] > nums[idx]) {
                swap(nums, idx, i);
                break;
            }
        }
        reverse(nums, idx + 1);
    }
    private void reverse(int[] nums, int begin) {
        int end = nums.length - 1;
        while (begin < end) {
            swap(nums, begin++, end--);
        }
    }
    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
