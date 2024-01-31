package org.ginwithouta.leetcode;

import org.ginwithouta.leetcode.common.tree.TreeNode;

/**
 * @author Ginwithouta
 * Generate at 2024/1/31
 * Problem 将有序数组转换为二叉搜索树
 */
public class Problem_0108_ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        /*
         * 由于已经是排序号的数组，要得到一棵平衡二叉树只需要通过二分不断遍历就可以了
         */
        return process(nums, 0, nums.length - 1);
    }
    public TreeNode process(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            return new TreeNode(nums[left]);
        }
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = process(nums, left, mid - 1);
        node.right = process(nums, mid + 1, right);
        return node;
    }
}
