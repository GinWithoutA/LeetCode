package org.ginwithouta.leetcode;

/**
 * @author Ginwithouta
 * Generate at 2023/12/4
 * Problem 买卖股票的最佳时机Ⅱ
 */
public class Problem_0122_BestTimeToBuyAndSellStockII {

    public int maxProfit(int[] prices) {
        /*
         * 在这个股票问题中，我们可以进行无限多次的买卖股票的次数，那么就是说，我们只需要找到所有股票价格上涨的时机
         * 进行股票的买卖就行。
         */
        if (prices.length == 1) {
            return 0;
        }
        int ans = 0;
        for (int i = 1; i < prices.length; ++i) {
            ans += prices[i] > prices[i - 1] ? prices[i] - prices[i - 1] : 0;
        }
        return ans;
    }
}
