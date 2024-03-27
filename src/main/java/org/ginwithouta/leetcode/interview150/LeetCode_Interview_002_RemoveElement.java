package org.ginwithouta.leetcode.interview150;

/**
 * @author Ginwithouta
 * Generate at 2024/3/27
 * LeetCode 面试经典 150 移除元素
 */
public class LeetCode_Interview_002_RemoveElement {
    public int removeElement(int[] nums, int val) {
        int idx = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != val) {
                nums[idx++] = nums[i];
            }
        }
        return idx;
    }
}
