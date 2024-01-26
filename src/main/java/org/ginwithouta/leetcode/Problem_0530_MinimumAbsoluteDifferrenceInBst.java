package org.ginwithouta.leetcode;

import org.ginwithouta.leetcode.common.TreeNode;

/**
 * @author Ginwithouta
 * Generate at 2024/1/26
 * Problem 二叉搜索树的最小绝对差
 */
public class Problem_0530_MinimumAbsoluteDifferrenceInBst {
    public int getMinimumDifference(TreeNode root) {
        /*
         * 由于是二叉搜索树，差距最小的就只能是树的中序遍历序列中相邻的数字
         */
        TreeNode cur = root, mostRight;
        int pre = -1, ans = Integer.MAX_VALUE;
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
            if (pre != -1) {
                ans = Math.min(ans, cur.val - pre);
            }
            pre = cur.val;
            cur = cur.right;
        }
        return ans;
    }
}
