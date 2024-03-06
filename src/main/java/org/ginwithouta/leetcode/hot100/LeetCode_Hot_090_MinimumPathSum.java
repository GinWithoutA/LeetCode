package org.ginwithouta.leetcode.hot100;

/**
 * @author Ginwithouta
 * Generate at 2024/3/6
 * LeetCode Hot 100 最小路径和
 */
public class LeetCode_Hot_090_MinimumPathSum {
    /**
     * 暴力递归
     */
    public int minPathSum(int[][] grid) {
        if (grid.length == 1 && grid[0].length == 1) {
            return grid[0][0];
        }
        return process(grid, 0, 0, 0);
    }
    public int process(int[][] grid, int path, int row, int col) {
        if (row >= grid.length || col >= grid[0].length) {
            return Integer.MAX_VALUE;
        }
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            return path + grid[row][col];
        }
        int p1 = process(grid, path + grid[row][col], row + 1, col);
        int p2 = process(grid, path + grid[row][col], row, col + 1);
        return Math.min(p1, p2);
    }

    /**
     * DP
     */
    public int minPathSum1(int[][] grid) {
        if (grid.length == 1 && grid[0].length == 1) {
            return grid[0][0];
        }
        int n = grid.length, m = grid[0].length;
        int[][] dp = new int[n][m];
        dp[n - 1][m - 1] = grid[n - 1][m - 1];
        for (int col = m - 2; col >= 0; --col) {
            dp[n - 1][col] = grid[n - 1][col] + dp[n - 1][col + 1];
        }
        for (int row = n - 2; row >= 0; --row) {
            for (int col = m - 1; col >= 0; --col) {
                int p1 = dp[row + 1][col];
                int p2 = col == m - 1 ? Integer.MAX_VALUE : dp[row][col + 1];
                dp[row][col] = grid[row][col] + Math.min(p1, p2);
            }
        }
        return dp[0][0];
    }
}
