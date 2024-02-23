package org.ginwithouta.leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ginwithouta
 * Generate at 2024/2/23
 * LeetCode Hot 100 N皇后
 */
public class LeetCode_Hot_062_NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        int[] colRecords = new int[n];
        process(ans, colRecords, 0);
        return ans;
    }
    public void process(List<List<String>> ans, int[] colRecords, int idx) {
        if (idx == colRecords.length) {
            List<String> res = new ArrayList<>();
            for (int colRecord : colRecords) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < colRecords.length; ++j) {
                    if (j == colRecord) {
                        sb.append('Q');
                    } else {
                        sb.append('.');
                    }
                }
                res.add(sb.toString());
            }
            ans.add(res);
        }
        for (int col = 0; col < colRecords.length; ++col) {
            if (isValid(colRecords, idx, col)) {
                colRecords[idx] = col;
                process(ans, colRecords, idx + 1);
            }
        }
    }
    public boolean isValid(int[] colRecords, int row, int col) {
        for (int i = 0; i < row; ++i) {
            if (colRecords[i] == col || Math.abs(row - i) == Math.abs(col - colRecords[i])) {
                return false;
            }
        }
        return true;
    }
}
