package org.ginwithouta.leetcode.company.mi;

/**
 * @author Ginwithouta
 * Generate at 2024/3/12
 * LeetCode 小米 买卖股票的最佳时机
 */
public class LeetCode_Mi_0121_BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int min = 10001, max = 0;
        for (int price : prices) {
            if (price < min) {
                min = price;
            } else {
                max = Math.max(max, price - min);
            }
        }
        return max;
    }
}
