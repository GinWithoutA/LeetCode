package org.ginwithouta.leetcode.normal;

/**
 * @author Ginwithouta
 * Generate at 2024/1/31
 * Problem N皇后Ⅱ
 */
public class Problem_0052_NQueensII {
    public int totalNQueens(int n) {
        if (n == 1) return 1;
        if (n < 4) return 0;
        int[] records = new int[n];
        return process(n, 0, records);
    }
    public int process(int n, int index, int[] records) {
        if (index == n) {
            return 1;
        }
        int ways = 0;
        for (int i = 0; i < n; ++i) {
            if (isValid(records, index, i)) {
                records[index] = i;
                ways += process(n, index + 1, records);
            }
        }
        return ways;
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
