package org.ginwithouta.leetcode.hot100;

import java.util.Stack;

/**
 * @author Ginwithouta
 * Generate at 2024/2/25
 * LeetCode Hot 100 每日温度
 */
public class LeetCode_Hot_072_DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        int idx = 0;
        while (idx < temperatures.length) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[idx]) {
                ans[stack.peek()] = idx - stack.peek();
                stack.pop();
            }
            stack.push(idx++);
        }
        return ans;
    }
}
