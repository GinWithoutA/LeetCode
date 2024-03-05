package org.ginwithouta.leetcode.normal;

import java.util.Arrays;

/**
 * @author Ginwithouta
 * Generate at 2023/12/6
 * Problem 分发糖果
 */
public class Problem_0135_Candy {

    public int candy(int[] ratings) {
        /*
         * 这道题要注意两个规则，第一个规则就是从左往右遍历，之后再从右往左遍历，就能得到最终答案
         */
        if (ratings.length == 1) {
            return 1;
        }
        int[] res = new int[ratings.length];
        Arrays.fill(res, 1);
        for (int i = 1; i < res.length; ++i) {
            if (ratings[i] > ratings[i - 1] && res[i] <= res[i - 1]) {
                res[i] = res[i - 1] + 1;
            }
        }
        for (int i = ratings.length - 2; i >= 0; --i) {
            if (ratings[i] > ratings[i + 1] && res[i] <= res[i + 1]) {
                res[i] = res[i + 1] + 1;
            }
        }
        for (int i = 1; i < res.length; ++i) {
            res[0] += res[i];
        }
        return res[0];
    }
}
