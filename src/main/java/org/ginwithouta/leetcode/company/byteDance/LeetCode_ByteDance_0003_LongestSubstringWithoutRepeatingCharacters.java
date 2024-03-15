package org.ginwithouta.leetcode.company.byteDance;

import java.util.Arrays;

/**
 * @author Ginwithouta
 * Generate at 2024/3/15
 * LeetCode 字节跳动 无重复字符的最长字串
 */
public class LeetCode_ByteDance_0003_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[256];
        Arrays.fill(map, -1);
        char[] strs = s.toCharArray();
        int ans = 0, left = 0, right = 0;
        while (right < strs.length) {
            if (map[strs[right]] >= 0) {
                ans = Math.max(ans, right - left);
                left = Math.max(left, map[strs[right]] + 1);
            }
            map[strs[right]] = right++;
        }
        return Math.max(ans, right - left);
    }
}
