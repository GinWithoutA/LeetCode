package org.ginwithouta.leetcode.interview150;

/**
 * @author Ginwithouta
 * Generate at 2024/3/27
 * LeetCode 面试经典 150 轮转数组
 */
public class LeetCode_Interview_006_RotateArray {
    public void rotate(int[] nums, int k) {
        if (k >= nums.length && k % nums.length == 0) {
            return;
        }
        k = k < nums.length ? k : k % nums.length;
        int count = 0;
        for (int i = 0; i < nums.length && count < nums.length; ++i) {
            int cur = i, temp = nums[i], prev;
            do {
                prev = temp;
                cur = (k + cur) % nums.length;
                temp = nums[cur];
                nums[cur] = prev;
                ++count;
            } while (cur != i);
        }
    }

}
