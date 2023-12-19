package org.ginwithouta.leetcode;

import java.util.Arrays;

/**
 * @author Ginwithouta
 * Generate at 2023/12/19
 * Problem 矩阵置零
 */
public class Problem_0073_SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        /*
         * 这题主要考察编码技巧
         * 可以将矩阵的第一行和第一列当作是所在行或列是否需要清零的标准，如果第一行的某个元素是 0，表明所在列需要清零
         * 如果第一列的某个元素是 0 ，表明所在行的元素需要清零
         * 由于 [0, 0] 元素既可以是行也可以是列，因此我们需要一个额外的变量来判断第一行（或者列）是否需要清零
         */
        if (matrix.length == 1 && matrix[0].length == 1) {
            return;
        }
        boolean rowZero = false;
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    if (i == 0) {
                        rowZero = true;
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
        if (rowZero) {
            Arrays.fill(matrix[0], 0);
        }
    }
}
