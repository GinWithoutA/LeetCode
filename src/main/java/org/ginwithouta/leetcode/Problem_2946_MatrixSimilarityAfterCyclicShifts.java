package org.ginwithouta.leetcode;

/**
 * @author Ginwithouta
 * Generate at 2023/11/30
 * Problem 循环移位后的矩阵相似检查
 */
public class Problem_2946_MatrixSimilarityAfterCyclicShifts {
    public boolean areSimilar(int[][] mat, int k) {
        /*
         * 1）可以发现，当 k 是 mat 列数的倍数的时候，相当于没有移动，最终一定和原始一样
         * 2）左移右移在这里都是一样的，都可以用 (col + k) % n 来计算，只要都相等，那么最终也就是相等的
         */
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return false;
        }
        int n = mat[0].length;
        if (k % n == 0) {
            return true;
        }
        for (int[] ints : mat) {
            for (int col = 0; col < n; ++col) {
                if (ints[col] != ints[(col + k) % n]) {
                    return false;
                }
            }
        }
        return true;
    }
}
