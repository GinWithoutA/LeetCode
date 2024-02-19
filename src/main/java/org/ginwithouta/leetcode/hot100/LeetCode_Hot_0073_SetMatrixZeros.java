package org.ginwithouta.leetcode.hot100;

import java.util.Arrays;

/**
 * @author Ginwithouta
 * Generate at 2024/2/19
 * LeetCode Hot 100 矩阵置零
 */
public class LeetCode_Hot_0073_SetMatrixZeros {
    public void setZeros(int[][] matrix) {
        /*
         * 新增一个变量标识第一行是否需要变零，其他的正常遍历，若为0，所在列的第一个元素变零，所在行的第一个元素变零
         */
        boolean firstRowZeros = false;
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    if (i == 0) {
                        firstRowZeros = true;
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
        if (firstRowZeros) {
            Arrays.fill(matrix[0], 0);
        }
    }
}
