package org.ginwithouta.leetcode.interview150;

/**
 * @author Ginwithouta
 * Generate at 2024/3/27
 * LeetCode 面试经典 150 删除有序数组中的重复项
 */
public class LeetCode_Interview_003_RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int idx = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] != nums[i - 1]) {
                nums[idx++] = nums[i];
            }
        }
        return idx;
    }
}
