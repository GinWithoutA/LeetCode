package org.ginwithouta.leetcode.interview150;

/**
 * @author Ginwithouta
 * Generate at 2024/4/4
 * LeetCode 面试经典 150 有效的数独
 */
public class LeetCode_Interview_034_ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        int[][] bucket = new int[9][9];
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] != '.') {
                    int cur = board[i][j] - '1', pos = 3 * (i / 3) + j / 3;
                    if (row[i][cur] != 0 || col[j][cur] != 0 || bucket[pos][cur] != 0) {
                        return false;
                    }
                    row[i][cur] = 1;
                    col[j][cur] = 1;
                    bucket[pos][cur] = 1;
                }
            }
        }
        return true;
    }
}
