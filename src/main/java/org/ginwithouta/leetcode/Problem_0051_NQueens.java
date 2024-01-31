package org.ginwithouta.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ginwithouta
 * Generate at 2024/1/31
 * Problem N皇后
 */
public class Problem_0051_NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        int[] records = new int[n];
        process(n, 0, records, ans);
        return ans;
    }
    public void process(int n, int row, int[] records, List<List<String>> ans) {
        /*
         * 如何判断共线，只要 x_1 - x_2 == y_1 - y_2 那么就是共线
         */
        if (row == n) {
            List<String> res = new ArrayList<>();
            for (Integer idx : records) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < n; ++i) {
                    if (i == idx) {
                        sb.append('Q');
                    } else {
                        sb.append('.');
                    }
                }
                res.add(sb.toString());
            }
            ans.add(res);
            return;
        }
        for (int i = 0; i < n; ++i) {
            if (isValid(records, row, i)) {
                records[row] = i;
                process(n, row + 1, records, ans);
            }
        }

    }
    public boolean isValid(int[] records, int row, int col) {
        for (int pre = 0; pre < row; ++pre) {
            if (records[pre] == col || (Math.abs(row - pre) == Math.abs(col - records[pre]))) {
                return false;
            }
        }
        return true;
    }
}
