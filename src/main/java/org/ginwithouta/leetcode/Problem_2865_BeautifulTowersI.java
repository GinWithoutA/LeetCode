package org.ginwithouta.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * @author Ginwithouta
 * Generate at 2024/1/24
 * Problem 美丽塔
 */
public class Problem_2865_BeautifulTowersI {
    /**
     * 暴力解法
     */
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        if (maxHeights.size() == 1) {
            return maxHeights.get(0);
        }
        long ans = 0L;
        for (int i = 0; i < maxHeights.size(); ++i) {
            long cur = maxHeights.get(i);
            int leftMax = maxHeights.get(i), rightMax = leftMax;
            for (int left = i - 1; left >= 0; --left) {
                if (maxHeights.get(left) < leftMax) {
                    leftMax = maxHeights.get(left);
                }
                cur += leftMax;
            }
            for (int right = i + 1; right < maxHeights.size(); ++right) {
                if (maxHeights.get(right) < rightMax) {
                    rightMax = maxHeights.get(right);
                }
                cur += rightMax;
            }
            ans = Math.max(ans, cur);
        }
        return ans;
    }

    /**
     * 单调栈解法
     */
    public long singleStack(List<Integer> maxHeights) {
        /*
         * 首先我们用两个 long 数组用来存放以 i 位置为山峰前驱最大和是多少，以及后继最大和是多少
         * 这一点我们可以使用两个单调栈来处理
         * 1）前驱单调栈：
         *      如果加入元素的时候，单调栈为空，那么说明当前位置之前的所有元素都大于当前元素，是可以取到的
         *      如果不为空，需要从栈顶元素的位置开始，一直到当前位置，然后加上栈顶元素的值，就是 preFix 当前位置的值
         * 2）后继单调栈：
         *      同理：
         */
        long ans = 0L;
        long[] suffix = new long[maxHeights.size()], prefix = new long[maxHeights.size()];
        Deque<Integer> sufStack = new ArrayDeque<>(), preStack = new ArrayDeque<>();
        for (int left = 0; left < prefix.length; ++left) {
            while (!preStack.isEmpty() && maxHeights.get(preStack.peek()) > maxHeights.get(left)) {
                preStack.pop();
            }
            if (preStack.isEmpty()) {
                prefix[left] = (long) (left + 1) * maxHeights.get(left);
            } else {
                prefix[left] = prefix[preStack.peek()] + (long) (left - preStack.peek()) * maxHeights.get(left);
            }
            preStack.push(left);
        }
        for (int right = suffix.length - 1; right >= 0; --right) {
            while (!sufStack.isEmpty() && maxHeights.get(sufStack.peek()) > maxHeights.get(right)) {
                sufStack.pop();
            }
            if (sufStack.isEmpty()) {
                suffix[right] = (long) (suffix.length - right) * maxHeights.get(right);
            } else {
                suffix[right] = suffix[sufStack.peek()] + (long) (sufStack.peek() - right) * maxHeights.get(right);
            }
            sufStack.push(right);
            ans = Math.max(ans, prefix[right] + suffix[right] - maxHeights.get(right));
        }
        return ans;
    }
}
