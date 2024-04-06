package org.ginwithouta.leetcode.interview150;

/**
 * @author Ginwithouta
 * Generate at 2024/4/6
 * LeetCode 面试经典 150 基本计算器 递归
 */
public class LeetCode_Interview_056_BasicCalculator_ {
    public int idx = -1;
    public int calculate(String s) {
        return process(s.toCharArray());
    }

    public int process(char[] str) {
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
                    num = process(str);
                } else {
                    return val;
                }
            }
        }
        return check(val, num, op);
    }
    private int check(int val, int num, int op) {
        if (op == 1) {
            return val + num;
        }
        return val - num;
    }
}
