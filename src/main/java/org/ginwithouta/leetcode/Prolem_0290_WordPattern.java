package org.ginwithouta.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Ginwithouta
 * Generate at 2023/12/26
 * Problem 单词规律
 * @link Problem_0205_IsomorphicStrings
 */
public class Prolem_0290_WordPattern {
    public boolean wordPattern(String pattern, String s) {
        /*
         * 有点类似另一题，单词对应，也是双射问题
         */
        Map<String, Character> map = new HashMap<>();
        String[] words = s.split(" ");
        char[] pas = pattern.toCharArray();
        if (pas.length != words.length) {
            return false;
        }
        for (int i = 0; i < words.length; ++i) {
            if (map.containsKey(words[i]) && map.get(words[i]) != pas[i]) {
                // 一个单词对应多个字母
                return false;
            } else if (!map.containsKey(words[i]) && map.containsValue(pas[i])) {
                // 一个字母对应多个单词
                return false;
            } else if (!map.containsKey(words[i])) {
                map.put(words[i], pas[i]);
            }
        }
        return true;
    }
}
