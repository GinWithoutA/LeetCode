package org.ginwithouta.leetcode;

import org.ginwithouta.leetcode.common.TreeNode;

/**
 * @author Ginwithouta
 * Generate at 2024/1/24
 * Problem 对称二叉树
 */
public class Problem_0101_SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return process(root.left, root.right);
    }
    public boolean process(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return  process(left.left, right.right) && process(left.right, right.left);
    }
}
