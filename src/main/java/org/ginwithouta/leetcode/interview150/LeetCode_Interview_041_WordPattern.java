package org.ginwithouta.leetcode.interview150;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Ginwithouta
 * Generate at 2024/4/5
 * LeetCode 面试经典 150 单词规律
 */
public class LeetCode_Interview_041_WordPattern {
    public boolean wordPattern(String pattern, String s) {
        char[] pat = pattern.toCharArray();
        String[] strs = s.trim().split(" ");
        if (strs.length != pat.length) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < pat.length; ++i) {
            if (map.containsKey(pat[i])) {
                if (!Objects.equals(map.get(pat[i]), strs[i])) {
                    return false;
                }
            } else if (map.containsValue(strs[i])) {
                return false;
            } else {
                map.put(pat[i], strs[i]);
            }
        }
        return true;
    }
}
