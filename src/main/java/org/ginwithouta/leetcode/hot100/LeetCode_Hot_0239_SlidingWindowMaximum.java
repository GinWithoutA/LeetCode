package org.ginwithouta.leetcode.hot100;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Ginwithouta
 * Generate at 2024/2/18
 * LeetCode Hot 100 滑动窗口的最大值
 */
public class LeetCode_Hot_0239_SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        /*
         * 单调栈
         */
        Deque<Integer> queue = new LinkedList<>();
        int[] ans = new int[nums.length - k + 1];
        for (int right = 0, idx = 0; right < nums.length; ++right) {
            while (!queue.isEmpty() && nums[right] >= nums[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.offerLast(right);
            // 当前栈能向左延伸的最长位置是 right - k + 1
            if (right - k == queue.peekFirst()) {
                queue.pollFirst();
            }
            if (right >= k - 1) {
                ans[idx++] = nums[queue.peekFirst()];
            }
        }
        return ans;
    }
}
