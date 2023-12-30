package org.ginwithouta.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ginwithouta
 * Generate at 2023/12/30
 * Problem 汇总区间
 */
public class Problem_0228_SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        /*
         * 由于是互不相同的元素，遍历一次，只要前一个元素加 1 不是后一个元素，就找到了一个区间
         */
        List<String> ans = new ArrayList<>();
        int right = 0;
        while (right < nums.length) {
            int low = right;
            ++right;
            while (right < nums.length && nums[right - 1] + 1 == nums[right]) {
                ++right;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(nums[low]));
            if (low < right - 1) {
                sb.append("->");
                sb.append(nums[right - 1]);
            }
            ans.add(sb.toString());
        }
        return ans;
    }
}
