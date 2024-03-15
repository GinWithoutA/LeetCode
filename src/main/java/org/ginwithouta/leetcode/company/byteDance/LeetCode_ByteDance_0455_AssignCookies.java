package org.ginwithouta.leetcode.company.byteDance;

import java.util.Arrays;

/**
 * @author Ginwithouta
 * Generate at 2024/3/15
 * LeetCode 字节跳动 分发饼干
 */
public class LeetCode_ByteDance_0455_AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int ans = 0;
        for (int i = 0, j = 0; i < g.length && j < s.length; ) {
            if (g[i] <= s[j]) {
                ++ans;
                ++i;
            }
            ++j;
        }
        return ans;
    }
}
