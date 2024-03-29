package org.ginwithouta.leetcode.interview150;

import java.util.Objects;

/**
 * @author Ginwithouta
 * Generate at 2024/3/29
 * LeetCode 面试经典 150 找出字符串中第一个匹配项的下标
 */
public class LeetCode_Interview_023_FindTheIndexOfTheFirstOccurrenceInAString {
    public int strStr(String haystack, String needle) {
        /*
         * KMP算法关键在于怎么加速匹配的过程。对于模式串的每个位置，我们需要知道一个信息，当前位置前
         * 的相等的最长前缀后缀长度。next数组中每个位置都存放这个信息，因此当在匹配的过程中发现当前位
         * 置的字符没有匹配上，就说明我们需要跳到当前位置前的最长前缀长度的下一个位置进行匹配，也就是
         * next[i]
         */
        if (haystack.length() <= needle.length()) {
            return Objects.equals(haystack, needle) ? 0 : -1;
        }
        char[] hays = haystack.toCharArray(), needs = needle.toCharArray();
        int[] next = getNexts(needs);
        int idx1 = 0, idx2 = 0;
        while (idx1 < hays.length && idx2 < needs.length) {
            if (hays[idx1] == needs[idx2]) {
                ++idx1;
                ++idx2;
            } else if (idx2 != 0){
                idx2 = next[idx2];
            } else {
                ++idx1;
            }
        }
        return idx2 == needle.length() ? idx1 - needs.length : -1;
    }

    public int[] getNexts(char[] needle) {
        /*
         * next数组不需要知道包含最后一个元素位置最长前后缀长度信息，因为当匹配到最后一个元素，我们只需要根据前面的
         * 最长前缀进行跳转就可以，如果匹配成功，就说明整个模式串就已经都匹配完成，结束匹配。
         */
        int[] next = new int[needle.length];
        next[0] = -1;
        // next[0]前方没有元素，所有匹配串长度 -1，next[1]前方有元素，但是不能和自身相同，所以长度为0
        // curMatch表示当前等待被匹配的最长前缀的后一个位置，一开始肯定是0和1位置匹配，所以是0
        int curIdx = 2, curMatch = 0;
        while (curIdx < needle.length) {
            if (needle[curIdx - 1] == needle[curMatch]) {
                next[curIdx++] = ++curMatch;
            } else if (curMatch > 0) {
                curMatch = next[curMatch];
            } else {
                ++curIdx;
            }
        }
        return next;
    }
}
