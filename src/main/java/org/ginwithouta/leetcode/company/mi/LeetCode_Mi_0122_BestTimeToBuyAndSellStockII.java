package org.ginwithouta.leetcode.company.mi;

/**
 * @author Ginwithouta
 * Generate at 2024/3/12
 * LeetCode 小米 买卖股票的最佳时机Ⅱ
 */
public class LeetCode_Mi_0122_BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int ans = 0;
        for (int i = 1; i < prices.length; ++i) {
            if (prices[i] > prices[i - 1]) {
                ans += (prices[i] - prices[i - 1]);
            }
        }
        return ans;
    }
}
