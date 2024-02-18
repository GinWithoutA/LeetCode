package org.ginwithouta.leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ginwithouta
 * Generate at 2024/2/17
 * LeetCode Hot 100 找到字符串中所有字母异位词
 */
public class LeetCode_Hot_0438_FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        /*
         * 整体的思路就是，右边不断前进，同时提供缺失的字符。每次前进，只要左边发现当前字符已经超出了需要提供的数量，
         * 那么说明当前字符是没用的，就将左边前进。当窗口长度是 p 的长度的时候，说明找到了一个位置
         */
        if (s.length() < p.length()) {
            return new ArrayList<>();
        }
        char[] strs = s.toCharArray(), ptrs = p.toCharArray();
        List<Integer> ans = new ArrayList<>();
        int[] count = new int[26];
        int left = 0;
        for (char ptr : ptrs) {
            --count[ptr - 'a'];
        }
        // 如果新加入的字符不能满足要求，说明前面有多余的，要走到多余的字符的后一个
        for (int right = 0; right < strs.length; ++right) {
            ++count[strs[right] - 'a'];
            while (count[strs[right] - 'a'] > 0) {
                --count[strs[left] - 'a'];
                ++left;
            }
            if (right - left + 1 == ptrs.length) {
                ans.add(left);
            }
        }
        return ans;
    }
}
