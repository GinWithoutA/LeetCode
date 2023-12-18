package org.ginwithouta.leetcode;

/**
 * @author Ginwithouta
 * Generate at 2023/12/18
 * Problem 旋转图像
 */
public class Problem_0048_RotateImage {
    public void rotate(int[][] matrix) {
        /*
         * 和螺旋矩阵类似，也是两个变量，分别从左上角和右下角往对角线中间走，直到碰撞
         * 接着就是针对每一圈，进行 bot - top 次的数值变换
         */
        if (matrix.length == 1) {
            return;
        }
        int top = 0, bot = matrix.length - 1;
        while (top < bot) {
            process(matrix, top, bot);
            ++top;
            --bot;
        }
    }

    public void process(int[][] matrix, int top, int bot) {
        for (int group = 0; group < bot - top; ++group) {
            int temp = matrix[top][top + group];
            matrix[top][top + group] = matrix[bot - group][top];
            matrix[bot - group][top] = matrix[bot][bot - group];
            matrix[bot][bot - group] = matrix[top + group][bot];
            matrix[top + group][bot] = temp;
        }
    }
}
