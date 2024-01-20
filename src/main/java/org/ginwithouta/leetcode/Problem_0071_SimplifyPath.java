package org.ginwithouta.leetcode;

import java.util.Objects;
import java.util.Stack;

/**
 * @author Ginwithouta
 * Generate at 2024/1/20
 * Problem 简化路径
 */
public class Problem_0071_SimplifyPath {
    public String simplifyPath(String path) {
        /*
         * 首先分割字符串，根据 / 进行分割，那么会得到空字符串， .， .. ，目录
         * 空字符串就不用管，.. 就将stack中的顶层元素弹出，只有是目录的情况才需
         * 要将当前目录添加到字符串 stack 中
         */
        if (path.length() == 1) {
            return path;
        }
        String[] names = path.split("/"), stack = new String[1000];
        int top = -1;
        for (String name : names) {
            if (Objects.equals("..", name)) {
                if (top != -1) {
                    --top;
                }
            } else if (!name.isEmpty() && !Objects.equals(".", name)) {
                stack[++top] = name;
            }
        }
        StringBuilder sb = new StringBuilder();
        if (top == -1) {
            sb.append("/");
        } else {
            for (int i = 0; i <= top; ++i) {
                sb.append("/").append(stack[i]);
            }
        }
        return sb.toString();
    }
}
