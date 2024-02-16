package org.ginwithouta.leetcode.day;

import org.ginwithouta.leetcode.common.tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Ginwithouta
 * Generate at 2024/2/16
 * LeetCode 每日一题 0103 二叉树的锯齿形层次遍历
 */
public class LeetCode_240216_0103_BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        /*
         * 为了实现蛇形，需要头进尾巴拿，尾巴进头拿，每一层的结尾只需要上一层结尾到达的时候看一下 queue 中的头或者尾位置
         */
        if (root == null) {
            return new ArrayList<>();
        }
        Deque<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> level = new ArrayList<>();
        TreeNode cur, end = root;
        boolean head = true;
        queue.offer(root);
        while (!queue.isEmpty()) {
            if (head) {
                cur = queue.pollLast();
                level.add(cur.val);
                if (cur.left != null) {
                    queue.offerFirst(cur.left);
                }
                if (cur.right != null) {
                    queue.offerFirst(cur.right);
                }
                if (cur == end) {
                    ans.add(level);
                    level = new ArrayList<>();
                    end = queue.peekLast();
                    head = false;
                }
            } else {
                cur = queue.pollFirst();
                level.add(cur.val);
                if (cur.right != null) {
                    queue.offerLast(cur.right);
                }
                if (cur.left != null) {
                    queue.offerLast(cur.left);
                }
                if (cur == end) {
                    ans.add(level);
                    level = new ArrayList<>();
                    end = queue.peekFirst();
                    head = true;
                }
            }
        }
        return ans;
    }
}
