package org.ginwithouta.leetcode.interview150;

/**
 * @author Ginwithouta
 * Generate at 2024/4/6
 * LeetCode 面试经典 150 有效的括号
 */
public class LeetCode_Interview_052_ValidParentheses {
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
                char cur = stack[top--];
                if ((c == ')' && cur != '(') || (c == ']' && cur != '[') || (c == '}' && cur != '{')) {
                    return false;
                }
            }
        }
        return top == -1;
    }
}
