package org.ginwithouta.leetcode.interview150;

/**
 * @author Ginwithouta
 * Generate at 2024/4/9
 * LeetCode 面试经典 150 被围绕的区域
 */
public class LeetCode_Interview_086_SurroundedRegions {
    public void solve(char[][] board) {
        int n = board.length, m = board[0].length;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (board[i][j] == 'O' && (i == 0 || j == 0 || i == n - 1 || j == m - 1)) {
                    infect(board, n, m, i, j);
                }
            }
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '*') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    private void infect(char[][] board, int n, int m, int row, int col) {
        if (row < 0 || col < 0 || row >= n || col >= m || board[row][col] == 'X' || board[row][col] == '*') {
            return;
        }
        board[row][col] = '*';
        infect(board, n, m, row + 1, col);
        infect(board, n, m, row - 1, col);
        infect(board, n, m, row, col + 1);
        infect(board, n, m, row, col - 1);
    }
}
