package org.ginwithouta.leetcode.common;

/**
 * @author Ginwithouta
 * Generate at 2024/1/24
 * 二叉树结点公共类
 */
public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
