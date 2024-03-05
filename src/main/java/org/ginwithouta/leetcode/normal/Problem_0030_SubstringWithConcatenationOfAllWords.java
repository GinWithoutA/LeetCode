package org.ginwithouta.leetcode.normal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ginwithouta
 * Generate at 2023/12/15
 * Problem 串联所有单词的字串
 */
public class Problem_0030_SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        /*
         * 一道滑动窗口的问题
         * 由于每个单词长度相同，我们的思路是以单词长度为步长，向右推进滑动窗口的右边界，利用一个遍历判断当前滑动窗口中合法的单词数量
         * 1）若有边界到达字符串边界，返回
         * 2）若当前滑动出来的单词是词组中不存在的，左边界推进到右边界
         * 3）若当前滑动出来的单词在滑动窗口中出现的次数大于词组中出现的次数，左边界需要跳到该单词上一次出现之后
         * 在经过上面的操作之后，若合法单词数量等于词组数量，说明找到了一个合适的答案
         */
        List<Integer> ans = new ArrayList<>();
        if (s.isBlank() || words.length == 0 || s.length() < words.length * words[0].length()) return ans;
        int strLen = s.length(), wordLen = words[0].length();
        Map<String, Integer> wordsMap = new HashMap<>(words.length);
        for (String word : words) {
            wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
        }
        // 最外层的 for 的范围要注意是从 0 到 wordLen - 1 ，这里是一个难点
        // 原因我们可以理解为由于每个单词长度相同，我们只需要遍历 0 - wordLen 次，就可以找到从
        // 0 - 0 + wordLen - 0 + 2 * wordLen
        // 1 - 1 + wordLen - 1 + 2 * wordLen
        // ...
        // 所有开头的单词，也可以理解为 s.length % wordLen，总的只需要遍历这么多次即可
        for (int i = 0; i < wordLen; ++i) {
            if (i + wordLen * words.length > strLen) break;
            int left = i, right = i, count = 0;
            Map<String, Integer> curMap = new HashMap<>();
            while (right + wordLen <= strLen) {
                String curWord = s.substring(right, right + wordLen);
                right += wordLen;
                // 如果当前分割的单词不存在，可以直接剪枝，说明此次窗口错误，left 直接从该单词后面开始继续进行
                if (!wordsMap.containsKey(curWord)) {
                    count = 0;
                    left = right;
                    curMap.clear();
                    continue;
                }
                // 此时说明单词存在，直接存到 curMap 中，然后 ++
                curMap.put(curWord, curMap.getOrDefault(curWord, 0) + 1);
                ++count;
                // 此时我们需要判断当前窗口中，当前单词出现的次数是否大于给定 words 中该单词出现的次数
                // 如果大于，由于总长度是一样的，说明当前的窗口是不符合的，需要把多余的当前单词包括窗口中
                // 已经包含的单词给弹出去
                while (wordsMap.getOrDefault(curWord, 0) < curMap.getOrDefault(curWord, 0)) {
                    String delWord = s.substring(left, left + wordLen);
                    curMap.put(delWord, curMap.getOrDefault(delWord, 0) - 1);
                    left += wordLen;
                    --count;
                }
                // 执行完所有的操作之后，判断当前的 count 单词数量和 words 是否相等，相等说明找到一个合适的答案
                if (count == words.length) ans.add(left);
            }
        }
        return ans;
    }
}
