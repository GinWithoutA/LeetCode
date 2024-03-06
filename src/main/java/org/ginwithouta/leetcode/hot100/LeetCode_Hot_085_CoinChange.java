package org.ginwithouta.leetcode.hot100;

import java.util.Arrays;

/**
 * @author Ginwithouta
 * Generate at 2024/3/4
 * LeetCode Hot 100 零钱兑换
 */
public class LeetCode_Hot_085_CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; ++i) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    /**
     * 尝试，暴力递归
     */
    public int coinChange1(int[] coins, int amount) {
        return process(coins, amount, 0);
    }

    public int process(int[] coins, int left, int idx) {
        if (idx == coins.length) {
            return left == 0 ? 0 : -1;
        }
        int ans = Integer.MAX_VALUE;
        for (int zhang = 0; zhang * coins[idx] <= left; ++zhang) {
            int res = process(coins, left - zhang * coins[idx], idx + 1);
            if (res != -1) {
                ans = Math.min(zhang + res, ans);
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }


}
