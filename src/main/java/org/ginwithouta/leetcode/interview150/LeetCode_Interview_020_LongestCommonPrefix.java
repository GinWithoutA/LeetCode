package org.ginwithouta.leetcode.interview150;

/**
 * @author Ginwithouta
 * Generate at 2024/3/29
 * LeetCode 面试经典 150 最长公共前缀
 */
public class LeetCode_Interview_020_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs[0].isEmpty()) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        int flag = 1, idx = 0;
        while (idx < strs[0].length()) {
            for (int i = 1; i < strs.length; ++i) {
                if (idx >= strs[i].length() || strs[0].charAt(idx) != strs[i].charAt(idx)) {
                    flag = 0;
                    break;
                }
            }
            if (flag == 0) {
                if (idx == 0) {
                    return "";
                } else {
                    return strs[0].substring(0, idx);
                }
            } else {
                ++idx;
            }
        }
        return strs[0].substring(0, idx);
    }
}
