package org.ginwithouta.leetcode;

import java.util.Stack;

/**
 * @author Ginwithouta
 * Generate at 2024/1/21
 * Problem 基本计算器
 */
public class Problem_0224_BasicCalculator {
    /**
     * 传统方法
     */
    public int calculate(String s) {
        Stack<Character> ops = new Stack<>();
        Stack<Integer> nums = new Stack<>();
        nums.push(0);
        char[] strs = s.replaceAll(" ", "").toCharArray();
        for (int i = 0; i < strs.length; ++i) {
            if (strs[i] == '(') {
                ops.push(strs[i]);
            } else if (strs[i] == ')') {
                while (!ops.isEmpty()) {
                    char curChar = ops.peek();
                    if (curChar != '(') {
                        cal(nums, ops);
                    } else {
                        ops.pop();
                        break;
                    }
                }
            } else {
                if (Character.isDigit(strs[i])) {
                    int cur = 0, j = i;
                    while (j < strs.length && Character.isDigit(strs[j])) {
                        cur = cur * 10 + (strs[j++] - '0');
                    }
                    nums.push(cur);
                    i = j - 1;
                } else {
                    if (i > 0 && (strs[i - 1] == '(' || strs[i - 1] == '+' || strs[i - 1] == '-')) {
                        nums.push(0);
                    }
                    while (!ops.isEmpty() && ops.peek() != '(') {
                        cal(nums, ops);
                    }
                    ops.push(strs[i]);
                }
            }
        }
        while (!ops.isEmpty()) {
            cal(nums, ops);
        }
        return nums.peek();
    }

    public void cal(Stack<Integer> nums, Stack<Character> ops) {
        if (nums.isEmpty() || nums.size() < 2) return;
        if (ops.isEmpty()) return;
        int right = nums.pop(), left = nums.pop();
        char op = ops.pop();
        nums.push(op == '+' ? left + right : left - right);
    }

    int idx = -1;

    /**
     * 递归方法，碰到 ( 就先去递归算括号里面的内容，然后出来加上当前的 val
     */
    public int best(char[] str) {
        int val = 0, num = 0, op = 1;
        while (++idx < str.length) {
            if (str[idx] == ' ') {
                continue;
            }
            if (str[idx] >= '0' && str[idx] <= '9') {
                num = num * 10 + (str[idx] - '0');
            } else {
                val = check(val, num, op);
                num = 0;
                if (str[idx] == '+') {
                    op = 1;
                } else if (str[idx] == '-') {
                    op = 2;
                } else if (str[idx] == '(') {
                    num = best(str);
                } else {
                    return val;
                }
            }
        }
        return check(val, num, op);
    }

    private int check(int val, int num, int op) {
        if (op == 1) {
            val += num;
        } else if (op == 2) {
            val -= num;
        }
        return val;
    }
}
