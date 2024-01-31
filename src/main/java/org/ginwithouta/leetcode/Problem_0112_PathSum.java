package org.ginwithouta.leetcode;

import org.ginwithouta.leetcode.common.tree.TreeNode;

/**
 * @author Ginwithouta
 * Generate at 2024/1/25
 * Problem 路径总和
 */
public class Problem_0112_PathSum {
    /**
     * 解法一，用一个额外的变量来记录当前的路径和
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {

        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        return process(root, targetSum, 0);
    }
    public boolean process(TreeNode root, int targetSum, int curSum) {
        curSum += root.val;
        if (root.left == null && root.right == null) {
            return curSum == targetSum;
        }
        if (root.left != null && process(root.left, targetSum, curSum)) {
            return true;
        }
        return root.right != null && process(root.right, targetSum, curSum);
    }

    /**
     * 解法二，直接用 targetSum 来记录路径和，若最后是 0，
     */
    public boolean better(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum - root.val == 0;
        }
        return better(root.left, targetSum - root.val) || better(root.right, targetSum - root.val);
    }
}
