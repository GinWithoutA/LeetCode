package org.ginwithouta.leetcode.normal;

import org.ginwithouta.leetcode.common.tree.TreeNode;

/**
 * @author Ginwithouta
 * Generate at 2024/1/25
 * Problem 二叉树展开为链表
 */
public class Problem_0114_FlattenBinaryTreeToLinkedList {
    public static void flatten(TreeNode root) {
        /*
         * 前序遍历，记录不断变化的 pre 就可以
         */
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        process(root, null);
    }

    public static TreeNode process(TreeNode node, TreeNode pre) {
        if (node == null) {
            return pre;
        }
        if (pre != null) {
            pre.right = node;
        }
        pre = node;
        TreeNode left = node.left, right = node.right;
        node.left = null;
        node.right = null;
        pre = process(left, pre);
        pre = process(right, pre);
        return pre;
    }
}
