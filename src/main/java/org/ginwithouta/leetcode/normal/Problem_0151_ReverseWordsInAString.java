package org.ginwithouta.leetcode.normal;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author Ginwithouta
 * Generate at 2023/12/7
 * Problem 反转字符串中的单词
 */
public class Problem_0151_ReverseWordsInAString {
    public String reverseWords(String s) {
        String[] strs = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; --i) {
            if (!Objects.equals(strs[i], "")) {
                sb.append(strs[i]).append(i == 0 ? "" : " ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("  hello world ".split(" ").length);
    }
}
