package org.ginwithouta.leetcode.interview150;

/**
 * @author Ginwithouta
 * Generate at 2024/4/9
 * LeetCode 面试经典 150 岛屿数量
 */
public class LeetCode_Interview_085_NumberOfIslands {
    public int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length, ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == '1') {
                    ++ans;
                    infect(grid, n, m, i, j);
                }
            }
        }
        return ans;
    }
    private void infect(char[][] grid, int n, int m, int row, int col) {
        if (row < 0 || row >= n || col < 0 || col >= m || grid[row][col] == '0') {
            return;
        }
        grid[row][col] = '0';
        infect(grid, n, m, row + 1, col);
        infect(grid, n, m, row - 1, col);
        infect(grid, n, m, row, col + 1);
        infect(grid, n, m, row, col - 1);
    }
}
