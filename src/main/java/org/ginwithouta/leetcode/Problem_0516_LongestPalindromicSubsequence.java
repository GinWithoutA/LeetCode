package org.ginwithouta.leetcode;

/**
 * Ginwithouta
 * Generate at 2023/11/18
 * Problem : 最长回文子序列
 */
public class Problem_0516_LongestPalindromicSubsequence {
    /**
     * 暴力递归
     */
    public int longestPalindromeSubseq(String str) {
        /*
         * 最长回文子序列：范围模型问题
         *
         * 由于求取的是子序列的长度，我们可以将暴力递归的含义定义为：从 left 到 right 上的最长回文子序列是多长。那么整个递归就会有四种可能性：
         *  1）回文子序列的开头和结尾既不是 left 也不是 right
         *  2）回文子序列的开头是 left 结尾不是 right
         *  3）回文子序列的开头不是 left 结尾是 right
         *  4）回文子序列的开头是 left 结尾是 right
         */
        if (str == null || str.isEmpty()) {
            return 0;
        }
        return violentProcess(str.toCharArray(), 0, str.length() - 1);
    }

    public static int violentProcess(char[] str, int left, int right) {
        /*
         * Base Case
         *  1）如果只有一个字符，那么最长回文字序列长度是1
         *  2）如果有两个字符，就需要判断是否相等，相等为2，不等为1
         */
        if (left == right) {
            return 1;
        }
        if (left + 1 == right) {
            return str[left] == str[right] ? 2 : 1;
        }
        int p1 = violentProcess(str, left + 1, right - 1);
        int p2 = violentProcess(str, left, right - 1);
        int p3 = violentProcess(str, left + 1, right);
        int p4 = str[left] == str[right] ? (2 + violentProcess(str, left + 1, right - 1)) : 0;
        return Math.max(Math.max(p1, p2), Math.max(p3, p4));
    }

    /**
     * 动态规划
     */
    public static int process(String str) {
        /*
         * 可以发现整个暴力递归中，只有两个可变参数，当 left 和 right 确定了之后，最终的结果就确定了
         * left 的变化范围是 0...N - 1
         * right 的变化范围也是 0...N - 1
         */
        if (str == null || str.isEmpty()) {
            return 0;
        }
        int len = str.length();
        char[] chars = str.toCharArray();
        int[][] dp = new int[len][len];
        dp[len - 1][len - 1] = 1;
        for (int i = 0; i < len - 1; ++i) {
            dp[i][i] = 1;
            dp[i][i + 1] = chars[i] == chars[i + 1] ? 2 : 1;
        }
        for (int left = len - 3; left >= 0; --left) {
            for (int right = left + 2; right < len; ++right) {
                dp[left][right] = Math.max(dp[left + 1][right], Math.max(dp[left + 1][right - 1], dp[left][right - 1]));
                if (chars[left] == chars[right]) {
                    dp[left][right] = Math.max(dp[left][right], 2 + dp[left + 1][right - 1]);
                }
            }
        }
        return dp[0][len - 1];
    }
}
