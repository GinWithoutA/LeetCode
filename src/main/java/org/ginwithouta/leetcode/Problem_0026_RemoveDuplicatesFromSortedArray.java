package org.ginwithouta.leetcode;

/**
 * @author Ginwithouta
 * Generate at 2023/12/4
 * Problem 删除有序数组中的重复项
 */
public class Problem_0026_RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        /*
         * 每次遍历到一个不相同的数，就往数组的头上放，最后返回放的个数
         */
        int len = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] != nums[i - 1]) {
                nums[len++] = nums[i];
            }
        }
        return len;
    }
}
