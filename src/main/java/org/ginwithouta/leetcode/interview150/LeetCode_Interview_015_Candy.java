package org.ginwithouta.leetcode.interview150;

import java.util.Arrays;

/**
 * @author Ginwithouta
 * Generate at 2024/3/29
 * LeetCode 面试经典 150 分发糖果
 */
public class LeetCode_Interview_015_Candy {
    public int candy(int[] ratings) {
        /*
         * 全局规则可以拆分为两个，分别是左遍历以及右遍历
         */
        int[] ans = new int[ratings.length];
        Arrays.fill(ans, 1);
        for (int i = 1; i < ratings.length; ++i) {
            if (ratings[i] > ratings[i - 1]) {
                ans[i] = ans[i - 1] + 1;
            }
        }
        for (int i = ratings.length - 2; i >= 0; --i) {
            if (ratings[i] > ratings[i + 1] && ans[i] <= ans[i + 1]) {
                ans[i] = ans[i + 1] + 1;
            }
        }
        int totalCandies = 0;
        for (int candy : ans) {
            totalCandies += candy;
        }
        return totalCandies;
    }

}
