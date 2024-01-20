package org.ginwithouta.leetcode;

/**
 * @author Ginwithouta
 * Generate at 2024/1/20
 * Problem 有效的括号
 */
public class Problem_0020_ValidParentheses {
    public boolean isValid(String s) {
        /*
         * 用一个栈就能解决，要注意中间在判断当前左右括号是否匹配的时候需要先判断当前的栈里面是否有元素，
         * 如果没有就可以直接返回 false
         */
        if (s.length() == 1) {
            return false;
        }
        char[] strs = s.toCharArray();
        char[] stack = new char[strs.length];
        int top = -1;
        for (char str : strs) {
            if (str == '(' || str == '[' || str == '{') {
                stack[++top] = str;
            } else if (top == -1) {
                return false;
            } else {
                char topChar = stack[top--];
                if ((str == ')' && topChar != '(') || (str == ']' && topChar != '[') || (str == '}' && topChar != '{')) {
                    return false;
                }
            }
        }
        return top == -1;
    }
}
