package org.ginwithouta.leetcode.hot100;

import java.util.Arrays;

/**
 * @author Ginwithouta
 * Generate at 2024/2/19
 * LeetCode Hot 100 除自身以外数组的乘积
 */
public class LeetCode_Hot_016_ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        /*
         * 双指针破解，对于每个位置，我们可以分别求两个值，一个是当前位置后续所有值的乘积，另一个是当前位置前面所有位置的乘积
         * 那么对于每个位置的值，就可以通过分别乘左右两个累积乘积来计算
         * */
        int[] ans = new int[nums.length];
        Arrays.fill(ans, 1);
        int before = 1, after = 1;
        for (int i = 1, j = nums.length - 2; i < nums.length; ++i, --j) {
            before *= nums[i - 1];
            after *= nums[j + 1];
            ans[i] *= before;
            ans[j] *= after;
        }
        return ans;
    }
}
