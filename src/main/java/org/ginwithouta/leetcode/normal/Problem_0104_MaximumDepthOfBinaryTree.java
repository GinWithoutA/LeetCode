package org.ginwithouta.leetcode.normal;

import org.ginwithouta.leetcode.common.tree.TreeNode;

/**
 * @author Ginwithouta
 * Generate at 2024/1/24
 * Problem 二叉树的最大深度
 */
public class Problem_0104_MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        /*
         * 一个递归解决
         */
        if (root == null) {
            return 0;
        } if (root.left == null && root.right == null) {
            return 1;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
