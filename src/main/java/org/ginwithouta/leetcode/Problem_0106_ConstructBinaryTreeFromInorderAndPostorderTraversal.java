package org.ginwithouta.leetcode;

import org.ginwithouta.leetcode.common.TreeNode;

import java.util.HashMap;

/**
 * @author Ginwithouta
 * Generate at 2024/1/24
 * Problem 从中序与后序遍历构造二叉树
 */
public class Problem_0106_ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        /*
         * 基本思路和中序前序构建二叉树相同，都是利用后序先定位根节点，然后不断在中序中找剩余结点
         */
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; ++i) {
            map.put(inorder[i], i);
        }
        return process(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1, map);
    }
    public TreeNode process(int[] in, int[] post, int inLeft, int inRight, int postLeft, int postRight, HashMap<Integer, Integer> map) {
        if (postLeft > postRight) {
            return null;
        }
        TreeNode root = new TreeNode(post[postRight]);
        if (postLeft == postRight) {
            return root;
        }
        int inIdx = map.get(post[postRight]);
        root.left = process(in, post, inLeft, inIdx - 1, postLeft, postRight - inRight + inIdx - 1, map);
        root.right = process(in, post, inIdx + 1, inRight, postRight - inRight + inIdx, postRight - 1, map);
        return root;
    }
}
