package org.ginwithouta.leetcode.interview150;

import org.ginwithouta.leetcode.common.tree.TreeNode;

/**
 * @author Ginwithouta
 * Generate at 2024/4/8
 * LeetCode 面试经典 150 二叉树中的最大路径和
 */
public class LeetCode_Interview_077_BinaryTreeMaximumPathSum {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        process(root);
        return max;
    }
    public int process(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = process(root.left), right = process(root.right);
        int res = Math.max(Math.max(left, right) + root.val, root.val);
        max = Math.max(max, Math.max(res, left + right + root.val));
        return res;
    }
}
