package org.ginwithouta.leetcode.interview150;

import java.util.Arrays;

/**
 * @author Ginwithouta
 * Generate at 2024/3/27
 * LeetCode 面试经典 150 H指数
 */
public class LeetCode_Interview_011_HIndex {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int ans = 0, idx = citations.length - 1;
        while (idx >= 0 && citations[idx] > ans) {
            ++ans;
            --idx;
        }
        return ans;
    }
}
