package org.ginwithouta.leetcode.normal;

/**
 * @author Ginwithouta
 * Generate at 2024/1/31
 * Problem 单词搜索
 */
public class Problem_0079_WordSearch {
    public boolean exist(char[][] board, String word) {
        /*
         * 每个位置不断往下遍历，要是能找到就返回 true ，找不到就从下一个位置继续开始
         */
        if (board.length * board[0].length < word.length()) {
            return false;
        }
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (process(board, words, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean process(char[][] board, char[] words, int idx, int row, int col) {
        if (idx == words.length) {
            return true;
        }
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != words[idx]) {
            return false;
        }
        char temp = board[row][col];
        board[row][col] = '0';
        boolean res = process(board, words, idx + 1, row + 1, col) ||
                process(board, words, idx + 1, row - 1, col) ||
                process(board, words, idx + 1, row, col + 1) ||
                process(board, words, idx + 1, row, col - 1);
        board[row][col] = temp;
        return res;
    }
}
