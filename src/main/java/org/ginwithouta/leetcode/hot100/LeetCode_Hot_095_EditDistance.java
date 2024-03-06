package org.ginwithouta.leetcode.hot100;

/**
 * @author Ginwithouta
 * Generate at 2024/3/6
 * LeetCode Hot 100
 */
public class LeetCode_Hot_095_EditDistance {
    /**
     * 尝试，暴力递归
     */
    public int minDistance(String word1, String word2) {
        return process(word1.toCharArray(), word2.toCharArray(), 0, 0);
    }
    public int process(char[] left, char[] right, int leftIdx, int rightIdx) {
        /*
         * 首先判断边界条件，当两个指针都到了字符串的末尾位置的时候，此时需要匹配0个字符，0个动作，返回0
         * 当右指针来到了末尾位置，说明至少需要删除后面的所有字符，操作的次数就是左的长度减去左指针
         * 当左指针来到了末尾位置，说明至少需要加上后面的所有字符，操作的次数就是右的长度减去右指针
         * 一般位置的时候，两种情况
         * 当前指针位置字符相等，不做操作，直接后移
         * 当前指针位置不相等，需要进行一次操作：
         * 1：删除字符，左指针后移，右指针不动
         * 2：添加字符，左指针不动，右指针不动
         * 3：替换字符，左指针右指针同时后移
         * 最后选取最小的值返回即可
         */
        if (leftIdx == left.length && rightIdx == right.length) {
            return 0;
        }
        if (rightIdx == right.length) {
            return left.length - leftIdx;
        } else if (leftIdx == left.length) {
            return right.length - rightIdx;
        } else {
            int p1 = 1000, p2 = p1, p3 = p1;
            if (left[leftIdx] == right[rightIdx]) {
                return process(left, right, leftIdx + 1, rightIdx + 1);
            } else {
                // 插入一个字符
                p1 = process(left, right, leftIdx, rightIdx + 1);
                // 删除一个字符
                p2 = process(left, right, leftIdx + 1, rightIdx);
                // 替换一个字符
                p3 = process(left, right, leftIdx + 1, rightIdx + 1);
            }
            return Math.min(Math.min(p1, p2), p3) + 1;
        }
    }

    /**
     * DP
     */
    public int minDistance1(String word1, String word2) {
        char[] left = word1.toCharArray(), right = word2.toCharArray();
        int[][] dp = new int[left.length + 1][right.length + 1];
        for (int leftIdx = 0; leftIdx < left.length; ++leftIdx) {
            dp[leftIdx][right.length] = left.length - leftIdx;
        }
        for (int rightIdx = 0; rightIdx < right.length; ++rightIdx) {
            dp[left.length][rightIdx] = right.length - rightIdx;
        }
        for (int leftIdx = left.length - 1; leftIdx >= 0; --leftIdx) {
            for (int rightIdx = right.length - 1; rightIdx >= 0; --rightIdx) {
                if (left[leftIdx] == right[rightIdx]) {
                    dp[leftIdx][rightIdx] = dp[leftIdx + 1][rightIdx + 1];
                } else {
                    dp[leftIdx][rightIdx] = Math.min(dp[leftIdx][rightIdx + 1], Math.min(dp[leftIdx + 1][rightIdx], dp[leftIdx + 1][rightIdx + 1])) + 1;
                }
            }
        }
        return dp[0][0];
    }
}
