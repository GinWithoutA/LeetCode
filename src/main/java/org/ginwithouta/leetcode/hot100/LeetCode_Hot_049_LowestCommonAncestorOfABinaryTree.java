package org.ginwithouta.leetcode.hot100;

import org.ginwithouta.leetcode.common.tree.TreeNode;

/**
 * @author Ginwithouta
 * Generate at 2024/2/22
 * LeetCode Hot 100 二叉树的最近公共祖先
 */
public class LeetCode_Hot_049_LowestCommonAncestorOfABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /*
         * 整体的思路，这道题只有两种可能：
         * 1. 位于异侧
         * 2. 位于同侧（p 是 q 的祖先，q 是 p 的祖先）
         * 从一个父节点的视角展开（该节点不是q也不是p），由于当遍历到p或者q或者null的时候，递归就会返回
         * 因此当我们传入root.left去递归的时候，如果返回null，说明p和q都不在left里面，说明是第二种情况，
         * 那么只要返回right就可以（right一定是遍历到的第一个结点）
         * 同理，对right也一样
         * 那么如果p和q都不为空，那么是第一种情况，则返回root就可以
         */

        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left == null ? right : right == null ? left : root;
    }
}
