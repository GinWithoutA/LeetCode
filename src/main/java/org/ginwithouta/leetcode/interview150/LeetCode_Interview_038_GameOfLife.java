package org.ginwithouta.leetcode.interview150;

/**
 * @author Ginwithouta
 * Generate at 2024/4/5
 * LeetCode 面试经典 150 生命游戏
 */
public class LeetCode_Interview_038_GameOfLife {
    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                int cells = countCells(board, i, j);
                if ((board[i][j] == 1 && (cells == 2 || cells == 3)) || (board[i][j] == 0 && cells == 3)) {
                    board[i][j] |= 2;
                }
            }
        }
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                board[i][j] >>= 1;
            }
        }
    }
    private int countCells(int[][] board, int row, int col) {
        int ans = 0;
        ans += ok(board, row - 1, col - 1) ? 1 : 0;
        ans += ok(board, row - 1, col) ? 1 : 0;
        ans += ok(board, row - 1, col + 1) ? 1 : 0;
        ans += ok(board, row, col - 1) ? 1 : 0;
        ans += ok(board, row, col + 1) ? 1 : 0;
        ans += ok(board, row + 1, col - 1) ? 1 : 0;
        ans += ok(board, row + 1, col) ? 1 : 0;
        ans += ok(board, row + 1, col + 1) ? 1 : 0;
        return ans;
    }
    private boolean ok(int[][] board, int row, int col) {
        return row >= 0 && row < board.length && col >= 0 && col < board[0].length && (board[row][col] & 1) == 1;
    }
}
