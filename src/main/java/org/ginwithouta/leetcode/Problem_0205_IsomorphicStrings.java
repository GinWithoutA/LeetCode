package org.ginwithouta.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ginwithouta
 * Generate at 2023/12/23
 * Problem 同构字符串
 */
public class Problem_0205_IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        /*
         * 使用一个 Map ，只存在两种情况为 false
         * 1）map 中有 s 当前的字符键并且 s 当前字符和 t 当前字符不等，说明一个字符对应多个字符
         * 2）map 中有 t 当前的字符 value 并且没有 s 当前的字符键，说明多个字符对应一个字符
         */
        Map<Character, Character> map = new HashMap<>();
        char[] str = s.toCharArray(), ttr = t.toCharArray();
        for (int i = 0; i < str.length; ++i) {
            if ((map.containsKey(str[i]) && map.get(str[i]) != ttr[i]) || (!map.containsKey(str[i]) && map.containsValue(ttr[i]))) {
                return false;
            }else if (!map.containsKey(str[i])) {
                map.put(str[i], ttr[i]);
            }
        }
        return true;
    }
}
