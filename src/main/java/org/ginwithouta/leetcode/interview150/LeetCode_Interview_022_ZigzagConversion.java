package org.ginwithouta.leetcode.interview150;

import java.util.Arrays;

/**
 * @author Ginwithouta
 * Generate at 2024/3/29
 * LeetCode 面试经典 150 Z字形变换
 */
public class LeetCode_Interview_022_ZigzagConversion {
    public String convert(String s, int numRows) {
        /*
         * 这道题的关键点在于，假设存在numRows个集合，那么所有字符的添加顺序为
         * 1 ~ numRows 再从 numRows ~ 1，如何实现这个来回的过程就是解题的关键
         * 我们可以用一个 flag 表示，当i == 0，flag = -flag，我们让 flag 一直
         * + 1，这样就能实现
         */
        if (numRows == 1) {
            return s;
        }
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < numRows; ++i) {
            sb[i] = new StringBuilder();
        }
        char[] str = s.toCharArray();
        int flag = -1, i = 0;
        for (char c : str) {
            sb[i].append(c);
            if (i == 0 || i == numRows - 1) {
                flag = -flag;
            }
            i += flag;
        }
        for (i = 1; i < sb.length; ++i) {
            sb[0].append(sb[i]);
        }
        return sb[0].toString();
    }
}
