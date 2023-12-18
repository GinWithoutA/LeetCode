package org.ginwithouta.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ginwithouta
 * Generate at 2023/12/18
 * Problem 螺旋矩阵
 */
public class Problem_0054_SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        /*
         * 总的需要循环的次数就是从 0 行开始，到 matrix.length / 2 行数
         * 同时，也是左上角的元素以及右下角的元素按照对角线的方向走，碰到的位置
         * 为了方便知道每一次遍历的边界在哪里，需要给定四个变量
         */
        List<Integer> ans = new ArrayList<>();
        if (matrix.length == 1 && matrix[0].length == 1) {
            ans.add(matrix[0][0]);
            return ans;
        }
        int topRow = 0, topCol = 0, botRow = matrix.length - 1, botCol = matrix[0].length - 1;
        while (topRow <= botRow && topCol <= botCol) {
            process(matrix, ans, topRow, topCol, botRow, botCol);
            ++topRow;
            ++topCol;
            --botRow;
            --botCol;
        }
        return ans;
    }

    public void process(int[][] matrix, List<Integer> ans, int topRow, int topCol, int botRow, int botCol) {
        if (topRow == botRow) {
            while (topCol <= botCol) {
                ans.add(matrix[topRow][topCol++]);
            }
        } else if (topCol == botCol) {
            while (topRow <= botRow) {
                ans.add(matrix[topRow++][topCol]);
            }
        } else {
            int colBound = topCol, rowBound = topRow;
            while (topCol < botCol) {
                ans.add(matrix[topRow][topCol++]);
            }
            while (topRow < botRow) {
                ans.add(matrix[topRow++][topCol]);
            }
            while (botCol > colBound) {
                ans.add(matrix[botRow][botCol--]);
            }
            while (botRow > rowBound) {
                ans.add(matrix[botRow--][rowBound]);
            }
        }
    }

}
