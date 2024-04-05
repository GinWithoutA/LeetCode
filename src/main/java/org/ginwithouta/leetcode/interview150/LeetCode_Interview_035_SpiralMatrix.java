package org.ginwithouta.leetcode.interview150;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ginwithouta
 * Generate at 2024/4/5
 * LeetCode 面试经典 150 螺旋矩阵
 */
public class LeetCode_Interview_035_SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int topRow = 0, topCol = 0, botRow = matrix.length - 1, botCol = matrix[0].length - 1;
        while (topRow <= botRow && topCol <= botCol) {
            process(matrix, ans, topRow++, topCol++, botRow--, botCol--);
        }
        return ans;
    }
    private void process(int[][] matrix, List<Integer> ans, int topRow, int topCol, int botRow, int botCol) {
        if (topRow == botRow) {
            while (topCol <= botCol) {
                ans.add(matrix[topRow][topCol++]);
            }
            return;
        }
        if (topCol == botCol) {
            while (topRow <= botRow) {
                ans.add(matrix[topRow++][topCol]);
            }
            return;
        }
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
