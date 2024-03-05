package org.ginwithouta.leetcode.normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Ginwithouta
 * Generate at 2023/12/2
 * Problem 合并重叠的区间
 */
public class Problem_0056_MergeIntervals {

    /**
     * 区间节点类
     */
    public static class Range {
        public int start;
        public int end;
        public Range(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int[][] merge(int[][] intervals) {
        /*
         * 首先利用一个节点类构建所有的区间，按照开始位置从小到达排序，然后遍历看当前区间的 end 是否超过了上一个区间的 end
         * 如果超过，则添加答案，如果没有超过，判断当前 end 是否能被推高
         */
        Range[] range = new Range[intervals.length];
        for (int i = 0; i < range.length; ++i) {
            range[i] = new Range(intervals[i][0], intervals[i][1]);
        }
        Arrays.sort(range, Comparator.comparingInt(o -> o.start));
        List<Range> ans = new ArrayList<>();
        int start = range[0].start, end = range[0].end;
        for (int i = 1; i < range.length; ++i) {
            if (range[i].start > end) {
                Range cur = new Range(start, end);
                ans.add(cur);
                start = range[i].start;
            }
            end = Math.max(range[i].end, end);
        }
        ans.add(new Range(start, end));
        int[][] res = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); ++i) {
            res[i][0] = ans.get(i).start;
            res[i][1] = ans.get(i).end;
        }
        return res;
    }
}
