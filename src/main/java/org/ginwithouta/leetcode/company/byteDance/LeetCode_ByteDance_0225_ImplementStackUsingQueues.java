package org.ginwithouta.leetcode.company.byteDance;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Ginwithouta
 * Generate at 2024/3/15
 * LeetCode 字节跳动 用队列实现栈
 */
public class LeetCode_ByteDance_0225_ImplementStackUsingQueues {
    public static class MyStack {
        public Deque<Integer> queue;
        public MyStack() {
            this.queue = new ArrayDeque<>();
        }
        public void push(int x) {
            this.queue.push(x);
            for (int i = 0; i < queue.size() - 1; ++i) {
                this.queue.push(this.queue.poll());
            }
        }

        public int pop() {
            return this.queue.isEmpty() ? Integer.MIN_VALUE : this.queue.poll();
        }

        public int top() {
            return this.queue.isEmpty() ? Integer.MIN_VALUE : this.queue.peek();
        }

        public boolean empty() {
            return this.queue.isEmpty();
        }
    }
}
