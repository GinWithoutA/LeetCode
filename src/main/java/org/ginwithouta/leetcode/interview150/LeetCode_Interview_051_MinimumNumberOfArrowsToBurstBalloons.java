package org.ginwithouta.leetcode.interview150;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Ginwithouta
 * Generate at 2024/4/6
 * LeetCode 面试经典 150 用最少数量的箭引爆气球
 */
public class LeetCode_Interview_051_MinimumNumberOfArrowsToBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 1) {
            return 1;
        }
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        int right = points[0][1], ans = 1;
        for (int i = 1; i < points.length; ++i) {
            if (points[i][0] > right) {
                ++ans;
                right = points[i][1];
            }
        }
        return ans;
    }
}
