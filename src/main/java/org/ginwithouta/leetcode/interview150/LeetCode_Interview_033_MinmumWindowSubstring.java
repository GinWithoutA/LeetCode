package org.ginwithouta.leetcode.interview150;

/**
 * @author Ginwithouta
 * Generate at 2024/4/4
 * LeetCode 面试经典 150 最小覆盖字串
 */
public class LeetCode_Interview_033_MinmumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        char[] str = s.toCharArray(), ttr = t.toCharArray();
        int[] map = new int[256];
        for (char c : ttr) {
            ++map[c];
        }
        int left = 0, right = 0, count = 0, ans = -1, ansLeft = 0, ansRight = 0;
        while (right < str.length) {
            if (--map[str[right++]] >= 0) {
                ++count;
                if (count == ttr.length) {
                    while (map[str[left]] < 0) {
                        ++map[str[left++]];
                    }
                    if (ans == -1 || right - left < ans) {
                        ans = right - left;
                        ansLeft = left;
                        ansRight = right;
                    }
                    ++map[str[left++]];
                    --count;
                }
            }
        }
        return ans == -1 ? "" : s.substring(ansLeft, ansRight);
    }
}
