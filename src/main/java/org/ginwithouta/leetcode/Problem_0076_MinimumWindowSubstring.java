package org.ginwithouta.leetcode;

/**
 * @author Ginwithouta
 * Generate at 2023/12/18
 * Problem 最小覆盖字串
 */
public class Problem_0076_MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        /*
         * 这道题也是一个利用滑动窗口进行求解的问题，整个的思路就是从 0 位置开始，一直往右遍历，直到找到
         * t 中的所有字符，此时左窗口开始缩小，直到碰到 t 中的某个字符，就找到了一个合适的答案。
         * 重置状态，下一次窗口的起始点在上一次窗口的起始点的下一个位置，重复上面的操作，就能找到最小的值
         */
        if (s.length() < t.length()) return "";
        char[] str= s.toCharArray(), ttr = t.toCharArray();
        int[] charCount = new int[256];
        for (char cur : ttr) {
            ++charCount[cur];
        }
        int left = 0, right = 0, count = ttr.length, ans = -1, ansLeft = 0, ansRight = 0;
        while (right < str.length) {
            char cur = str[right];
            // 每碰到一个字符，就减去当前字符的值，如果还 >= 0，说明 t 中存在当前字符
            if (--charCount[cur] >= 0) {
                --count;
                if (count == 0) {
                    // 若 count == 0，说明当前所有的 t 中的字符都存在于滑动窗口中
                    while (charCount[str[left]] < 0) {
                        // 已经遍历过并且不存在的字符，charCount 都是小于 0，因此把左边没用的字符都拿走
                        ++charCount[str[left++]];
                    }
                    if (ans == -1 || right - left + 1 < ans) {
                        ans = right - left + 1;
                        ansLeft = left;
                        ansRight = right;
                    }
                    // 此时的 left 位置的 charCount 是 t 中的某个字符，如果下次还从这个位置开始，那么会找到和这次一样的答案
                    // 一直重复，导致死循环，因此需要从下一个字符开始寻找，并将 charCount 恢复原始
                    ++count;
                    ++charCount[str[left++]];
                }
            }
            ++right;
        }
        return ans == -1 ? "" : s.substring(ansLeft, ansRight + 1);
    }
}
