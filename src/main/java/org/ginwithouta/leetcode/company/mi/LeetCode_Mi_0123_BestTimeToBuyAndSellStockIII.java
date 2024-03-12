package org.ginwithouta.leetcode.company.mi;

/**
 * @author Ginwithouta
 * Generate at 2024/3/12
 * LeetCode 小米 买卖股票的最佳时机Ⅲ
 */
public class LeetCode_Mi_0123_BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        int firstDone = 0, firstDoneMinsSecondBuy = -prices[0], min = prices[0], ans = 0;
        for (int i = 1; i < prices.length; ++i) {
            ans = Math.max(ans, firstDoneMinsSecondBuy + prices[i]);
            min = Math.min(min, prices[i]);
            firstDone = Math.max(firstDone, prices[i] - min);
            firstDoneMinsSecondBuy = Math.max(firstDoneMinsSecondBuy, firstDone - prices[i]);
        }
        return ans;
    }
}
