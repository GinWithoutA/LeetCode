package org.ginwithouta.leetcode.interview150;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ginwithouta
 * Generate at 2024/3/29
 * LeetCode 面试经典 150 文本左右对齐
 */
public class LeetCode_Interview_024_TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int left = 0, right = 0, curWidth = 0;
        List<String> ans = new ArrayList<>();
        while (right < words.length) {
            curWidth += words[right].length() + 1;
            // 这行保证了至少传递一个单词进去
            if (right + 1 == words.length || curWidth + words[right + 1].length() > maxWidth) {
                ans.add(generateLine(words, left, right, maxWidth, right + 1 == words.length ? 1 : 0));
                left = right + 1;
                curWidth = 0;
            }
            ++right;
        }
        return ans;
    }
    private String generateLine(String[] words, int left, int right, int maxWidth, int lastLine) {
        int wordCount = right - left + 1;
        int blankCount = maxWidth - wordCount + 1;
        for (int i = left; i <= right; ++i) {
            blankCount -= words[i].length();
        }
        int blankAvg = wordCount == 1 ? 1 : blankCount / (wordCount - 1);
        int blankExtra = wordCount == 1 ? 0 : blankCount % (wordCount - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = left; i < right; ++i) {
            sb.append(words[i]);
            if (lastLine == 1) {
                sb.append(' ');
                continue;
            }
            int curBlank = 1 + blankAvg + (((i - left) < blankExtra) ? 1 : 0);
            while (curBlank-- > 0) {
                sb.append(' ');
            }
        }
        sb.append(words[right]);
        int remainBlank = maxWidth - sb.length();
        while (remainBlank-- > 0) {
            sb.append(' ');
        }
        return sb.toString();
    }
}
