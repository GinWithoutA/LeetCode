package org.ginwithouta.leetcode.normal;


import java.util.ArrayList;
import java.util.List;

/**
 * @author Ginwithouta
 * Generate at 2024/1/1
 * Problem 插入区间
 */
public class Problem_0057_InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        /*
         * 直接模拟插入就可以
         *
         * 如果当前区间的左大于新区间的右，说明新区间肯定在当前区间的左侧，由于是有序排放，需要判断修区间是否被放入，如果没有就先放入新区见，然后放当前区间
         * 如果当前区间的右小于新区间的左，说明新区间在当前区间的右侧，直接放入当前区间
         */
        int left = newInterval[0], right = newInterval[1];
        List<int[]> ansList = new ArrayList<>();
        boolean placed = false;
        for (int[] interval : intervals) {
            if (interval[0] > right) {
                if (!placed) {
                    ansList.add(new int[] {left, right});
                    placed = true;
                }
                ansList.add(interval);
            } else if (interval[1] < left) {
                ansList.add(interval);
            } else {
                left = Math.min(interval[0], left);
                right = Math.max(interval[1], right);
            }
        }
        if (!placed) {
            ansList.add(new int[] {left, right});
        }
        int[][] ans = new int[ansList.size()][2];
        for (int i = 0; i < ans.length; ++i) {
            ans[i][0] = ansList.get(i)[0];
            ans[i][1] = ansList.get(i)[1];
        }
        return ans;
    }
}
