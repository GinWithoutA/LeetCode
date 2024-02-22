package org.ginwithouta.leetcode.hot100;

/**
 * @author Ginwithouta
 * Generate at 2024/2/22
 * LeetCode Hot 100 岛屿的数量
 */
public class LeetCode_Hot_051_NumberOfIslands {
    public int numIslands(char[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == '1') {
                    ++ans;
                    process(grid, i, j);
                }
            }
        }
        return ans;
    }

    public void process(char[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return;
        }
        if (grid[row][col] == '1') {
            grid[row][col] = '0';
            process(grid, row + 1, col);
            process(grid, row - 1, col);
            process(grid, row, col + 1);
            process(grid, row, col - 1);
        }
    }
}
