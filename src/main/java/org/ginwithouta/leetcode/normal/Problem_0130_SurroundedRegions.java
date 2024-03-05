package org.ginwithouta.leetcode.normal;

/**
 * @author Ginwithouta
 * Generate at 2024/1/27
 * Problem 被环绕的区域
 */
public class Problem_0130_SurroundedRegions {
    public void solve(char[][] board) {
        /*
         * 只要我们发现一个 O ，就去 dfs ，并修改遍历到的所有点的值，如果最终遍历成功，那么第一个遍历的
         * 元素就可以修改为 T ，否则修改为 F ，这样当我们后续第二次遍历进行修改的时候，就可以直到当前区
         * 域是否可以变成 X
         */
        boolean[] check = new boolean[1];
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (board[i][j] == 'O') {
                    check[0] = true;
                    can(board, check, i, j);
                    board[i][j] = check[0] ? 'T' : 'F';
                }
            }
        }
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                char can = board[i][j];
                if (can == 'T' || can == 'F') {
                    board[i][j] = '.';
                }
                change(board, i, j, can);
            }
        }
    }
    public void can(char[][] board, boolean[] check, int row, int col) {
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) {
            check[0] = false;
            return;
        }
        if (board[row][col] == 'O') {
            board[row][col] = '.';
            can(board, check, row + 1, col);
            can(board, check, row - 1, col);
            can(board, check, row, col + 1);
            can(board, check, row, col - 1);
        }
    }

    public void change(char[][] board, int row, int col, char can) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return;
        }
        if (board[row][col] == '.') {
            board[row][col] = can == 'T' ? 'X' : 'O';
            change(board, row + 1, col, can);
            change(board, row - 1, col, can);
            change(board, row, col + 1, can);
            change(board, row, col - 1, can);
        }
    }
}
