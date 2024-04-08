package org.ginwithouta.leetcode.interview150;

import org.ginwithouta.leetcode.common.tree.TreeNode;

/**
 * @author Ginwithouta
 * Generate at 2024/4/8
 * LeetCode 面试经典 150 二叉树展开为链表
 */
public class LeetCode_Interview_074_FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        process(root, null);
    }
    public TreeNode process(TreeNode root, TreeNode pre) {
        if (root == null) {
            return pre;
        }
        if (pre != null) {
            pre.right = root;
        }
        pre = root;
        TreeNode left = root.left, right = root.right;
        root.left = null;
        root.right = null;
        pre = process(left, pre);
        pre = process(right, pre);
        return pre;
    }
}
