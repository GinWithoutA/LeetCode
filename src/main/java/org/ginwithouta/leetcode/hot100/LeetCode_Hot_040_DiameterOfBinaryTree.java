package org.ginwithouta.leetcode.hot100;

import org.ginwithouta.leetcode.common.tree.TreeNode;

/**
 * @author Ginwithouta
 * Generate at 2024/2/21
 * LeetCode Hot 100 二叉树的直径
 */
public class LeetCode_Hot_040_DiameterOfBinaryTree {
    private int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        process(root);
        return max;
    }
    public int process(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = process(root.left), right = process(root.right);
        max = Math.max(left + right, max);
        return Math.max(left, right) + 1;
    }
}
