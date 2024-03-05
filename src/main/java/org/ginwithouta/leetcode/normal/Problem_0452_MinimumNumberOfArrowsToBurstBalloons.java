package org.ginwithouta.leetcode.normal;

import org.ginwithouta.leetcode.common.IntervalInfo;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Ginwithouta
 * Generate at 2024/1/5
 * Problem 用最少数量的箭引爆气球
 */
public class Problem_0452_MinimumNumberOfArrowsToBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        /*
         * 这题其实是找最小公共子区间
         *
         * 不过我们换个思路可以这样想，根据题目描述，我们根据区间结束位置进行升序排序，排序后的所有区间中，
         * 只要开始位置小于第一个区间的结束位置，那么只使用一只箭就可以打破。接着再往又比遍历，直到所有的
         * 区间都被击穿
         */
        if (points.length == 1) return 1;
        Arrays.sort(points, Comparator.comparingInt(item -> item[1]));
        int ans = 1, right = points[0][1];
        for (int i = 1; i < points.length; ++i) {
            if (points[i][0] <= right) {
                continue;
            }
            right = points[i][1];
            ++ans;
        }
        return ans;
    }
}
