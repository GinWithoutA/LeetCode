package org.ginwithouta.leetcode.hot100;

import java.util.Stack;

/**
 * @author Ginwithouta
 * Generate at 2024/2/25
 * LeetCode Hot 100 最小栈
 */
public class LeetCode_Hot_070_MinStack {
    public static class MinStack {
        private Stack<Integer> stack;
        private Stack<Integer> min;
        public MinStack() {
            this.stack = new Stack<>();
            this.min = new Stack<>();
        }

        public void push(int val) {
            this.stack.push(val);
            if (this.min.isEmpty() || this.min.peek() > val) {
                this.min.push(val);
            } else {
                this.min.push(this.min.peek());
            }
        }

        public void pop() {
            this.min.pop();
            this.stack.pop();
        }

        public int top() {
            return this.stack.peek();
        }

        public int getMin() {
            return this.min.peek();
        }
    }
}
