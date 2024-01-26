package org.ginwithouta.leetcode;

import org.ginwithouta.leetcode.common.TreeNode;

import java.util.*;

/**
 * @author Ginwithouta
 * Generate at 2024/1/26
 * Problem 二叉树的锯齿形遍历
 */
public class Problem_0103_BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> level = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        TreeNode levelEnd = root, cur;
        boolean head = true;
        queue.offer(root);
        while (!queue.isEmpty()) {
            if (head) {
                // 头出尾巴进
                cur = queue.pollFirst();
                level.add(cur.val);
                if (cur.left != null) {
                    queue.offerLast(cur.left);
                }
                if (cur.right != null) {
                    queue.offerLast(cur.right);
                }
                if (cur == levelEnd) {
                    head = false;
                    ans.add(level);
                    level = new ArrayList<>();
                    levelEnd = queue.peekFirst();
                }
            } else {
                // 尾巴出头进
                cur = queue.pollLast();
                level.add(cur.val);
                if (cur.right != null) {
                    queue.offerFirst(cur.right);
                }
                if (cur.left != null) {
                    queue.offerFirst(cur.left);
                }
                if (cur == levelEnd) {
                    head = true;
                    ans.add(level);
                    level = new ArrayList<>();
                    levelEnd = queue.peekLast();
                }
            }
        }
        return ans;
    }
}
