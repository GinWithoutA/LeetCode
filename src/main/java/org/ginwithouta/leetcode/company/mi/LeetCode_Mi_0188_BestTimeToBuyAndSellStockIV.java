package org.ginwithouta.leetcode.company.mi;

/**
 * @author Ginwithouta
 * Generate at 2024/3/12
 * LeetCode 小米 买卖股票的最佳时机Ⅳ
 */
public class LeetCode_Mi_0188_BestTimeToBuyAndSellStockIV {
    public int maxProfit(int k, int[] prices) {
        /*
         * 首先有一个过滤条件，当 k >= prices.length / 2 的时候，相当于无限次交易，我们只需要取所有上涨的部分就行
         * 对于一般情况，我们可以用一个二维 dp 表格来计算，dp[i][j] 表示从 0 到 i 位置上完成不超过 j 次交易的最大
         * 收益是多少，那么此时：
         * 第0行表示 0-0 位置上，不超过 j 次交易，答案都是0
         * 第0列表示 0-i 位置上，不超过 0 次交易，答案也都是0
         * 对于其他位置
         * 1：如果最后一个位置 i 不参与交易，那么答案就是 dp[i - 1][j]
         * 2：如果最后一个位置 i 参与交易，我们可以用利用贪心，只有在最后一个位置卖出才有意义
         *    因此需要枚举所有可能的买入情况，也就是枚举 0-i 范围上 dp[p][j - 1] + prices[i] - prices[p] 的最大值
         */
        if (k >= prices.length / 2) {
            return all(prices);
        }
        int[][] dp = new int[prices.length][k + 1];
        for (int i = 1; i < prices.length; ++i) {
            for (int j = 1; j <= k; ++j) {
                dp[i][j] = dp[i - 1][j];
                for (int p = 0; p <= i; ++p) {
                    dp[i][j] = Math.max(dp[i][j], dp[p][j - 1] + prices[i] - prices[p]);
                }
            }
        }
        return dp[prices.length - 1][k];
    }

    public int all(int[] prices) {
        int ans = 0;
        for (int i = 1; i < prices.length; ++i) {
            if (prices[i] > prices[i - 1]) {
                ans += (prices[i] - prices[i - 1]);
            }
        }
        return ans;
    }


}
