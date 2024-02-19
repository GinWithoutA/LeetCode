package org.ginwithouta.leetcode.hot100;

import java.util.Objects;

/**
 * @author Ginwithouta
 * Generate at 2024/2/18
 * LeetCode Hot 100 最小覆盖字串
 */
public class LeetCode_Hot_0076_MinumumWindowSubstring {
    public String minWindow(String s, String t) {
        /*
         * 关键点在于如何控制窗口，我们不断往右移动，同时记录当前匹配到了多少个字符，当所有的字符匹配完成后，
         * 我们再去处理左边窗口包含的多余字符（移动到 map 中的值不是 < 0 的情况就行），此时记录 ans 值
         */
        if (s.length() < t.length()) {
            return "";
        }
        int[] map = new int[256];
        char[] strs = s.toCharArray(), ttrs = t.toCharArray();
        for (char c : ttrs) {
            ++map[c];
        }
        int count = ttrs.length, right = 0, left = 0, ans = -1, ansLeft = 0, ansRight = 0;
        while (right < strs.length) {
            if (--map[strs[right]] >= 0) {
                --count;
                // 匹配完成，移动左边窗口，删除没有用的字符
                if (count == 0) {
                    while (map[strs[left]] < 0) {
                        ++map[strs[left++]];
                    }
                    // 若此时的窗口长度大于之前记录的长度，更新答案
                    if (ans == -1 || right - left + 1 < ans) {
                        ans = right - left + 1;
                        ansLeft = left;
                        ansRight = right;
                    }
                    ++count;
                    ++map[strs[left++]];
                }
            }
            ++right;
        }
        return ans == -1 ? "" : s.substring(ansLeft, ansRight + 1);
    }
}
