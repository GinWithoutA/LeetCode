package org.ginwithouta.leetcode.spring100;

/**
 * @author Ginwithouta
 * Generate at 2024/3/25
 * LeetCode 春招 100 字符串中的第一个唯一字符
 */
public class LeetCode_Spring_010_FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        int[] map = new int[26];
        char[] str = s.toCharArray();
        for (char c : str) {
            ++map[c - 'a'];
        }
        for (int i = 0; i < str.length; ++i) {
            if (map[str[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
