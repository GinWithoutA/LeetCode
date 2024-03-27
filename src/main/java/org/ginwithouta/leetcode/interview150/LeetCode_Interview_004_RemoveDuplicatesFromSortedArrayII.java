package org.ginwithouta.leetcode.interview150;

/**
 * @author Ginwithouta
 * Generate at 2024/3/27
 * LeetCode 面试经典 150 删除有序数组中的重复项Ⅱ
 */
public class LeetCode_Interview_004_RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        int idx = 1, cur = 1;
        while (cur < nums.length) {
            if (nums[cur] == nums[cur - 1]) {
                nums[idx++] = nums[cur++];
                while (cur < nums.length && nums[cur] == nums[idx - 1]) {
                    ++cur;
                }
            } else {
                nums[idx++] = nums[cur++];
            }
        }
        return idx;
    }
}
