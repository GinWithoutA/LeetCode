package org.ginwithouta.leetcode;

import org.ginwithouta.leetcode.common.tree.TreeNode;

/**
 * @author Ginwithouta
 * Generate at 2024/1/25
 * Problem 二叉树中的最大路径和
 */
public class Problem_0124_BinaryTreeMaximumPathSum {
    private int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        /*
         * 对于每个叶子节点，它都有一个贡献值，就是它本身的值。对于其他非叶子节点，他也会给它的父亲产生一个贡献值，
         * 也就是他自己的值加上左边或者右边中贡献值更大的那个（每个节点只能出现一次）。
         * 因此对于每个节点，当前的路径最大和就是左边的贡献值加上右边的贡献值，再加上自己的贡献值，不断更新
         */
        if (root.left == root.right) {
            return root.val;
        }
        process(root);
        return ans;
    }
    public int process(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int p1 = Math.max(0, process(node.left));
        int p2 = Math.max(0, process(node.right));
        ans = Math.max(ans, p1 + p2 + node.val);
        return node.val + Math.max(p1, p2);
    }
}
