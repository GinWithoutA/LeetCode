package org.ginwithouta.leetcode.hot100;

import org.ginwithouta.leetcode.common.tree.TreeNode;

/**
 * @author Ginwithouta
 * Generate at 2024/2/21
 * LeetCode Hot 100 对称二叉树
 */
public class LeetCode_Hot_039_SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
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
