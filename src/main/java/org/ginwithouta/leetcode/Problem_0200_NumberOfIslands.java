package org.ginwithouta.leetcode;

/**
 * @author Ginwithouta
 * Generate at 2024/1/27
 * Problem 岛屿数量
 */
public class Problem_0200_NumberOfIslands {
    /**
     * 深度优先遍历
     */
    public int numIslandsDfs(char[][] grid) {
        int[][] flag = new int[grid.length][grid[0].length];
        int ans = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == '1' && flag[i][j] == 0) {
                    ++ans;
                    dfs(grid, flag, i, j);
                }
            }
        }
        return ans;
    }
    public void dfs(char[][] grid, int[][] flag, int rowIndex, int colIndex) {
        if (rowIndex < 0 || rowIndex == grid.length || colIndex < 0 || colIndex == grid[0].length) {
            return;
        }
        if (grid[rowIndex][colIndex] == '0' || flag[rowIndex][colIndex] == 1) {
            return;
        }
        flag[rowIndex][colIndex] = 1;
        process(grid, flag, rowIndex + 1, colIndex);
        process(grid, flag, rowIndex - 1, colIndex);
        process(grid, flag, rowIndex, colIndex + 1);
        process(grid, flag, rowIndex, colIndex - 1);
    }
}
