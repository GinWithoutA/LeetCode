package org.ginwithouta.leetcode.interview150;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Ginwithouta
 * Generate at 2024/4/6
 * LeetCode 面试经典 150 基本计算器
 */
public class LeetCode_Interview_056_BasicCalculator {
    public int calculate(String s) {
        Deque<Integer> nums = new ArrayDeque<>();
        Deque<Character> ops = new ArrayDeque<>();
        char[] str = s.replaceAll(" ", "").toCharArray();
        nums.push(0);
        for (int i = 0; i < str.length; ++i) {
            if (str[i] == '(') {
                ops.push(str[i]);
            } else if (str[i] == ')') {
                while (!ops.isEmpty()) {
                    char cur = ops.peek();
                    if (cur != '(') {
                        cal(nums, ops);
                    } else {
                        ops.pop();
                        break;
                    }
                }
            } else {
                if (Character.isDigit(str[i])) {
                    int cur = 0, j = i;
                    while (j < str.length && Character.isDigit(str[j])) {
                        cur = cur * 10 + (str[j++] - '0');
                    }
                    nums.push(cur);
                    i = j - 1;
                } else {
                    if (i > 0 && (str[i - 1] == '(' || str[i - 1] == '+' || str[i - 1] == '-')) {
                        nums.push(0);
                    }
                    while (!ops.isEmpty() && ops.peek() != '(') {
                        cal(nums, ops);
                    }
                    ops.push(str[i]);
                }
            }
        }
        while (!ops.isEmpty()) {
            cal(nums, ops);
        }
        return nums.peek();
    }
    private void cal(Deque<Integer> nums, Deque<Character> ops) {
        if (nums.isEmpty() || nums.size() < 2 || ops.isEmpty()) return;
        int right = nums.pop(), left = nums.pop();
        char op = ops.pop();
        nums.push(op == '+' ? left + right : left - right);
    }
}
