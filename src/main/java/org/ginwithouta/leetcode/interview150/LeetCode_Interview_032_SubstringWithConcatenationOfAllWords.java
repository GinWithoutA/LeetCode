package org.ginwithouta.leetcode.interview150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Ginwithouta
 * Generate at 2024/4/4
 * LeetCode 面试经典 150 串联所有单词的字串
 */
public class LeetCode_Interview_032_SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        if (s.isBlank() || words.length == 0 || s.length() < words.length * words[0].length()) {
            return ans;
        }
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        char[] str = s.toCharArray();
        // 由于每个单词的长度都相同，为了获取到每个可能的开始位置，我们只需要在外循环中循环 words[0].length 次就可以
        // 内循环的开头位置就可以为 i, i + words[0].length, ...
        for (int i = 0; i < words[0].length(); ++i) {
            if (i + words.length * words[0].length() > str.length) {
                break;
            }
            int left = i, right = i, count = 0;
            // 如何判断当前窗口是否是合适窗口，首先判断当前加入的单词是否存在，如果不存在，则说明当前形成的窗口不合法，
            // 直接跳过。如果存在，则判断添加后的单词是否符合原始的出现次数，如果符合，判断当前存在的单词数量和 words
            // 中的单词数量是否相等
            HashMap<String, Integer> tempMap = new HashMap<>();
            while (right + words[0].length() <= str.length) {
                String curWord = s.substring(right, right + words[0].length());
                right += words[0].length();
                if (!map.containsKey(curWord)) {
                    count = 0;
                    left = right;
                    tempMap.clear();
                    continue;
                }
                tempMap.put(curWord, tempMap.getOrDefault(curWord, 0) + 1);
                ++count;
                while (tempMap.getOrDefault(curWord, 0) > map.getOrDefault(curWord, 0)) {
                    String delWord = s.substring(left, left + words[0].length());
                    tempMap.put(delWord, tempMap.getOrDefault(delWord, 0) - 1);
                    left += words[0].length();
                    --count;
                }
                if (count == words.length) {
                    ans.add(left);
                }
            }
        }
        return ans;
    }
}
