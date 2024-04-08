package org.ginwithouta.leetcode.interview150;

import org.ginwithouta.leetcode.common.tree.TreeNode;

/**
 * @author Ginwithouta
 * Generate at 2024/4/8
 * LeetCode 面试经典 150 从前序与中序遍历序列构造二叉树
 */
public class LeetCode_Interview_072_ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }
        return process(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    public TreeNode process(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preLeft]);
        int mid = inLeft;
        while (inorder[mid] != preorder[preLeft]) {
            ++mid;
        }
        root.left = process(preorder, preLeft + 1, preLeft + mid - inLeft, inorder, inLeft, mid - 1);
        root.right = process(preorder, preLeft + mid - inLeft + 1, preRight, inorder, mid + 1, inRight);
        return root;
    }
}
