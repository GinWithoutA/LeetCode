package org.ginwithouta.leetcode.company.byteDance;

/**
 * @author Ginwithouta
 * Generate at 2024/3/16
 * LeetCode 字节跳动 岛屿数量
 */
public class LeetCode_ByteDance_0200_NumberOfIslands {
    public int numIslands(char[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == '1') {
                    process(grid, i, j);
                    ++ans;
                }
            }
        }
        return ans;
    }
    private void process(char[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != '1') {
            return;
        }
        grid[row][col] = '0';
        process(grid, row + 1, col);
        process(grid, row - 1, col);
        process(grid, row, col + 1);
        process(grid, row, col - 1);
    }
}
