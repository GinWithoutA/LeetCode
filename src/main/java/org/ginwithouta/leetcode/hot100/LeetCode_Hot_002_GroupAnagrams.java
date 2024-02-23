package org.ginwithouta.leetcode.hot100;

import java.util.*;

/**
 * @author Ginwithouta
 * Generate at 2024/2/16
 * LeetCode Hot 100 字母异位词分组
 */
public class LeetCode_Hot_002_GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
