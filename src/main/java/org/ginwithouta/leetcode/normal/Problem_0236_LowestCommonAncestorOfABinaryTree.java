package org.ginwithouta.leetcode.normal;

import org.ginwithouta.leetcode.common.tree.TreeNode;

/**
 * @author Ginwithouta
 * Generate at 2024/1/25
 */
public class Problem_0236_LowestCommonAncestorOfABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /*
         * 对于每个节点，只有三种情况
         * 1）p == root, q 在 root 的左侧
         * 2）q == root, p 在 root 的右侧
         * 3）p 和 q 分别在 root 的两侧
         * 首先找到 p q 的位置，由于 p q 不相同，所以 left right 要么都有值，并且值相同，要么一个为空一个不为空
         * 接着递归查找，如果 left right 同时为空，说明 p q 不存在
         * 如果 left right 一个空一个不空，说明在同侧，此时就是最近的公共节点
         * 如果 left right 都不为空，说明在不同测，那么当前节点就是最近公共节点
         */
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }
}
