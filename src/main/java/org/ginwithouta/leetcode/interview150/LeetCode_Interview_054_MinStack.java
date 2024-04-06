package org.ginwithouta.leetcode.interview150;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Ginwithouta
 * Generate at 2024/4/6
 * LeetCode 面试经典 150 最小栈
 */
public class LeetCode_Interview_054_MinStack {
    class MinStack {

        Deque<Integer> stack;
        Deque<Integer> min;

        public MinStack() {
            this.stack = new ArrayDeque<>();
            this.min = new ArrayDeque<>();
        }

        public void push(int val) {
            this.stack.push(val);
            if (this.min.isEmpty() || this.min.peek() >= val) {
                this.min.push(val);
            } else {
                this.min.push(this.min.peek());
            }
        }

        public void pop() {
            this.stack.pop();
            this.min.pop();
        }

        public int top() {
            return this.stack.peek();
        }

        public int getMin() {
            return this.min.peek();
        }
    }
}
