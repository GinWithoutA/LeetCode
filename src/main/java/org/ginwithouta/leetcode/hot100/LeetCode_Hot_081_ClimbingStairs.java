package org.ginwithouta.leetcode.hot100;

/**
 * @author Ginwithouta
 * Generate at 2024/2/29
 * LeetCode Hot 100 爬楼梯
 */
public class LeetCode_Hot_081_ClimbingStairs {
    public int climbStairs(int n) {
        /*
         * 本题动态规划的公式是 f(x) = f(x - 1) + f(x - 2)
         */
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < dp.length; ++i) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[dp.length - 1];
    }
}
