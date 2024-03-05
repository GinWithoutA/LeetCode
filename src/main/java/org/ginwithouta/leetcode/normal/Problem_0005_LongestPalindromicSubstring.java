package org.ginwithouta.leetcode.normal;

/**
 * @author Ginwithouta
 * Generate at 2023/11/30
 * Problem 最长回文字串
 */
public class Problem_0005_LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        /*
         * 对于求解最长回文字串，可以使用 Manacher 算法，在这个算法中，我们需要几个前置变量：
         *  1）当前位置的字符能够扩充到的最右侧区域的边界 R
         *  2）当前的最右侧区域的边界 R 是由哪一个字符 C 扩充来的
         *  3）每个位置的字符能够扩充出来的回文串半径
         *  4）每个位置的字符能够扩充出来的回文串直径
         * 在具体操作的时候，我们会碰到两种情况：
         *  1）当前的最右侧区域的边界 R 没有包裹住当前位置 i ，此时只能暴力求解，直接判断是不是回文串，没有优化方式
         *  2）当前的最右侧区域的边界 R 包裹住了当前位置 i ，此时需要考虑 i 位置相对于当前 R 的扩充字符 C 的对称位置 i' ，以及对称的左边界 L
         *      1. 如果当前扩充区域的左边界 L 包裹住了 i' ，那么 i 能扩充的区域就是 i' 能扩充的区域（被整个 L 和 R 包裹，并且对称，那么 i 的区域和 i' 应该是相同的）
         *      2. 如果当前扩充区域的左边界 L 没有包裹住 i' ，那么 i 能扩充的区域就是到右边界 R （如果和 i' 相等，那么 R 应该能够在更靠右的位置，而不是包不住）
         *      3. 如果当前扩充区域的左边界 L 刚好包裹住了 i' 能扩充的区域，那么需要判断 R 之后的字符能否组成更长的回文串
         */
        char[] str = helper(s).toCharArray();
        int curCharToR = -1, curR = -1, len = 0, start = 0, end = 0;
        int[] radius = new int[str.length];
        for (int i = 0; i < str.length; ++i) {
            // 先判断一个不用验证的区域，如果当前的 R 没有包裹住 i ，那么回文半径至少是 1
            // 如果包裹住了，那么当前位置到 R 的距离以及对称点 i' 的回文半径中的最小值，是至少不用验证的区域
            radius[i] = curR > i ? Math.min(radius[2 * curCharToR - i], curR - i) : 1;
            while (i + radius[i] < str.length && i - radius[i] >= 0) {
                if (str[i + radius[i]] == str[i - radius[i]]) {
                    ++radius[i];
                } else {
                    break;
                }
            }
            // 如果当前的 R 被推高了，那么更新
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
        StringBuilder sb = new StringBuilder();
        while (start < end) {
            if ('#' != str[start]) {
                sb.append(str[start]);
            }
            ++start;
        }
        return sb.toString();
    }

    /**
     * 将字符串填充上 # 字符
     * @param str 原本字符串
     * @return 填充后的字符串
     */
    public static String helper(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append('#');
        char[] strs = str.toCharArray();
        for (int i = 0; i < str.length(); ++i) {
            sb.append(strs[i]).append('#');
        }
        return sb.toString();
    }
}
