package org.ginwithouta.leetcode;

import java.util.List;

/**
 * @author Ginwithouta
 * Generate at 2024/1/24
 * Problem 美丽塔
 */
public class Problem_2865_BeautifulTowersI {
    /**
     * 暴力解法
     */
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        if (maxHeights.size() == 1) {
            return maxHeights.get(0);
        }
        long ans = 0L;
        for (int i = 0; i < maxHeights.size(); ++i) {
            long cur = maxHeights.get(i);
            int leftMax = maxHeights.get(i), rightMax = leftMax;
            for (int left = i - 1; left >= 0; --left) {
                if (maxHeights.get(left) < leftMax) {
                    leftMax = maxHeights.get(left);
                }
                cur += leftMax;
            }
            for (int right = i + 1; right < maxHeights.size(); ++right) {
                if (maxHeights.get(right) < rightMax) {
                    rightMax = maxHeights.get(right);
                }
                cur += rightMax;
            }
            ans = Math.max(ans, cur);
        }
        return ans;
    }
}
