package org.ginwithouta.leetcode.interview150;

import org.ginwithouta.leetcode.common.tree.TreeNode;

/**
 * @author Ginwithouta
 * Generate at 2024/4/8
 * LeetCode 面试经典 150 从中序和后续遍历序列构造二叉树
 */
public class LeetCode_Interview_073_ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 1) {
            return new TreeNode(inorder[0]);
        }
        return process(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    public TreeNode process(int[] inorder, int inLeft, int inRight, int[] postorder, int postLeft, int postRight) {
        if (inLeft > inRight) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postRight]);
        int mid = inLeft;
        while (inorder[mid] != postorder[postRight]) {
            ++mid;
        }
        root.left = process(inorder, inLeft, mid - 1, postorder, postLeft, postLeft + mid - inLeft - 1);
        root.right = process(inorder, mid + 1, inRight, postorder, postLeft + mid - inLeft, postRight - 1);
        return root;
    }
}
