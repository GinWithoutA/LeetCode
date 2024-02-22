package org.ginwithouta.leetcode.hot100;

import org.ginwithouta.leetcode.common.tree.TreeNode;

/**
 * @author Ginwithouta
 * Generate at 2024/2/22
 * LeetCode Hot 100 二叉树的最大路径和
 */
public class LeetCode_Hot_050_BinaryTreeMaximumPathSum {
    private Integer max = null;
    public int maxPathSum(TreeNode root) {
        process(root);
        return max;
    }
    public int process(TreeNode root) {
        /*
         * 在返回下层的最大和的时候，我们不能返回 root.val + left + right 的值，只能返回一个
         */
        if (root == null) {
            return 0;
        }
        int left = process(root.left), right = process(root.right);
        int sum = Math.max(root.val, Math.max(root.val + left, root.val + right));
        int compare = Math.max(sum, root.val + left + right);
        max = max == null ? compare : Math.max(max, compare);
        return sum;
    }
}
