package org.ginwithouta.leetcode.hot100;

import org.ginwithouta.leetcode.common.tree.TreeNode;

/**
 * @author Ginwithouta
 * Generate at 2024/2/21
 */
public class LeetCode_Hot_044_KthSmallestElementInABST {
    public int kthSmallest(TreeNode root, int k) {
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
                return cur.val;
            }
            cur = cur.right;
        }
        return -1;
    }
}
