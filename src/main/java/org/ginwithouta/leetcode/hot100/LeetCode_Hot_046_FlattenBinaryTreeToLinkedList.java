package org.ginwithouta.leetcode.hot100;

import org.ginwithouta.leetcode.common.tree.TreeNode;

/**
 * @author Ginwithouta
 * Generate at 2024/2/21
 * LeetCode Hot 100 二叉树展开为链表
 */
public class LeetCode_Hot_046_FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        process(root);
    }

    /**
     * 将当前子树转换为链表，接在 root 的右边，同时返回转换为链表后的最有一个结点
     */
    public TreeNode process(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root;
        }
        TreeNode left = root.left, right = root.right;
        root.left = null;
        if (left == null) {
            return process(right);
        }
        root.right = left;
        left = process(left);
        if (right == null) {
            return left;
        }
        left.right = right;
        return process(right);
    }
}
