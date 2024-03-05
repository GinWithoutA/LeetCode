package org.ginwithouta.leetcode.normal;

/**
 * @author Ginwithouta
 * Generate at 2023/12/18
 * Problem 有效的数独
 */
public class Problem_0036_ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        /*
         * 只需要判断当前行，当前列，当前区域是否有相同的数字就行，为了防止多次遍历，我们需要给一个额外的
         * 集合来存储之前的值并进行判断
         */
        boolean[][] row = new boolean[9][9];
        boolean[][] column = new boolean[9][9];
        boolean[][] area = new boolean[9][9];
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.') {
                    continue;
                }
                int areaIndex = (i / 3) * 3 + j / 3, cur = board[i][j] - '1';
                if (row[i][cur] || column[j][cur] || area[areaIndex][cur]) {
                    return false;
                }
                row[i][cur] = true;
                column[j][cur] = true;
                area[areaIndex][cur] = true;
            }
        }
        return true;
    }
}
