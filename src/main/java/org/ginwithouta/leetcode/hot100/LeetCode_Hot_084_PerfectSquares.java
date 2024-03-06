package org.ginwithouta.leetcode.hot100;

/**
 * @author Ginwithouta
 * Generate at 2024/3/4
 * LeetCode Hot 100 完全平方数
 */
public class LeetCode_Hot_084_PerfectSquares {
    public int numSquares(int n) {
        /*
         * 计算 i - j * j 需要多少个数表示，最后计算每一个 dp 位置的时候
         * 都需要加上当前的 1 个用来表示的数
         */
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            int cnt = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; ++j) {
                cnt = Math.min(cnt, dp[i - j * j]);
            }
            dp[i] = 1 + cnt;
        }
        return dp[n];
    }
}
