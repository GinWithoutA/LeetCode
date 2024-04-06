package org.ginwithouta.leetcode.interview150;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ginwithouta
 * Generate at 2024/4/6
 * LeetCode 面试经典 150 汇总区间
 */
public class LeetCode_Interview_048_SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        if (nums.length == 0) {
            return ans;
        }
        int left = 0, right = 1;
        while (right < nums.length) {
            if (nums[right] - 1 != nums[right - 1]) {
                StringBuilder sb = new StringBuilder();
                sb.append(nums[left]);
                if (right - 1 != left) {
                    sb.append("->").append(nums[right - 1]);
                }
                ans.add(sb.toString());
                left = right;
            }
            ++right;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(nums[left]);
        if (right - 1 != left) {
            sb.append("->").append(nums[right - 1]);
        }
        ans.add(sb.toString());
        return ans;
    }
}
