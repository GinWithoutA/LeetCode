package org.ginwithouta.leetcode.common.tree;


/**
 * 二叉树节的点类
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode next;
    public TreeNode() {}
    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
        this.next = null;
    }
    public TreeNode(int val, TreeNode left, TreeNode right, TreeNode next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
}
