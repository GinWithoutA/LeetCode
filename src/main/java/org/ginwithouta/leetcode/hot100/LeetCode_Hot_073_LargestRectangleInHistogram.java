package org.ginwithouta.leetcode.hot100;

import java.util.Stack;

/**
 * @author Ginwithouta
 * Generate at 2024/2/25
 * LeetCode Hot 100 柱状图中的最大矩形
 */
public class LeetCode_Hot_073_LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        /*
         * 利用单调栈，我们保证栈里面的元素一定是升序，当出现要进入的元素小于栈顶元素时，我们可以计算栈顶元素的答案，
         * 若弹出后还有剩元素，那么就是当前位置减现在的栈顶位置减1就是当前的答案，循环找到最大的答案即可
         */
        if (heights.length == 1) {
            return heights[0];
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int ans = 0;
        for (int i = 1; i < heights.length; ++i) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                ans = Math.max(ans, heights[stack.pop()] * (stack.isEmpty() ? i : (i - stack.peek() - 1)));
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            ans = Math.max(ans, heights[stack.pop()] * (stack.isEmpty() ? heights.length : (heights.length - stack.peek() - 1)));
        }
        return ans;
    }
}
