package org.ginwithouta.leetcode.interview150;

/**
 * @author Ginwithouta
 * Generate at 2024/3/27
 * LeetCode 面试经典 150 买卖股票的最佳时机
 */
public class LeetCode_Interview_007_BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int min = prices[0], ans = 0;
        for (int i = 1; i < prices.length; ++i) {
            min = Math.min(min, prices[i]);
            ans = Math.max(ans, prices[i] - min);
        }
        return ans;
    }
}
