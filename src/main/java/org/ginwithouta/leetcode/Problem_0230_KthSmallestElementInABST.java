package org.ginwithouta.leetcode;

import org.ginwithouta.leetcode.common.TreeNode;

/**
 * @author Ginwithouta
 * Generate at 2024/1/26
 * Problem 二叉搜索树中第 K 小的元素
 */
public class Problem_0230_KthSmallestElementInABST {
    public int kthSmallest(TreeNode root, int k) {
        /*
         * 一边遍历，一边减少 k ，当 k == 0 就是找到了
         */
        if (root.left == null && root.right == null) {
            return root.val;
        }
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
            if (--k == 0) {
                break;
            }
            cur = cur.right;
        }
        return cur.val;
    }
}
