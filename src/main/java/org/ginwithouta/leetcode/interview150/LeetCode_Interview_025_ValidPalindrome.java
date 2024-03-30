package org.ginwithouta.leetcode.interview150;

/**
 * @author Ginwithouta
 * Generate at 2024/3/30
 * LeetCode 面试经典 150 验证回文串
 */
public class LeetCode_Interview_025_ValidPalindrome {
    public boolean isPalindrome(String s) {
        char[] str = s.toLowerCase().toCharArray();
        int left = 0, right = str.length - 1;
        while (left < right) {
            while (left < right && isTrue(str[left])) {
                ++left;
            }
            while (left < right && isTrue(str[right])) {
                --right;
            }
            if (left >= right) {
                return true;
            }
            if (str[left++] != str[right--]) {
                return false;
            }
        }
        return true;
    }

    public boolean isTrue(char c) {
        return (c < '0' || c > '9') && (c < 'a' || c > 'z');
    }

}
