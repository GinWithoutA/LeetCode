package org.ginwithouta.leetcode.spring100;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author Ginwithouta
 * Generate at 2024/3/25
 * LeetCode 春招 100 丑数Ⅱ
 */
public class LeetCode_Spring_016_UglyNumberII {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> heap = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        heap.offer(1L);
        set.add(1L);
        int ans = 0;
        int[] factors = new int[] {2, 3, 5};
        while (n-- != 0) {
            long cur = heap.poll();
            ans = (int) cur;
            for (int factor : factors) {
                long next = factor * cur;
                if (set.add(next)) {
                    heap.offer(next);
                }
            }
        }
        return ans;
    }
}
