package org.ginwithouta.leetcode;

import java.util.Arrays;

/**
 * @author Ginwithouta
 * Generate at 2023/11/19
 * Problem: 分发饼干问题：两个数组，一个是孩子想要的饼干大小，一个是饼干大小的数组，每个饼干只能用一次，求能够满足的孩子数量
 */
public class Problem_0455_AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        /*
         * 对两个数组进行排序，然后遍历，看饼干能够满足多少个孩子的需求就行
         */
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        for (int i = 0, j = 0; i < g.length && j < s.length;) {
            if (g[i] <= s[j]) {
                ++count;
                ++i;
                ++j;
            } else {
                ++j;
            }
        }
        return count;
    }
}
