package org.ginwithouta.leetcode.normal;

/**
 * @author Ginwithouta
 * Generate at 2024/1/26
 * Problem 回文数
 */
public class Problem_0009_PalindromeNumber {
    public boolean isPalindrome(int x) {
        /*
         * 转换成字符串就很好计算了
         */
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        char[] strs = String.valueOf(x).toCharArray();
        for (int i = 0, j = strs.length - 1; i <= j; ++i, --j) {
            if (strs[i] != strs[j]) {
                return false;
            }
        }
        return true;
    }
}
