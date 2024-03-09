package org.ginwithouta.leetcode.company.meituan;

import org.ginwithouta.leetcode.common.tree.TreeNode;

/**
 * @author Ginwithouta
 * Generate at 2024/3/9
 * LeetCode 美团 二叉树的最大路径和
 */
public class LeetCode_Meituan_030_BinaryTreeMaximumPathSum {
    private int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        process(root);
        return max;
    }

    public int process(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(process(root.left), 0), right = Math.max(0, process(root.right));
        max = Math.max(max, left + right + root.val);
        return root.val + Math.max(left, right);
    }
}
