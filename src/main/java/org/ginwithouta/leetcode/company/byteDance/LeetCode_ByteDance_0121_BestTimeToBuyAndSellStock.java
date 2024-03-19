package org.ginwithouta.leetcode.company.byteDance;

/**
 * @author Ginwithouta
 * Generate at 2024/3/16
 * LeetCode 字节跳动 买卖股票的最佳时机
 */
public class LeetCode_ByteDance_0121_BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int min = prices[0], max = 0;
        for (int i = 1; i < prices.length; ++i) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                max = Math.max(max, prices[i] - min);
            }
        }
        return max;
    }
}
