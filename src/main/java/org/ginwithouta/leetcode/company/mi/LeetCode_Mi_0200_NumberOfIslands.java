package org.ginwithouta.leetcode.company.mi;

/**
 * @author Ginwithouta
 * Generate at 2024/3/12
 * LeetCode 小米 岛屿数量
 */
public class LeetCode_Mi_0200_NumberOfIslands {
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

    public void process(char[][] grid, int row, int col) {
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
