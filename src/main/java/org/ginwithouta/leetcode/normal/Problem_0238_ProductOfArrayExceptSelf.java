package org.ginwithouta.leetcode.normal;

import java.util.Arrays;

/**
 * @author Ginwithouta
 * Generate at 2023/12/5
 * Problem 除自身以外数组的乘积
 */
public class Problem_0238_ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        /*
         * 这道题主要的思路是要想到前缀和和后缀和，也就是在算取前缀和的时候不计算当前位置的元素
         * 有了这两个变量以及这个规定，那么当前缀和乘以后缀和，就是每个位置除去自身数组乘积的答
         * 案。
         *
         * 在这里，我们使用双指针的方式进行遍历，前后缀和一同计算，并一同加到 ans 中，遍历一遍的
         * 答案就是我们想要的
         */
        int[] ans = new int[nums.length];
        Arrays.fill(ans, 1);
        int beforeSum = 1, afterSum = 1;
        for (int i = 1, j = nums.length - 2; i < nums.length; ++i, --j) {
            beforeSum *= nums[i - 1];
            afterSum *= nums[j + 1];
            ans[i] *= beforeSum;
            ans[j] *= afterSum;
        }
        return ans;
    }
}
