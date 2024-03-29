package org.ginwithouta.leetcode.interview150;

/**
 * @author Ginwithouta
 * Generate at 2024/3/29
 * LeetCode 面试经典 150 最后一个单词的长度
 */
public class LeetCode_Interview_019_LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int ans = 0, idx = s.length() - 1;
        while (idx >= 0 && s.charAt(idx) == ' ') {
            --idx;
        }
        while (idx >= 0 && s.charAt(idx) != ' ') {
            ++ans;
            --idx;
        }
        return ans;
    }
}
