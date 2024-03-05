package org.ginwithouta.leetcode.normal;

import org.ginwithouta.leetcode.common.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ginwithouta
 * Generate at 2024/1/24
 * Problem 根据中序和前序遍历构建二叉树
 */
public class Problem_0105_ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        /*
         * 用一个 map 存放前序遍历中每个元素在中序遍历中的位置，每次构建只构建中序当前位置的
         * 左边部分和右边部分，对他们分别进行构建
         */
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; ++i) {
            map.put(inorder[i], i);
        }
        return process(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1, map);
    }
    public TreeNode process(int[] pre, int[] in, int preLeft, int preRight, int inLeft, int inRight, Map<Integer, Integer> map)  {
        if (preLeft > preRight) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preLeft]);
        if (preLeft == preRight) {
            return root;
        }
        int idx = map.get(pre[preLeft]);
        root.left = process(pre, in, preLeft + 1, preLeft + idx - inLeft, inLeft, idx - 1, map);
        root.right = process(pre, in, preLeft + idx - inLeft + 1, preRight, idx + 1, inRight, map);
        return root;
    }

}
