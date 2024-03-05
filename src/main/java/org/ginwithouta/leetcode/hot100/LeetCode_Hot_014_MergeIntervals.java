package org.ginwithouta.leetcode.hot100;

import java.util.*;

/**
 * @author Ginwithouta
 * Generate at 2024/2/18
 * LeetCode Hot 100 合并区间
 */
public class LeetCode_Hot_014_MergeIntervals {
    public static class Info {
        public int start;
        public int end;
        public Info(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }
        PriorityQueue<Info> smallHeap = new PriorityQueue<>(Comparator.comparing(item -> item.start));
        List<Info> res = new ArrayList<>();
        for (int[] interval : intervals) {
            smallHeap.add(new Info(interval[0], interval[1]));
        }
        assert smallHeap.peek() != null;
        int start = smallHeap.peek().start, end = smallHeap.peek().end;
        smallHeap.poll();
        while (!smallHeap.isEmpty()) {
            Info cur = smallHeap.poll();
            if (cur.start <= end) {
                end = Math.max(cur.end, end);
            } else {
                res.add(new Info(start, end));
                start = cur.start;
                end = cur.end;
            }
        }
        res.add(new Info(start, end));
        int[][] ans = new int[res.size()][2];
        for (int i = 0; i < ans.length; ++i) {
            ans[i][0] = res.get(i).start;
            ans[i][1] = res.get(i).end;
        }
        return ans;
    }
}
