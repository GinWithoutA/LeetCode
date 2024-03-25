package org.ginwithouta.leetcode.spring100;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Ginwithouta
 * Generate at 2024/3/25
 * LeetCode 春招 100 最近的请求次数
 */
public class LeetCode_Spring_012_NumberOfRecentCalls {
    public static class RecentCounter {
        public Deque<Integer> queue;
        public RecentCounter() {
            this.queue = new ArrayDeque<>();
        }

        public int ping(int t) {
            this.queue.offerLast(t);
            while (!queue.isEmpty() && queue.peekFirst() < t - 3000) {
                queue.pollFirst();
            }
            return this.queue.size();
        }
    }
}
