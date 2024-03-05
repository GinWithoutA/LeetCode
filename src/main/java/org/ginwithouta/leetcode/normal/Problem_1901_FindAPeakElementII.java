package org.ginwithouta.leetcode.normal;

/**
 * @author Ginwithouta
 * Generate at 2023/12/19
 * Problem 寻找峰值Ⅱ
 * @link Problem_0162_FindPeakElement
 */
public class Problem_1901_FindAPeakElementII {
    public int[] findPeakGrid(int[][] mat) {
        /*
         * 这道题是二维的寻找峰值，我们可以将其拆分为多个一维的寻找峰值组合而成，首先我们要明确，由于所有元素都不同，每一行，每一列都存在其自己的峰值
         * 当我们找到第 i 列的峰值，利用二分法，我们可以判断其左右元素哪一个比它大，然后下一步跳转到较大值的列上。由于当前值大于上一列的峰值，则表明
         * 当前列的峰值一定大于上一列的所有值，也就是此时我们可以保证当前列的峰值大于上下左/右的值。不断二分，直到找到一个值大于左边也大于右边
         * 同理，利用行来做二分也是一样的
         */
        if (mat.length == 1 && mat[0].length == 1) {
            return new int[] {0, 0};
        }
        int left = 0, right = mat[0].length;
        while (left <= right) {
            int mid = (left + right) / 2, maxRow = -1, max = 0;
            for (int i = 0; i < mat.length; ++i) {
                if (mat[i][mid] > max) {
                    maxRow = i;
                    max = mat[i][mid];
                }
            }
            if (mid - 1 >= 0 && mat[maxRow][mid - 1] > max) {
                right = mid - 1;
                continue;
            }
            if (mid + 1 < mat[0].length && mat[maxRow][mid + 1] > max) {
                left = mid + 1;
                continue;
            }
            return new int[] {maxRow, mid};
        }
        return null;
    }
}
