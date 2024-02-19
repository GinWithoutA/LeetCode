package org.ginwithouta.leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ginwithouta
 * Generate at 2024/2/19
 * LeetCode Hot 100 螺旋矩阵
 */
public class LeetCode_Hot_0054_SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>(matrix.length * matrix[0].length);
        int topRow = 0, topCol = 0, botRow = matrix.length - 1, botCol = matrix[0].length - 1;
        while (topRow <= botRow && topCol <= botCol) {
            process(matrix, ans, topRow++, topCol++, botRow--, botCol--);
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
            int tempRow = topRow, tempCol = topCol;
            while (topCol < botCol) {
                ans.add(matrix[topRow][topCol++]);
            }
            while (topRow < botRow) {
                ans.add(matrix[topRow++][botCol]);
            }
            while (botCol > tempCol) {
                ans.add(matrix[botRow][botCol--]);
            }
            while (botRow > tempRow) {
                ans.add(matrix[botRow--][tempCol]);
            }
        }
    }
}
