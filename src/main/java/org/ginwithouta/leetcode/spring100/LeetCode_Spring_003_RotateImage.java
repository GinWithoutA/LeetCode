package org.ginwithouta.leetcode.spring100;

/**
 * @author Ginwithouta
 * Generate at 2024/3/19
 * LeetCode 春招 100 旋转图像
 */
public class LeetCode_Spring_003_RotateImage {
    public void rotate(int[][] matrix) {
        int top = 0, bot = matrix.length - 1;
        while (top < bot) {
            swap(matrix, top, top++, bot, bot--);
        }
    }
    private void swap(int[][] matrix, int topRow, int topCol, int botRow, int botCol) {
        for (int i = 0; i < botCol - topCol; ++i) {
            int temp = matrix[topRow][topCol + i];
            matrix[topRow][topCol + i] = matrix[botRow - i][topCol];
            matrix[botRow - i][topCol] = matrix[botRow][botCol - i];
            matrix[botRow][botCol - i] = matrix[topRow + i][botCol];
            matrix[topRow + i][botCol] = temp;
        }
    }
}
