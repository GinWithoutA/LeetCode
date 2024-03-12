package org.ginwithouta.leetcode.company.mi;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Ginwithouta
 * Generate at 2024/3/12
 * LeetCode 小米 无重复字符的最长字串
 */
public class LeetCode_Mi_0003_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] strs = s.toCharArray();
        int max = 0, left = 0, right = 0;
        while (right < strs.length) {
            if (map.containsKey(strs[right])) {
                max = Math.max(max,  right - left);
                left = Math.max(left, map.get(strs[right]) + 1);
            }
            map.put(strs[right], right++);
        }
        return Math.max(max, right - left);
    }

    public int lengthOfLongestSubstring1(String s) {
        /*
         * 用一个 map 表记录每个元素之前出现的位置，用一个 pre 记录之前出现的位置，pre 只能一直向后更新
         */
        int[] map = new int[256];
        Arrays.fill(map, -1);
        char[] strs = s.toCharArray();
        int pre = -1, cur, len = 0;
        for (int i = 0; i < strs.length; ++i) {
            pre = Math.max(pre, map[strs[i]]);
            cur = i - pre;
            len = Math.max(len, cur);
            map[strs[i]] = i;
        }
        return len;
    }
}
