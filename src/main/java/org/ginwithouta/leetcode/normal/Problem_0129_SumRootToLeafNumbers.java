package org.ginwithouta.leetcode.normal;

import org.ginwithouta.leetcode.common.tree.TreeNode;

/**
 * @author Ginwithouta
 * Generate at 2024/1/25
 * Problem 求根节点到叶节点数字之和
 */
public class Problem_0129_SumRootToLeafNumbers {
    public static int sumNumbers(TreeNode root) {
        return process(root, 0);
    }
    public static int process(TreeNode root, int pre) {
        if (root == null) {
            return 0;
        }
        pre = pre * 10 + root.val;
        if (root.left == null && root.right == null) {
            return pre;
        }
        return process(root.left, pre) + process(root.right, pre);
    }
}
