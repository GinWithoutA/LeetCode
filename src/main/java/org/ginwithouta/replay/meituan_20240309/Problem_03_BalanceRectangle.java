package org.ginwithouta.replay.meituan_20240309;

/**
 * @author Ginwithouta
 * Generate at 2024/3/9
 * 美团 春招 20240309 复盘 完美矩阵
 */
public class Problem_03_BalanceRectangle {
    /**
     * 给定一个n*n的矩阵，里面的值不是0就是1。当一个区域内（i*i,i>=1&&i<=n）的0和1的个数相同的时候，我们称
     * 这个矩阵是完美的。从i为1开始，一直到n，求每一个i的完美矩阵数量
     */
    public int[] solve(int[][] matrix) {
        /*
         * 解题思路，二维前缀和搞定，要小心二维前缀和每个元素的计算以及求完美矩阵的数量
         */
        int[][] prefix = new int[matrix.length][matrix.length];
        prefix[0][0] = matrix[0][0];
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix.length; ++j) {
                prefix[i][j] = (matrix[i][j] == 0 ? -1 : matrix[i][j])
                        + (i == 0 ? 0 : prefix[i - 1][j])
                        + (j == 0 ? 0 : prefix[i][j - 1])
                        - (i > 0 && j > 0 ? prefix[i - 1][j - 1] : 0);
            }
        }
        int[] ans = new int[matrix.length];
        for (int i = 1; i <= matrix.length; ++i) {
            if (((i * i) & 1) == 1) {
                ans[i - 1] = 0;
            } else {
                ans[i - 1] = find(prefix, i);
            }
        }
        return ans;
    }

    public int find(int[][] prefix, int size) {
        int ans = 0;
        for (int row = size - 1; row < prefix.length; ++row) {
            for (int col = size - 1; col < prefix.length; ++col) {
                int sum = prefix[row][col]
                        - (row >= size ? prefix[row - size][col] : 0)
                        - (col >= size ? prefix[row][col - size] : 0)
                        + (row >= size && col >= size ? prefix[row - size][col - size] : 0);
                if (sum == 0) {
                    ++ans;
                }
            }
        }
        return ans;
    }
}
