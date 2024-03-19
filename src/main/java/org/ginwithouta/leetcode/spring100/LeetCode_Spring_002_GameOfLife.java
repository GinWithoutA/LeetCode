package org.ginwithouta.leetcode.spring100;

/**
 * @author Ginwithouta
 * Generate at 2024/3/19
 * LeetCode 春招 100 生命游戏
 */
public class LeetCode_Spring_002_GameOfLife {
    public void gameOfLife(int[][] board) {
        /*
         * 一般做法就是辅助空间，然后更改之后再补充回去
         * 投机的方法是利用位运算，第一位表示原本的情况，1是存活，0是死亡
         * 第二位表示修改后的情况，1是存活，0是死亡
         */
        int n = board.length, m = board[0].length;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                int cells = neighbor(board, i, j);
                if ((board[i][j] == 1 && (cells == 2 || cells == 3)) || (board[i][j] == 0 && cells == 3)) {
                    set(board, i, j);
                }
            }
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                get(board, i, j);
            }
        }
    }

    private int neighbor(int[][] board, int row, int col) {
        int count = 0;
        count += ok(board, row - 1, col - 1) ? 1 : 0;
        count += ok(board, row - 1, col) ? 1 : 0;
        count += ok(board, row - 1, col + 1) ? 1 : 0;
        count += ok(board, row, col - 1) ? 1 : 0;
        count += ok(board, row, col + 1) ? 1 : 0;
        count += ok(board, row + 1, col - 1) ? 1 : 0;
        count += ok(board, row + 1, col) ? 1 : 0;
        count += ok(board, row + 1, col + 1) ? 1 : 0;
        return count;
    }

    private boolean ok(int[][] board, int row, int col) {
        return row >= 0 && col >= 0 && row < board.length && col < board[0].length && (board[row][col] & 1) == 1;
    }

    private void set(int[][] board, int row, int col) {
        board[row][col] |= 2;
    }

    private void get(int[][] board, int row, int col) {
        board[row][col] >>= 1;
    }

}
