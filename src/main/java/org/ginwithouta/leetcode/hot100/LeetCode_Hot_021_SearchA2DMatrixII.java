package org.ginwithouta.leetcode.hot100;

/**
 * @author Ginwithouta
 * Generate at 2024/2/20
 * LeetCode Hot 100 搜索二维矩阵Ⅱ
 */
public class LeetCode_Hot_021_SearchA2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (target == ints[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        for (int[] ints : matrix) {
            int left = 0, right = ints.length - 1, mid;
            while (left <= right) {
                mid = (left + right) / 2;
                if (ints[mid] == target) {
                    return true;
                } else if (ints[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }


    public boolean searchMatrix3(int[][] matrix, int target) {
        /*
         * 从右上角开始搜索，如果当前元素大于 target ，那么当前列以及右边的列都不会有 target，--col
         * 如果当前值小于target，那么当前行及前面的行都不会有 target，++row
         */
        int row = 0, col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                --col;
            } else {
                ++row;
            }
        }
        return false;
    }
}
