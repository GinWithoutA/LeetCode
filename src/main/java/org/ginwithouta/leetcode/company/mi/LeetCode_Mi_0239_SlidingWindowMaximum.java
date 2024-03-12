package org.ginwithouta.leetcode.company.mi;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Ginwithouta
 * Generate at 2024/3/12
 * LeetCode 小米 滑动窗口最大值
 */
public class LeetCode_Mi_0239_SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        Deque<Integer> queue = new ArrayDeque<>();
        for (int right = 0, idx = 0; right < nums.length; ++right) {
            while (!queue.isEmpty() && nums[right] >= nums[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.offerLast(right);
            if (queue.peekFirst() == right - k) {
                queue.pollFirst();
            }
            if (right >= k - 1) {
                ans[idx++] = nums[queue.peekFirst()];
            }
        }
        return ans;
    }
}
