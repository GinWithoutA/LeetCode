package org.ginwithouta.leetcode.normal;

import java.util.Arrays;

/**
 * @author Ginwithouta
 * Generate at 2023/12/20
 * Problem 生命游戏
 */
public class Problem_0289_GameOfLife {

    public static void gameOfLife(int[][] board) {
        /*
         * 直接尝试就能解决
         */
        if (board.length == 1 && board[0].length == 1) {
            board[0][0] = 0;
            return;
        }
        int[][] help = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; ++i) {
            System.arraycopy(board[i], 0, help[i], 0, board[0].length);
        }
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                int count = 0;
                count += i - 1 >= 0 && j - 1 >= 0 && help[i - 1][j - 1] == 1 ? 1 : 0;
                count += j - 1 >= 0 && help[i][j - 1] == 1 ? 1 : 0;
                count += i + 1 < board.length && j - 1 >= 0 && help[i + 1][j - 1] == 1 ? 1 : 0;
                count += i + 1 < board.length && help[i + 1][j] == 1 ? 1 : 0;
                count += i + 1 < board.length && j + 1 < board[0].length && help[i + 1][j + 1] == 1 ? 1 : 0;
                count += j + 1 < board[0].length && help[i][j + 1] == 1 ? 1 : 0;
                count += i - 1 >= 0 && j + 1 < board[0].length && help[i - 1][j + 1] == 1 ? 1 : 0;
                count += i - 1 >= 0 && help[i - 1][j] == 1 ? 1 : 0;
                if (help[i][j] == 0 && count == 3) {
                    board[i][j] = 1;
                }
                if (help[i][j] == 1 && (count < 2 || count > 3)) {
                    board[i][j] = 0;
                }
            }
        }
    }

    public static void gameOfLifeCurrent(int[][] board) {
        /*
         * 在这个方法中，我们使用原地进行处理，对于变化的细胞，我们给定一个额外状态来表示，比如 2。
         * 如果一个细胞原本是活的，更新之后变成死细胞，我们将其表示为 -1
         * 如果一个细胞本来是死的，更新之后变成活细胞，我们将其表示为 2
         */
        if (board.length == 1 && board[0].length == 1) {
            board[0][0] = 0;
            return;
        }
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                int count = 0;
                count += i - 1 >= 0 && j - 1 >= 0 && (board[i - 1][j - 1] == 1 || board[i - 1][j - 1] == -1) ? 1 : 0;
                count += j - 1 >= 0 && (board[i][j - 1] == 1 || board[i][j - 1] == -1) ? 1 : 0;
                count += i + 1 < board.length && j - 1 >= 0 && (board[i + 1][j - 1] == 1 || board[i + 1][j - 1] == -1) ? 1 : 0;
                count += i + 1 < board.length && (board[i + 1][j] == 1 || board[i + 1][j] == -1) ? 1 : 0;
                count += i + 1 < board.length && j + 1 < board[0].length && (board[i + 1][j + 1] == 1 || board[i + 1][j + 1] == -1) ? 1 : 0;
                count += j + 1 < board[0].length && (board[i][j + 1] == 1 || board[i][j + 1] == -1) ? 1 : 0;
                count += i - 1 >= 0 && j + 1 < board[0].length && (board[i - 1][j + 1] == 1 || board[i - 1][j + 1] == -1) ? 1 : 0;
                count += i - 1 >= 0 && (board[i - 1][j] == 1 || board[i - 1][j] == -1) ? 1 : 0;
                if (board[i][j] == 0 && count == 3) {
                    board[i][j] = 2;
                }
                if (board[i][j] == 1 && (count < 2 || count > 3)) {
                    board[i][j] = -1;
                }
            }
        }
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (board[i][j] == 2) {
                    board[i][j] = 1;
                }
                if (board[i][j] == -1) {
                    board[i][j] = 0;
                }
            }
        }
    }

}
