package org.ginwithouta.leetcode.hot100;

import java.util.Arrays;

/**
 * @author Ginwithouta
 * Generate at 2024/2/16
 * LeetCode Hot 100 最长连续序列
 */
public class LeetCode_Hot_003_LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int right = 1, ans = 0, len = 1, prevNum = nums[0];
        while (right < nums.length) {
            if (nums[right] == prevNum) {
                ++right;
            } else if (nums[right] == prevNum + 1) {
                prevNum = nums[right++];
                ++len;
            } else {
                ans = Math.max(ans, len);
                prevNum = nums[right++];
                len = 1;
            }
        }
        return Math.max(ans, len);
    }
}
