package org.ginwithouta.leetcode;

import org.ginwithouta.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Ginwithouta
 * Generate at 2024/1/26
 * Problem 二叉树的层序遍历
 */
public class Problem_0102_BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> ans = new ArrayList<>();
        TreeNode levelEnd = root, nextLevelEnd = root, cur;
        List<Integer> level = new ArrayList<>();
        while (!queue.isEmpty()) {
            cur = queue.poll();
            level.add(cur.val);
            if (cur.left != null) {
                queue.offer(cur.left);
                nextLevelEnd = cur.left;
            }
            if (cur.right != null) {
                queue.offer(cur.right);
                nextLevelEnd = cur.right;
            }
            if (cur == levelEnd) {
                ans.add(level);
                level = new ArrayList<>();
                levelEnd = nextLevelEnd;
            }
        }
        return ans;
    }
}
