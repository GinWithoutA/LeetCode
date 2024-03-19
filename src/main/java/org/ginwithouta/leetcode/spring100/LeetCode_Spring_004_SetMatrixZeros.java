package org.ginwithouta.leetcode.spring100;

import java.util.Arrays;

/**
 * @author Ginwithouta
 * Generate at 2024/3/19
 * LeetCode 春招 100 矩阵置零
 */
public class LeetCode_Spring_004_SetMatrixZeros {
    public void setZeros(int[][] matrix) {
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
