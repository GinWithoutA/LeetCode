package org.ginwithouta.leetcode;

/**
 * @author Ginwithouta
 * Generate at 2023/12/27
 * Problem 有效的字母异位词
 * @link Problem_0049_GroupAnagrams
 */
public class Problem_0242_ValidAnagram {
    public boolean isAnagram(String s, String t) {
        /*
         * 简单题
         */
        if (s.length() != t.length()) return false;
        int[] map = new int[26];
        char[] str = s.toCharArray(), ttr = t.toCharArray();
        for (int i = 0; i < str.length; ++i) {
            ++map[str[i] - 'a'];
            --map[ttr[i] - 'a'];
        }
        for (int i = 0; i < 26; ++i) {
            if (map[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
