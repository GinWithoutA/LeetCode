package org.ginwithouta.leetcode.hot100;

import org.ginwithouta.leetcode.common.tree.TreeNode;

import java.util.Arrays;

/**
 * @author Ginwithouta
 * Generate at 2024/2/21
 * LeetCode Hot 100 将有序数组转换为二叉搜索树
 */
public class LeetCode_Hot_042_ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return process(nums, 0, nums.length - 1);
    }

    public TreeNode process(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = process(nums, start, mid - 1);
        root.right = process(nums, mid + 1, end);
        return root;
    }
}
