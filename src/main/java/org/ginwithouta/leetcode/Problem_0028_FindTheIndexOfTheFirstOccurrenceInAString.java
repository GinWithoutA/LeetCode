package org.ginwithouta.leetcode;

import java.util.Objects;

/**
 * @author Ginwithouta
 * Generate at 2023/12/7
 * Problem 找出字符串中第一个匹配串的下标
 */
public class Problem_0028_FindTheIndexOfTheFirstOccurrenceInAString {
    public int strStr(String haystack, String needle) {
        /*
         * KMP 算法
         * 我们需要一个 next 数组，这个数组描述了匹配串当前位置前面，最长相等的前缀串和后缀串的长度
         * 在我们匹配的过程中，每当出现一个不相等的字符，我们就去找 next 数组当前位置的值，就是我们
         * 下一步要跳的位置，这一点实质是说我们找到相等的前缀串，然后从这个串的下一个位置继续开始匹配
         */
        if (haystack.length() < needle.length()) {
            return -1;
        }
        if (haystack.length() == needle.length()) {
            return Objects.equals(haystack, needle) ? 0 : -1;
        }
        char[] hays = haystack.toCharArray(), nees = needle.toCharArray();
        int[] next = getNexts(nees);
        int index1 = 0, index2 = 0;
        while (index1 < hays.length && index2 < nees.length) {
            if (hays[index1] == nees[index2]) {
                ++index1;
                ++index2;
            } else if (next[index2] == -1) {
                ++index1;
            } else {
                index2 = next[index2];
            }
        }
        // 出来的时候发现 index2 越界，说明匹配串成功匹配
        return index2 == nees.length ? index1 - index2 : -1;
    }

    /**
     * 求解 next 数组，数组中的每个值表示当前位置之前，相等的最长的前缀串和后缀串的长度
     */
    public int[] getNexts(char[] strs) {
        if (strs.length == 1) {
            return new int[] {-1};
        }
        int[] next = new int[strs.length];
        next[0] = -1;
        // 当前来到 curIndex 位置，curIndex - 1 位置的字符要和 cn 位置的字符进行比较
        int curIndex = 2, cn = 0;
        while (curIndex < strs.length) {
            if (strs[curIndex - 1] == strs[cn]) {
                // 若此时匹配成功了，那么当前位置要返回的位置就是 cn + 1 的位置，返回到主函数中，如果当前位置出现了不相等的情况，
                // 就需要跳到 cn + 1 的位置去进行比较，由于下一个位置也是去比较 cn + 1 ，所以直接 ++cn
                next[curIndex++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[curIndex++] = 0;
            }
        }
        return next;
    }
}
