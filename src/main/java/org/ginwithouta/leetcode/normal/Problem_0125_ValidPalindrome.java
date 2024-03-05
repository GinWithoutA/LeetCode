package org.ginwithouta.leetcode.normal;

/**
 * @author Ginwithouta
 * Generate at 2023/12/10
 * Problem 验证回文串
 */
public class Problem_0125_ValidPalindrome {
    public static boolean isPalindrome(String s) {
        /*
         * 就是双指针，加非字母和数字的判断就行
         */
        if (s.length() == 1) {
            return true;
        }
        char[] str = s.toLowerCase().toCharArray();
        int left = 0, right = str.length - 1;
        while (left < str.length && right >= 0) {
            if (str[left] == str[right]) {
                ++left;
                --right;
            } else if (!Character.isLowerCase(str[left]) && !Character.isDigit(str[left])) {
                ++left;
            } else if (!Character.isLowerCase(str[right]) && !Character.isDigit(str[right])) {
                --right;
            } else {
                return false;
            }
        }
        return true;
    }
}
