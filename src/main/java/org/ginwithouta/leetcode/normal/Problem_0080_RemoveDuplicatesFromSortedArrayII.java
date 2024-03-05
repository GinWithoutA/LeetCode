package org.ginwithouta.leetcode.normal;

/**
 * @author Ginwithouta
 * Generate at 2023/12/4
 * Problem 删除有序数组中的重复项Ⅱ
 */
public class Problem_0080_RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        /*
         * 提供一个判断当前数字出现过几次的变量 appear ，当出现相等的数字，判断 appera 的次数，超过了就不做处理
         * 如果不相等，直接存储就行
         */
        if (nums.length == 1) {
            return 1;
        }
        int len = 1, appear = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] == nums[len - 1] && appear < 2) {
                nums[len++] = nums[i];
                ++appear;
            } else if (nums[i] != nums[len - 1]) {
                nums[len++] = nums[i];
                appear = 1;
            }
        }
        return len;
    }
}
