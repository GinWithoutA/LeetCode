package org.ginwithouta.leetcode.hot100;

/**
 * @author Ginwithouta
 * Generate at 2024/2/23
 * LeetCode Hot 100 单词搜索
 */
public class LeetCode_Hot_060_WordSearch {
    public boolean exist(char[][] board, String word) {
        if (board.length * board[0].length < word.length()) {
            return false;
        }
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (board[i][j] == words[0] && process(board, words, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean process(char[][] board, char[] words, int row, int col, int idx) {
        if (idx == words.length) {
            return true;
        }
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != words[idx]) {
            return false;
        }
        char cur = board[row][col];
        board[row][col] = '0';
        boolean flag = process(board, words, row + 1, col, idx + 1)
                    || process(board, words, row - 1, col, idx + 1)
                    || process(board, words, row, col + 1, idx + 1)
                    || process(board, words, row, col - 1, idx + 1);
        board[row][col] = cur;
        return flag;
    }
}
