package org.ginwithouta.leetcode.hot100;

import org.ginwithouta.leetcode.common.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ginwithouta
 * Generate at 2024/2/21
 * LeetCode Hot 100 二叉树的中序遍历
 */
public class LeetCode_Hot_036_BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>();
        TreeNode cur = root, mostRight;
        while (cur != null) {
            if (cur.left != null) {
                mostRight = cur.left;
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }
                mostRight.right = null;
            }
            ans.add(cur.val);
            cur = cur.right;
        }
        return ans;
    }
}
