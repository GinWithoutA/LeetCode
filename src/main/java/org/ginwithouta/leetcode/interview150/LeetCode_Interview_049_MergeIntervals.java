package org.ginwithouta.leetcode.interview150;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Ginwithouta
 * Generate at 2024/4/6
 * LeetCode 面试经典 150 合并区间
 */
public class LeetCode_Interview_049_MergeIntervals {
    public int[][] merge(int[][] intervals) {
        class Info {
            private int start;
            private int end;
            public Info(int start, int end) {
                this.start = start;
                this.end = end;
            }
        }
        PriorityQueue<Info> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.start));
        for (int[] interval : intervals) {
            queue.offer(new Info(interval[0], interval[1]));
        }
        List<Info> res = new ArrayList<>();
        Info cur = queue.poll();
        int start = cur.start, end = cur.end;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            if (cur.start > end) {
                res.add(new Info(start, end));
                start = cur.start;
                end = cur.end;
            } else {
                end = Math.max(end, cur.end);
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
