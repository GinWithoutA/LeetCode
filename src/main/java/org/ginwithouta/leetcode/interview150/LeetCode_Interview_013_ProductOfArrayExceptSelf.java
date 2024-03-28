package org.ginwithouta.leetcode.interview150;

import java.util.Arrays;

/**
 * @author Ginwithouta
 * Generate at 2024/3/28
 * LeetCode 面试经典 150 除自身以外数组的乘积
 */
public class LeetCode_Interview_013_ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int temp = 1;
        for (int i = nums.length - 1; i >= 0; --i) {
            ans[i] = temp;
            temp *= nums[i];
        }
        temp = 1;
        for (int i = 0; i < nums.length; ++i) {
            ans[i] = temp * ans[i];
            temp *= nums[i];
        }
        return ans;
    }
}
