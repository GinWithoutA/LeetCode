package org.ginwithouta.leetcode.spring100;

/**
 * @author Ginwithouta
 * Generate at 2024/3/19
 * LeetCode 春招 100 有效的括号
 */
public class LeetCode_Spring_005_ValidParentheses {
    public boolean isValid(String s) {
        char[] str = s.toCharArray(), stack = new char[str.length];
        int top = -1;
        for (char c : str) {
            if (c == '(' || c == '[' || c == '{') {
                stack[++top] = c;
            } else {
                if (top == -1) {
                    return false;
                }
                if (c == ')' && stack[top] != '(') {
                    return false;
                }
                if (c == ']' && stack[top] != '[') {
                    return false;
                }
                if (c == '}' && stack[top] != '{') {
                    return false;
                }
                --top;
            }
        }
        return top == -1;
    }
}
