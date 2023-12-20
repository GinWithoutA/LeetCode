package org.ginwithouta.leetcode;

/**
 * @author Ginwithouta
 * Generate at 2023/12/20
 * Problem 赎金信
 */
public class Problem_0383_RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        /*
         * 直接写就行
         */
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < magazine.length(); ++i) {
            ++count[magazine.charAt(i) - 'a'];
        }
        for (int i = 0; i < ransomNote.length(); ++i) {
            --count[ransomNote.charAt(i) - 'a'];
            if (count[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
