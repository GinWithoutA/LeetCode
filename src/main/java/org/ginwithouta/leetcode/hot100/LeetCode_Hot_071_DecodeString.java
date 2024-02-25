package org.ginwithouta.leetcode.hot100;

import java.util.*;

/**
 * @author Ginwithouta
 * Generate at 2024/2/25
 * LeetCode Hot 100 字符串解码
 */
public class LeetCode_Hot_071_DecodeString {
    public String decodeString(String s) {
        char[] strs = s.toCharArray();
        Stack<String> stack = new Stack<>();
        int idx = 0;
        while (idx < strs.length) {
            if (strs[idx] >= '0' && strs[idx] <= '9') {
                stack.push(String.valueOf(strs[idx++]));
            } else if (strs[idx] >= 'a' && strs[idx] <= 'z') {
                StringBuilder sb = new StringBuilder();
                sb.append(strs[idx++]);
                while (idx < strs.length && (strs[idx] >= 'a' && strs[idx] <= 'z')) {
                    sb.append(strs[idx++]);
                }
                stack.push(sb.toString());
            } else if (strs[idx] == '[') {
                stack.push(String.valueOf(strs[idx++]));
            } else {
                ++idx;
                LinkedList<String> path = new LinkedList<>();
                while (!Objects.equals(stack.peek(), "[")) {
                    path.addLast(stack.pop());
                }
                Collections.reverse(path);
                stack.pop();
                int times = Integer.parseInt(stack.pop());
                StringBuilder sb = new StringBuilder();
                for (String str : path) {
                    sb.append(str);
                }
                String temp = sb.toString();
                while (--times != 0) {
                    sb.append(temp);
                }
                stack.push(sb.toString());
            }
        }
        LinkedList<String> path = new LinkedList<>();
        while (!stack.isEmpty()) {
            path.addLast(stack.pop());
        }
        Collections.reverse(path);
        StringBuilder sb = new StringBuilder();
        for (String str : path) {
            sb.append(str);
        }
        return sb.toString();

    }
}
