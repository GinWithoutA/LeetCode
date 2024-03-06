package org.ginwithouta.leetcode.hot100;

/**
 * @author Ginwithouta
 * Generate at 2024/3/6
 * LeetCode Hot 100 最长回文字串
 */
public class LeetCode_Hot_093_LongestPalindromicSubstring {
    /**
     * Manacher算法
     */
    public String longestPalindrome(String s) {
        char[] str = this.helper(s);
        int curCharToR = -1, curR = -1, len = 0, start = 0, end = 0;
        int[] radius = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            radius[i] = curR > i ? Math.min(radius[2 * curCharToR - i], curR - i) : 1;
            while (i + radius[i] < str.length && i - radius[i] > -1) {
                if (str[i + radius[i]] == str[i - radius[i]]) {
                    radius[i]++;
                } else {
                    break;
                }
            }
            if (i + radius[i] > curR) {
                curR = i + radius[i];
                curCharToR = i;
            }
            if (radius[i] > len) {
                start = i - radius[i] + 1;
                end = i + radius[i];
                len = radius[i];
            }
        }
        System.out.println(start + "\t" + end);
        StringBuilder sb = new StringBuilder();
        while (start < end) {
            if ('*' != str[start]) {
                sb.append(str[start]);
            }
            start++;
        }
        return sb.toString();
    }
    public char[] helper(String s) {
        StringBuilder sb = new StringBuilder();
        char[] strs = s.toCharArray();
        for (int i = 0; i < strs.length - 1; ++i) {
            sb.append(strs[i]).append('*');
        }
        sb.append(strs[strs.length - 1]);
        return sb.toString().toCharArray();
    }
}
