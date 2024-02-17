package org.ginwithouta.leetcode.hot100;

import java.util.Arrays;
/**
 * @author Ginwithouta
 * Generate at 2024/2/17
 * 无重复字符的最长字串
 */
public class LeetCode_Hot_0003_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) {
            return s.length();
        }
        char[] strs = s.toCharArray();
        int[] map = new int[256];
        Arrays.fill(map, -1);
        int left = 0, right = 0, len = 1;
        while (right < strs.length) {
            if (map[strs[right]] != -1) {
                len = Math.max(len, right - left);
                left = Math.max(left, map[strs[right]] + 1);
            }
            map[strs[right]] = right++;
        }
        return Math.max(len, right - left);
    }

    /**
     * 解法二，思考的是之前的长度
     */
    public int lengthOfLongestSubstring2(String s) {
        if (s.length() < 2) {
            return s.length();
        }
        char[] strs = s.toCharArray();
        int[] map = new int[256];
        Arrays.fill(map, -1);
        int pre = 0, len = 0;
        for (int i = 0; i < strs.length; ++i) {
            // 之所以和 i - map[str[i]] 比较，是因为 从 0 到 j = i - map[str[i]] 这个位置在之前
            // 遍历到 j 的时候就收集了，没有收集的是 j 到 i 的长度，如果长，则下面的 max 会覆盖，
            // 如果不长，则没有影响
            pre = Math.min(pre + 1, i - map[strs[i]]);
            len = Math.max(len, pre);
            map[strs[i]] = i;
        }
        return len;
    }
}
