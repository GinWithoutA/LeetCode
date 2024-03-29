package org.ginwithouta.leetcode.interview150;

/**
 * @author Ginwithouta
 * Generate at 2024/3/29
 * LeetCode 面试经典 150 反转字符串中的单词
 */
public class LeetCode_Interview_021_ReverseWordsInAString {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        char[] str = s.toCharArray();
        int idx = str.length - 1;
        while (idx >= 0) {
            while (idx >= 0 && str[idx] == ' ') {
                --idx;
            }
            if (idx < 0) {
                break;
            }
            int cur = idx;
            while (idx >= 0 && str[idx] != ' ') {
                --idx;
            }
            sb.append(s, idx + 1, cur + 1).append(' ');
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
