package org.ginwithouta.leetcode.normal;

import java.util.Stack;

/**
 * @author Ginwithouta
 * Generate at 2024/1/21
 * Problem 逆波兰表达式求职
 */
public class Problem_0150_EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if ("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token)) {
                int right = stack.pop(), left = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(left + right);
                        break;
                    case "-":
                        stack.push(left - right);
                        break;
                    case "*":
                        stack.push(left * right);
                        break;
                    case "/":
                        stack.push(left / right);
                        break;
                    default:
                        break;
                }
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.peek();
    }
}
