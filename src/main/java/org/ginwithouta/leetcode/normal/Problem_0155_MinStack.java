package org.ginwithouta.leetcode.normal;

import java.util.Stack;

/**
 * @author Ginwithouta
 * Generate at 2024/1/21
 * Problem 最小栈
 */
public class Problem_0155_MinStack {
    public static class MinStack{
        /*
         * 用两个栈，一个栈正常存储元素，另一个栈不断更新当前的最小值
         */
        public Stack<Integer> stack;
        public Stack<Integer> minStack;

        public MinStack() {
            this.stack = new Stack<>();
            this.minStack = new Stack<>();
        }

        public void push(int val) {
            stack.push(val);
            if (minStack.isEmpty()) {
                minStack.push(val);
            } else if (val < minStack.peek()) {
                minStack.push(val);
            } else {
                minStack.push(minStack.peek());
            }
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
