package org.ginwithouta.leetcode.hot100;

import org.ginwithouta.leetcode.common.tree.TreeNode;

import java.util.spi.ResourceBundleProvider;

/**
 * @author Ginwithouta
 * Generate at 2024/2/22
 * LeetCode Hot 100 从前序与中序遍历序列构造二叉树
 */
public class LeetCode_Hot_047_ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }
        return process(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode process(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int idx = inStart;
        while (inorder[idx] != preorder[preStart]) {
            ++idx;
        }
        root.left = process(preorder, preStart + 1, preStart + idx - inStart, inorder, inStart, idx - 1);
        root.right = process(preorder, preStart + idx - inStart + 1, preEnd, inorder, idx + 1, inEnd);
        return root;
    }
}
