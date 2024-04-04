package org.ginwithouta.leetcode.interview150;

/**
 * @author Ginwithouta
 * Generate at 2024/4/4
 * LeetCode 面试经典 150 长度最小的子数组
 */
public class LeetCode_Interview_030_MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0, sum = nums[0], ans = 0;
        while (true) {
            if (sum >= target) {
                ans = ans == 0 ? right - left + 1 : Math.min(ans, right - left + 1);
                sum -= nums[left++];
            } else {
                if (right >= nums.length - 1) {
                    break;
                }
                sum += nums[++right];
            }
        }
        return ans;
    }
}
