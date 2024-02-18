package org.ginwithouta.leetcode.hot100;

/**
 * @author Ginwithouta
 * Generate at 2024/2/18
 * LeetCode Hot 100 最大子数组和
 */
public class LeetCode_Hot_0053_MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int ans = nums[0], pre = nums[0], cur;
        for (int i = 1; i < nums.length; ++i) {
            // 这句话的意思就是如果前面的和累加上现在的值大于现在的值，那么就累加，否则就布雷加
            cur = Math.max(pre + nums[i], nums[i]);
            ans = Math.max(ans, cur);
            pre = cur;
        }
        return ans;
    }
}
