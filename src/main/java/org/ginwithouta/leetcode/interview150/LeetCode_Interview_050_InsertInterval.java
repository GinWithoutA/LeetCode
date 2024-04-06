package org.ginwithouta.leetcode.interview150;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ginwithouta
 * Generate at 2024/4/6
 * LeetCode 面试经典 150 插入区间
 */
public class LeetCode_Interview_050_InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        /*
         * 利用新区间的两个值判断需要添加到哪一个位置，同时用一个 placed 变量判断新区见是否加入
         */
        List<int[]> res = new ArrayList<>();
        int left = newInterval[0], right = newInterval[1];
        boolean placed = false;
        for (int[] interval : intervals) {
            if (interval[1] < left) {
                res.add(interval);
            } else if (interval[0] > right) {
                if (!placed) {
                    res.add(new int[] {left, right});
                    placed = true;
                }
                res.add(interval);
            } else {
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }
        if (!placed) {
            res.add(new int[] {left, right});
        }
        int[][] ans = new int[res.size()][2];
        for (int i = 0; i < ans.length; ++i) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}
