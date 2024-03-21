package org.ginwithouta.leetcode.spring100;

/**
 * @author Ginwithouta
 * Generate at 2024/3/21
 * LeetCode 春招 100 去除重复字母
 */
public class LeetCode_Spring_008_RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        /*
         * 利用一个单调栈，栈中的元素非递减，保证字典序最小。此外，当需要移除栈中元素时，需要判断
         * 移除的元素是否还有剩余，如果没有则不能移除。如果当前遍历到的元素已经在栈中存在，则跳过
         */
        int[] vis = new int[26], num = new int[26];
        char[] strs = s.toCharArray();
        for (char str : strs) {
            ++num[str - 'a'];
        }
        StringBuilder sb = new StringBuilder();
        for (char str : strs) {
            if (vis[str - 'a'] == 0) {
                while (!sb.isEmpty() && sb.charAt(sb.length() - 1) > str) {
                    if (num[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                        vis[sb.charAt(sb.length() - 1) - 'a'] = 0;
                        sb.deleteCharAt(sb.length() - 1);
                    } else {
                        break;
                    }
                }
                vis[str - 'a'] = 1;
                sb.append(str);
            }
            num[str - 'a'] -= 1;
        }
        return sb.toString();
    }
}
