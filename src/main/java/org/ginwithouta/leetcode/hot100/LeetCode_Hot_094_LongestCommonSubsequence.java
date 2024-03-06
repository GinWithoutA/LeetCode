package org.ginwithouta.leetcode.hot100;

/**
 * @author Ginwithouta
 * Generate at 2024/3/6
 * LeetCode Hot 100 最长公共子序列
 */
public class LeetCode_Hot_094_LongestCommonSubsequence {
    /**
     * 暴力递归
     */
    public int longestCommonSubsequence(String text1, String text2) {
        char[] left = text1.toCharArray(), right = text2.toCharArray();
        return process(left, right, left.length - 1, right.length - 1);
    }

    public int process(char[] left, char[] right, int leftIdx, int rightIdx) {
        if (leftIdx == 0 && rightIdx == 0) {
            return left[leftIdx] == right[rightIdx] ? 1 : 0;
        }
        if (leftIdx == 0) {
            if (left[leftIdx] == right[rightIdx]) {
                return 1;
            } else {
                return process(left, right, leftIdx, rightIdx - 1);
            }
        } else if (rightIdx == 0) {
            if (left[leftIdx] == right[rightIdx]) {
                return 1;
            } else {
                return process(left, right, leftIdx - 1, rightIdx);
            }
        } else {
            int p1 = process(left, right, leftIdx - 1, rightIdx);
            int p2 = process(left, right, leftIdx, rightIdx - 1);
            int p3 = left[leftIdx] == right[rightIdx] ? 1 + process(left, right, leftIdx - 1, rightIdx - 1) : 0;
            return Math.max(p1, Math.max(p2, p3));
        }
    }

    /**
     * DP
     */
    public int longestCommonSubsequence1(String text1, String text2) {
        char[] left = text1.toCharArray(), right = text2.toCharArray();
        int[][] dp = new int[left.length][right.length];
        dp[0][0] = left[0] == right[0] ? 1 : 0;
        for (int col = 1; col < right.length; ++col) {
            if (left[0] == right[col]) {
                dp[0][col] = 1;
            } else {
                dp[0][col] = dp[0][col - 1];
            }
        }
        for (int row = 1; row < left.length; ++row) {
            if (left[row] == right[0]) {
                dp[row][0] = 1;
            } else {
                dp[row][0] = dp[row - 1][0];
            }
        }
        for (int row = 1; row < left.length; ++row) {
            for (int col = 1; col < right.length; ++col) {
                dp[row][col] = Math.max(dp[row - 1][col], dp[row][col - 1]);
                if (left[row] == right[col]) {
                    dp[row][col] = Math.max(dp[row][col], dp[row -1][col - 1] + 1);
                }
            }
        }
        return dp[left.length - 1][right.length - 1];
    }
}
