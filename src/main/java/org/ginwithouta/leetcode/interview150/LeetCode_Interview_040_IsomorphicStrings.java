package org.ginwithouta.leetcode.interview150;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ginwithouta
 * Generate at 2024/4/5
 * LeetCode 面试经典 150 同构字符串
 */
public class LeetCode_Interview_040_IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        char[] str = s.toCharArray(), ttr = t.toCharArray();
        for (int i = 0; i < str.length; ++i) {
            if (map.containsKey(str[i])) {
                if (map.get(str[i]) != ttr[i]) {
                    return false;
                }
            } else if (map.containsValue(ttr[i])) {
                return false;
            } else {
                map.put(str[i], ttr[i]);
            }
        }
        return true;
    }
}
