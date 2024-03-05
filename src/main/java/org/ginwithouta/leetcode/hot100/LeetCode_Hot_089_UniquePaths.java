package org.ginwithouta.leetcode.hot100;

import java.util.Arrays;

/**
 * @author Ginwithouta
 * Generate at 2024/3/5
 * LeetCode Hot 100 不同路径
 */
public class LeetCode_Hot_089_UniquePaths {
    /**
     * 暴力递归
     */
    public int uniquePaths(int m, int n) {
        if (m == 1 && n == 1) {
            return 1;
        }
        return process(m, n, 0, 0);
    }
    public int process(int m, int n, int row, int col) {
        if (row >= m || col >= n) {
            return 0;
        }
        if (row == m - 1 && col == n - 1) {
            return 1;
        }
        return process(m, n, row + 1, col) + process(m, n, row, col + 1);
    }

    /**
     * 只有两个变量会动，分别在 1 m 和 1 n 之间动，所以二维dp表格
     */
    public int uniquePaths1(int m, int n) {
        if (m == 1 && n == 1) {
            return 1;
        }
        int[][] dp = new int[m][n];
        Arrays.fill(dp[m - 1], 1);
        for (int row = m - 2; row >= 0; --row) {
            for (int col = n - 1; col >= 0; --col) {
                dp[row][col] = dp[row + 1][col] + ((col + 1) < n ? dp[row][col + 1] : 0);
            }
        }
        return dp[0][0];
    }
}
