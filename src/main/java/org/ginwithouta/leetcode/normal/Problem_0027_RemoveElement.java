package org.ginwithouta.leetcode.normal;

/**
 * @author Ginwithouta
 * Generate at 2023/12/4
 * Problem 原地移除数组中值为给定值的数字
 */
public class Problem_0027_RemoveElement {
    public int removeElement(int[] nums, int val) {
        /*
         * 只要碰到相同的数字，就将最后一个元素放到当前位置，然后再次判断，直到遍历完一整个数组
         */
        int length = nums.length, cur = 0;
        while (cur < length) {
            if (nums[cur] == val) {
                nums[cur] = nums[--length];
            } else {
                ++cur;
            }
        }
        return length;
    }
}
