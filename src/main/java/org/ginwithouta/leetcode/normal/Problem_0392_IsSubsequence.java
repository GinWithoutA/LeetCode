package org.ginwithouta.leetcode.normal;

import java.util.Objects;

/**
 * @author Ginwithouta
 * Generate at 2023/12/10
 * Problem 判断子序列
 */
public class Problem_0392_IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        /*
         * 双指针同时遍历，每次保证 t 的指针都往右边移动，只有相等的时候才一起移动
         */
        if (s.length() > t.length()) {
            return false;
        }
        if (s.length() == t.length()) {
            return Objects.equals(s, t);
        }
        char[] str = s.toCharArray(), ts = t.toCharArray();
        int sIndex = 0, tIndex = 0;
        while (sIndex < s.length() && tIndex < t.length()) {
            if (str[sIndex] == ts[tIndex]) {
                ++sIndex;
            }
            ++tIndex;
        }
        return sIndex == str.length;
    }
}
