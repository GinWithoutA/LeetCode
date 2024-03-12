package org.ginwithouta.leetcode.company.mi;

/**
 * @author Ginwithouta
 * Generate at 2024/3/12
 * LeetCode 小米 有效的括号
 */
public class LeetCode_Mi_0020_ValidParentheses {
    public boolean isValid(String s) {
        if ((s.length() & 1) == 1) {
            return false;
        }
        char[] stack = new char[s.length()], strs = s.toCharArray();
        int top = -1;
        for (char str : strs) {
            if (str == '(' || str == '[' || str == '{') {
                stack[++top] = str;
            } else {
                if (top == -1 || (str == ')' && stack[top] != '(') || (str == '}' && stack[top] != '{') || (str == ']' && stack[top] != '[')) {
                    return false;
                }
                --top;
            }
        }
        return top == -1;
    }
}
