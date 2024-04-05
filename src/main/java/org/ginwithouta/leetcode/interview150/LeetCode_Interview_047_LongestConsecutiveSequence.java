package org.ginwithouta.leetcode.interview150;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Ginwithouta
 * Generate at 2024/4/5
 * LeetCode 面试经典 150 最长连续序列
 */
public class LeetCode_Interview_047_LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int ans = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int cur = num, len = 1;
                while (set.contains(cur + 1)) {
                    ++cur;
                    ++len;
                }
                ans = Math.max(ans, len);
            }
        }
        return ans;
    }

    public int longestConsecutive1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int right = 1, ans = 0, len = 1, cur = nums[0];
        while (right < nums.length) {
            if (nums[right] == nums[right - 1]) {
                ++right;
            } else if (nums[right] - 1 == cur) {
                ++len;
                cur = nums[right++];
            } else {
                ans = Math.max(ans, len);
                len = 1;
                cur = nums[right++];
            }
        }
        return Math.max(len, ans);
    }
}
