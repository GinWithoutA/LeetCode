package org.ginwithouta.leetcode.normal;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ginwithouta
 * Generate at 2023/12/8
 * Problem 文本左右对齐
 */
public class Problem_0068_TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        /*
         * 模拟求最终结果
         */
        List<String> res = new ArrayList<>();
        int curLen = 0, startIndex = 0;
        for (int i = 0; i < words.length; ++i) {
            curLen += words[i].length() + 1;
            if (i + 1 == words.length || curLen + words[i + 1].length() > maxWidth) {
                res.add(generateLine(words, startIndex, i, maxWidth, i + 1 == words.length));
                startIndex = i + 1;
                curLen = 0;
            }
        }
        return res;
    }

    public String generateLine(String[] words, int start, int end, int maxWidth, boolean lastLine) {
        int wordCount = end - start + 1;
        // 计算除了本身每个单词间就需要存在的空格，剩余需要多少空格
        int blankCount = maxWidth + 1 - wordCount;
        for (int i = start; i <= end; ++i) {
            blankCount -= words[i].length();
        }
        // 用于计算平均每个位置添加的空格数量，所有位置都需要添加至少这么多空格
        int blankAvg = wordCount == 1 ? 1 : blankCount / (wordCount - 1);
        // 用于计算哪几个位置需要多添加一个空格，当前位置小于 blankExtra 都需要多添加一个空格
        // 这个很好理解，左边的空格要更多，因此需要先把余数给分担掉
        int blankExtra = wordCount == 1 ? 0 : blankCount % (wordCount - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < end; ++i) {
            sb.append(words[i]);
            if (lastLine) {
                sb.append(' ');
                continue;
            }
            int curBlank = 1 + blankAvg + (((i - start) < blankExtra) ? 1 : 0);
            while (curBlank-- > 0) {
                sb.append(' ');
            }
        }
        sb.append(words[end]);
        // 如果不是 lastLine，或者这行不止有一个单词，那么下面的填充剩余空格都不会触发
        int remainBlank = maxWidth - sb.length();
        while (remainBlank-- > 0) {
            sb.append(' ');
        }
        return sb.toString();
    }
}
