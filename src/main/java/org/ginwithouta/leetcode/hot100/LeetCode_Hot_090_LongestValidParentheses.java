package org.ginwithouta.leetcode.hot100;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Ginwithouta
 * Generate at 2024/3/5
 * LeetCode Hot 100 最长有效括号
 */
public class LeetCode_Hot_090_LongestValidParentheses {
    public int longestValidParentheses(String s) {
        /*
         * 栈中我们记录一个没有被匹配的最右括号，同时初始化栈的时候加入一个初始字符，
         * 只要碰到右括号，就将当前的栈顶元素弹出。若弹出后栈变空，说明初始的字符也被
         * 弹出，当前括号不匹配，就将当前位置放入栈，如果弹出后栈不为空，就更新len
         */
        char[] strs = s.toCharArray();
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int max = 0;
        for (int i = 0; i < strs.length; ++i) {
            if (strs[i] == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }

    public int longestValidParentheses1(String s) {
        /*
         * dp 方法，我们可以换一种思路，求每个位置的最长序列有多少，(肯定不会有，所有该位置为0，
         * )就需要分类讨论。如果前一个是(，那么就判断i - 2时候有值，有就加，没有就是2。如果前一
         * 个是)，那么就需要判断这个)是否和其他有组合成合法的括号，如果i - dp[i - 1] - 1是(，说
         * 明能够组成一个括号，如果没有，就组不成括号。如果组成了括号，还需要判断组成的括号前一位
         * i - dp[i - 1] - 2是否有合法的括号，再继续相加
         */
        char[] strs = s.toCharArray();
        int[] dp = new int[strs.length];
        int max = 0;
        for (int i = 1; i < strs.length; ++i) {
            if (strs[i] == ')') {
                if (strs[i - 1] == '(') {
                    dp[i] = i - 2 >= 0 ? dp[i - 2] + 2 : 2;
                } else {
                    if (i - dp[i - 1] - 1 >= 0 && strs[i - dp[i - 1] - 1] == '(') {
                        dp[i] = dp[i - 1] + 2;
                        if (i - dp[i - 1] - 2 >= 0) {
                            dp[i] += dp[i - dp[i - 1] - 2];
                        }
                    } else {
                        dp[i] = 0;
                    }
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
}
