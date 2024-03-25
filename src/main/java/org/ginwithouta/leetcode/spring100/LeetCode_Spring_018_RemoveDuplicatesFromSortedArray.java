package org.ginwithouta.leetcode.spring100;

/**
 * @author Ginwithouta
 * Generate at 2024/3/25
 * LeetCode 春招 100 删除有序数组中的重复项
 */
public class LeetCode_Spring_018_RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int idx = 1, cur = 1;
        while (cur < nums.length) {
            while (cur < nums.length && nums[cur] == nums[cur - 1]) {
                ++cur;
            }
            if (cur == nums.length) {
                break;
            }
            nums[idx++] = nums[cur++];
        }
        return idx;
    }
}
