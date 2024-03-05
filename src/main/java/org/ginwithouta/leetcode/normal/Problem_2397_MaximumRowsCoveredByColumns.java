package org.ginwithouta.leetcode.normal;

/**
 * @author Ginwithouta
 * Generate at 2024/1/4
 */
public class Problem_2397_MaximumRowsCoveredByColumns {
    public int maximumRows(int[][] matrix, int numSelect) {
        /*
         * 由于每一个元素不是 0 就是 1，用一个 mask 数组来表示每一行所代表的数字
         * 接着，由于最大的数字只可能是 12 位，我们可以遍历这 12 位中的所有数字，
         * 如果当前数字的 1 的个数满足 numSelect 并且存在这个数字，那么看这个数字
         * 有多少个，返回个数最多的那个就行了
         */
        int[] mask = new int[matrix.length];
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                mask[i] += matrix[i][j] << (matrix[0].length - j - 1);
            }
        }
        int ans = 0, cur = 0, limit = (1 << matrix[0].length);
        while (++cur < limit) {
            while (cur < limit && Integer.bitCount(cur) != numSelect) {
                ++cur;
            }
            int count = 0;
            for (int num : mask) {
                if ((num & cur) == num) {
                    ++count;
                }
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }
}
