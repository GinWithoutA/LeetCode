package org.ginwithouta.leetcode.hot100;

/**
 * @author Ginwithouta
 * Generate at 2024/2/25
 * LeetCode Hot 100 有效的括号
 */
public class LeetCode_Hot_069_ValidParentheses {
    public boolean isValid(String s) {
        if ((s.length() & 1) == 1) {
            return false;
        }
        char[] stack = new char[s.length()], strs = s.toCharArray();
        int top = -1;
        for (char str : strs) {
            if (str == '(' || str == '[' || str == '{') {
                stack[++top] = str;
            } else if (top == -1) {
                return false;
            } else if (str == ')' && stack[top] != '(') {
                return false;
            } else if (str == ']' && stack[top] != '[') {
                return false;
            } else if (str == '}' && stack[top] != '{') {
                return false;
            } else {
                --top;
            }
        }
        return top == -1;
    }
}
