package org.ginwithouta.leetcode;

import org.ginwithouta.leetcode.common.tree.TreeNode;

/**
 * @author Ginwithouta
 * Generate at 2024/1/25
 * Problem 完全二叉树节点的个数
 */
public class Problem_0222_CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        /*
         * 由于输入一定是完全二叉树，最后一层的节点肯定都会集中在左边。因此我们可以分别计算左右子树的高度。
         * 如果高度相同，那么只需要递归计算右边子树的节点数量就行。反之，如果高度不同，肯定是左边比右边子
         * 多一层，因此只需要递归计算左边子树的节点数量就行
         */
        if (root == null) {
            return 0;
        }
        int left = countLevel(root.left), right = countLevel(root.right);
        if (left == right) {
            return countNodes(root.right) + (1 << left);
        } else {
            return countNodes(root.left) + (1 << right);
        }
    }
    private int countLevel(TreeNode root) {
        int level = 0;
        while (root != null) {
            ++level;
            root = root.left;
        }
        return level;
    }
}
