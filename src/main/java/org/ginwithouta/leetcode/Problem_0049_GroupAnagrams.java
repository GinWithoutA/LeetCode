package org.ginwithouta.leetcode;

import java.util.*;

/**
 * @author Ginwithouta
 * Generate at 2023/12/27
 * Problem 字母异位词分组
 * @link Problem_0242_ValidAnagram
 */
public class Problem_0049_GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        /*
         * 这道题有点像判断一个单词是否是异位词，关键在于如果是，那么这两个单词里面包含的字母的种类和数量都是一样的
         * 因此可以对每个 str 进行排序，并以此当作一个 map 的 key 来判断哪些单词排序完成之后是相同的
         */
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
