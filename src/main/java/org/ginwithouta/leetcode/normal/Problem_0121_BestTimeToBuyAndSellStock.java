package org.ginwithouta.leetcode.normal;

/**
 * @author Ginwithouta
 * Generate at 2023/12/4
 * Problem 买卖股票的最佳时机
 */
public class Problem_0121_BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        /*
         * 这题的关键在于，我们要找到差距最大的两个数。
         * 我们首先设最小的数是 0 位置的数，如果找到比它还小的，我们就假设这里是买入位置，遍历后面的数，找到最大的 ans
         */
        if (prices.length < 2) {
            return 0;
        }
        int min = prices[0], ans = 0;
        for (int i = 1; i < prices.length; ++i) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                ans = Math.max(prices[i] - min, ans);
            }
        }
        return ans;
    }
}
