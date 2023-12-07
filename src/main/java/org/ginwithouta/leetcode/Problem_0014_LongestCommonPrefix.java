package org.ginwithouta.leetcode;

/**
 * @author Ginwithouta
 * Generate at 2023/12/7
 * Problem 最长公共前缀
 */
public class Problem_0014_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        /*
         * 我们可以拿第一个字符串当作 base 串，跟后面的字符串比较，看最终能向右推到哪里，取最小值
         * 如果中间有某一个阶段发现推不动，那么就可以之间返回 ""
         */
        if (strs.length == 1) {
            return strs[0];
        }
        char[] base = strs[0].toCharArray();
        int end = base.length;
        for (int i = 1; i < strs.length; ++i) {
            int index = 0;
            char[] cur = strs[i].toCharArray();
            while (index < base.length && index < cur.length && base[index] == cur[index]) {
                ++index;
            }
            end = Math.min(index, end);
            if (end == 0) {
                return "";
            }
        }
        return strs[0].substring(0, end);
    }
}
