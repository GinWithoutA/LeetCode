package org.ginwithouta.leetcode.interview150;

import org.ginwithouta.leetcode.common.tree.TreeNode;

/**
 * @author Ginwithouta
 * Generate at 2024/4/8
 * LeetCode 面试经典 150 对称二叉树
 */
public class LeetCode_Interview_071_SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return process(root.left, root.right);
    }
    public boolean process(TreeNode left, TreeNode right) {
        if (left == right) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return process(left.left, right.right) && process(left.right, right.left);
    }
}

