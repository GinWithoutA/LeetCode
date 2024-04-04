package org.ginwithouta.leetcode.interview150;

import java.util.Arrays;

/**
 * @author Ginwithouta
 * Generate at 2024/4/4
 * LeetCode 面试经典 150 无重复字符的最长字串
 */
public class LeetCode_Interview_031_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int[] map = new int[256];
        Arrays.fill(map, -1);
        char[] str = s.toCharArray();
        int left = 0, right = 0, ans = 1;
        while (right < str.length) {
            left = map[str[right]] != -1 ? Math.max(map[str[right]] + 1, left) : left;
            ans = Math.max(ans, right - left + 1);
            map[str[right]] = right++;
        }
        return Math.max(ans, right - left);
    }
}
