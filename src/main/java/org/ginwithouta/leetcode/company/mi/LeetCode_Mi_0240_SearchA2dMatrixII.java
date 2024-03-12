package org.ginwithouta.leetcode.company.mi;

/**
 * @author Ginwithouta
 * Generate at 2024/3/12
 * LeetCode 小米 搜索二维矩阵Ⅱ
 */
public class LeetCode_Mi_0240_SearchA2dMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        /*
         * 三种方法
         * 1 直接查找
         * 2 每一行使用二分
         * 3 Z字形查找，我们可以从左下或者右上开始查找，若target小就往一侧移动，相反则往另一侧移动
         */
        int row = 0, col = matrix[0].length - 1;
        while (row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length) {
            if (matrix[row][col] == target) {
                return true;
            }
            if (matrix[row][col] > target) {
                --col;
            } else {
                ++row;
            }
        }
        return false;
    }
}
