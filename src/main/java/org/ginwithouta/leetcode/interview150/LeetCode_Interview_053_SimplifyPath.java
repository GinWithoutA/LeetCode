package org.ginwithouta.leetcode.interview150;


/**
 * @author Ginwithouta
 * Generate at 2024/4/6
 * LeetCode 面试经典 150 简化路径
 */
public class LeetCode_Interview_053_SimplifyPath {
    public String simplifyPath(String path) {
        String[] paths = path.split("/"), stack = new String[paths.length];
        int top = -1;
        for (String item : paths) {
            if (item.equals("..")) {
                if (top != -1) {
                    --top;
                }
            } else if (!item.equals(".") && !item.isEmpty()) {
                stack[++top] = item;
            }
        }
        if (top == -1) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= top; ++i) {
            sb.append("/").append(stack[i]);
        }
        return sb.toString();
    }
}
