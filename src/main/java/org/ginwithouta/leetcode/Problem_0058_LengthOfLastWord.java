package org.ginwithouta.leetcode;

/**
 * @author Ginwithouta
 * Generate at 2023/12/7
 * Problem 最后一个单词的长度
 */
public class Problem_0058_LengthOfLastWord {
    /**
     * 系统函数调用
     */
    public int lengthOfLastWordSytstem(String s) {
        String[] strs = s.split(" ");
        return strs[strs.length - 1].length();
    }

    /**
     * 更快的做法
     */
    public int lengthOfLastWord(String s) {
        /*
         * 从最后面开始，先找到第一个不是 ' ' 的位置，如果此时位置 -1 ，直接返回 0
         * 然后再往前遍历，直到第一个是 ' ' 或者位置变为 -1
         */
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') {
            --end;
        }
        if (end < 0) {
            return 0;
        }
        int len = 0;
        while (end >= 0 && s.charAt(end) != ' ') {
            ++len;
            --end;
        }
        return len;
    }
}
