package org.ginwithouta.leetcode.interview150;

import org.ginwithouta.leetcode.common.tree.TreeNode;

/**
 * @author Ginwithouta
 * Generate at 2024/4/8
 * LeetCode 面试经典 150 完全二叉树的节点个数
 */
public class LeetCode_Interview_079_CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getLevel(root.left), right = getLevel(root.right);
        if (left == right) {
            return countNodes(root.right) + (1 << left);
        } else {
            return countNodes(root.left) + (1 << right);
        }
    }
    public int getLevel(TreeNode root) {
        int level = 0;
        while (root != null) {
            root = root.left;
            ++level;
        }
        return level;
    }
}
