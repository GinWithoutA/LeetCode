package org.ginwithouta.leetcode.hot100;

/**
 * @author Ginwithouta
 * Generate at 2024/2/24
 * LeetCode Hot 100 搜索二维矩阵
 */
public class LeetCode_Hot_064_SearchA2dMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 1 && matrix[0].length == 1) {
            return target == matrix[0][0];
        }
        int top = 0, bot = matrix.length - 1, left = 0, right = matrix[0].length - 1, mid;
        while (top <= bot) {
            mid = (top + bot) / 2;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] > target) {
                bot = mid - 1;
            } else {
                top = mid + 1;
            }
        }
        if (bot < 0) {
            return false;
        }
        while (left <= right) {
            mid = (left + right) / 2;
            if (matrix[bot][mid] == target) {
                return true;
            } else if (matrix[bot][mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
