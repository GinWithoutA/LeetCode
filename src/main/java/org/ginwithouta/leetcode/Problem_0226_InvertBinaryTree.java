package org.ginwithouta.leetcode;

import org.ginwithouta.leetcode.common.TreeNode;

/**
 * @author Ginwithouta
 * Generate at 2024/1/24
 * problem 反转二叉树
 */
public class Problem_0226_InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
