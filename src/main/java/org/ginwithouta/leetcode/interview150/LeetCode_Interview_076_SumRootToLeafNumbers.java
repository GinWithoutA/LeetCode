package org.ginwithouta.leetcode.interview150;

import org.ginwithouta.leetcode.common.tree.TreeNode;

/**
 * @author Ginwithouta
 * Generate at 2024/4/8
 * LeetCode 面试经典 150 求根节点到叶节点数字之和
 */
public class LeetCode_Interview_076_SumRootToLeafNumbers {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        process(root, 0);
        return sum;
    }
    private void process(TreeNode root, int prev) {
        if (root == null) {
            return;
        }
        prev = prev * 10 + root.val;
        if (root.left == null && root.right == null) {
            sum += prev;
            return;
        }
        process(root.left, prev);
        process(root.right, prev);
    }
}
