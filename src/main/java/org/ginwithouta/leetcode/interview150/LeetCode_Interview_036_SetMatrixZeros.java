package org.ginwithouta.leetcode.interview150;

import java.util.Arrays;

/**
 * @author Ginwithouta
 * Generate at 2024/4/5
 * LeetCode 面试经典 150 矩阵置零
 */
public class LeetCode_Interview_036_SetMatrixZeros {
    public void setZeroes(int[][] matrix) {
        int rowZeros = 1;
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    if (i == 0) {
                        rowZeros = 0;
                    } else {
                        matrix[i][0] = 0;
                    }
                }
            }
        }
        for (int i = 1; i < matrix.length; ++i) {
            for (int j = matrix[0].length - 1; j >= 0; --j) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (rowZeros == 0) {
            Arrays.fill(matrix[0], 0);
        }
    }
}
