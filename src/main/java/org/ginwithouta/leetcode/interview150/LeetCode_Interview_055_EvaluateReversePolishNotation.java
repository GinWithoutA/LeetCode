package org.ginwithouta.leetcode.interview150;

import java.util.Objects;

/**
 * @author Ginwithouta
 * Generate at 2024/4/6
 * LeetCode 面试经典 150 逆波兰表达式求值
 */
public class LeetCode_Interview_055_EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        int[] stack = new int[tokens.length];
        int top = -1;
        for (String token : tokens) {
            if (!Objects.equals(token, "+") && !Objects.equals(token, "*") && !Objects.equals(token, "-") && !Objects.equals(token, "/")) {
                stack[++top] = Integer.parseInt(token);
            } else {
                int right = stack[top--], left = stack[top--];
                switch (token) {
                    case "+":
                        stack[++top] = left + right;
                        break;
                    case "-":
                        stack[++top] = left - right;
                        break;
                    case "*":
                        stack[++top] = left * right;
                        break;
                    case "/":
                        stack[++top] = left / right;
                        break;
                    default:
                        break;
                }
            }
        }
        return stack[top];
    }
}
