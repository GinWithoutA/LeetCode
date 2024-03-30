package org.ginwithouta.leetcode.interview150;

/**
 * @author Ginwithouta
 * Generate at 2024/3/30
 * LeetCode 面试经典 150 判断子序列
 */
public class LeetCode_Interview_026_IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) {
            return false;
        }
        char[] str = s.toCharArray(), ttr = t.toCharArray();
        int i = 0, j = 0;
        while (i < str.length && j < ttr.length) {
            if (str[i] == ttr[j]) {
                ++i;
            }
            ++j;
        }
        return i == str.length;
    }
}
