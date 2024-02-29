package org.ginwithouta.leetcode.hot100;

/**
 * @author Ginwithouta
 * Generate at 2024/2/29
 * LeetCode Hot 100 买卖股票的最佳时机Ⅰ
 */
public class LeetCode_Hot_077_BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        /*
         * 得保证前后有序，因此若更小的买入实际，就假设此时买入，否则就不卖出，一直算最大的利润
         */
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
