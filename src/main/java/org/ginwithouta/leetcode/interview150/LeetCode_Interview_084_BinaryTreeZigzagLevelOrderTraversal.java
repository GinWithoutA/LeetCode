package org.ginwithouta.leetcode.interview150;

import org.ginwithouta.leetcode.common.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Ginwithouta
 * Generate at 2024/4/9
 * LeetCode 面试经典 150 二叉树的锯齿形层序遍历
 */
public class LeetCode_Interview_084_BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        TreeNode cur, end = root;
        int head = 1;
        queue.offerLast(root);
        while (!queue.isEmpty()) {
            if (head == 1) {
                cur = queue.pollLast();
                res.add(cur.val);
                if (cur.left != null) {
                    queue.offerFirst(cur.left);
                }
                if (cur.right != null) {
                    queue.offerFirst(cur.right);
                }
                if (cur == end) {
                    ans.add(res);
                    res = new ArrayList<>();
                    end = queue.peekLast();
                    head = 0;
                }
            } else {
                cur = queue.pollFirst();
                res.add(cur.val);
                if (cur.right != null) {
                    queue.offerLast(cur.right);
                }
                if (cur.left != null) {
                    queue.offerLast(cur.left);
                }
                if (cur == end) {
                    ans.add(res);
                    res = new ArrayList<>();
                    end = queue.peekFirst();
                    head = 1;
                }
            }
        }
        return ans;
    }
}
