package org.ginwithouta.leetcode.hot100;

/**
 * @author Ginwithouta
 * Generate at 2024/2/20
 * LeetCode Hot 100 旋转图像
 */
public class LeetCode_Hot_0048_RotateImage {
    public void rotate(int[][] matrix) {
        int top = 0, bot = matrix.length - 1;
        while (top < bot) {
            swap(matrix, top, bot);
            ++top;
            --bot;
        }
    }

    public void swap(int[][] matrix, int top, int bot) {
        for (int i = 0; i < bot - top; ++i) {
            int temp = matrix[top][top + i];
            matrix[top][top + i] = matrix[bot - i][top];
            matrix[bot - i][top] = matrix[bot][bot - i];
            matrix[bot][bot - i] = matrix[top + i][bot];
            matrix[top + i][bot] = temp;
        }
    }
}
