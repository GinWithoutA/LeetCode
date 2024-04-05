package org.ginwithouta.leetcode.interview150;

/**
 * @author Ginwithouta
 * Generate at 2024/4/5
 * LeetCode 面试经典 150 有效的字母异位词
 */
public class LeetCode_Interview_042_ValidAnagram {
    public boolean isAnagram(String s, String t) {
        char[] str = s.toCharArray(), ttr = t.toCharArray();
        if (str.length != ttr.length) {
            return false;
        }
        int[] map = new int[26];
        for (int i = 0; i < str.length; ++i) {
            ++map[str[i] - 'a'];
            --map[ttr[i] - 'a'];
        }
        for (int count : map) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}
