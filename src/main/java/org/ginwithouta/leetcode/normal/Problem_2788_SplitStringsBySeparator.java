package org.ginwithouta.leetcode.normal;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ginwithouta
 * Generate at 2024/1/20
 * Problem 按分隔符拆分字符串
 */
public class Problem_2788_SplitStringsBySeparator {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        /*
         * 遍历每个字符，只要没有遍历到分隔符，就将当前字符加入到 stringBuilder 中
         */
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            char[] strs = word.toCharArray();
            for (char str : strs) {
                if (str == separator) {
                    if (!sb.isEmpty()) {
                        ans.add(sb.toString());
                        sb.setLength(0);
                    }
                } else {
                    sb.append(str);
                }
            }
            if (!sb.isEmpty()) {
                ans.add(sb.toString());
            }
        }
        return ans;
    }
}
