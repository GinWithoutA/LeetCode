package org.ginwithouta.leetcode.spring100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ginwithouta
 * Generate at 2024/3/18
 * LeetCode 春招 100 螺旋组帧
 */
public class LeetCode_Spring_001_SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
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
            return;
        }
        if (topCol == botCol) {
            while (topRow <= botRow) {
                ans.add(matrix[topRow++][topCol]);
            }
            return;
        }
        int topColTemp = topCol, topRowTemp = topRow;
        while (topCol < botCol) {
            ans.add(matrix[topRow][topCol++]);
        }
        while (topRow < botRow) {
            ans.add(matrix[topRow++][topCol]);
        }
        while (botCol > topColTemp) {
            ans.add(matrix[botRow][botCol--]);
        }
        while (botRow > topRowTemp) {
            ans.add(matrix[botRow--][topColTemp]);
        }
    }

}
