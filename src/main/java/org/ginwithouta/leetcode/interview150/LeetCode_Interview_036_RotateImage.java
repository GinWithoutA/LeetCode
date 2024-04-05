package org.ginwithouta.leetcode.interview150;

/**
 * @author Ginwithouta
 * Generate at 2024/4/5
 * LeetCode 面试经典 150 旋转图像
 */
public class LeetCode_Interview_036_RotateImage {
    public void rotate(int[][] matrix) {
        int top = 0, bot = matrix.length - 1;
        while (top < bot) {
            for (int i = 0; i < bot - top; ++i) {
                int temp = matrix[top][top + i];
                matrix[top][top + i] = matrix[bot - i][top];
                matrix[bot - i][top] = matrix[bot][bot - i];
                matrix[bot][bot - i] = matrix[top + i][bot];
                matrix[top + i][bot] = temp;
            }
            ++top;
            --bot;
        }
    }
}
