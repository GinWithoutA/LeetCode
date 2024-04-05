package org.ginwithouta.leetcode.interview150;

/**
 * @author Ginwithouta
 * Generate at 2024/4/5
 * LeetCode 面试经典 150 赎金信
 */
public class LeetCode_Interview_039_RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] map = new int[26];
        char[] r = ransomNote.toCharArray(), m = magazine.toCharArray();
        for (char c : m) {
            ++map[c - 'a'];
        }
        for (char c : r) {
            if (--map[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
