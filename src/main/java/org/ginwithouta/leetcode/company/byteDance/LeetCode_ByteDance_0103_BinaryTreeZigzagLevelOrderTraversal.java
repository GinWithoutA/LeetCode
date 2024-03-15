package org.ginwithouta.leetcode.company.byteDance;

import org.ginwithouta.leetcode.common.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Ginwithouta
 * Generate at 2024/3/15
 * LeetCode 字节跳动 二叉树的锯齿形层序遍历
 */
public class LeetCode_ByteDance_0103_BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        List<Integer> level = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        boolean head = true;
        TreeNode end = root;
        while (!queue.isEmpty()) {
            if (head) {
                TreeNode cur = queue.pollLast();
                level.add(cur.val);
                if (cur.left != null) {
                    queue.offerFirst(cur.left);
                }
                if (cur.right != null) {
                    queue.offerFirst(cur.right);
                }
                if (cur == end) {
                    head = false;
                    ans.add(level);
                    level = new ArrayList<>();
                    end = queue.peekLast();
                }
            } else {
                TreeNode cur = queue.pollFirst();
                level.add(cur.val);
                if (cur.right != null) {
                    queue.offerLast(cur.right);
                }
                if (cur.left != null) {
                    queue.offerLast(cur.left);
                }
                if (cur == end) {
                    end = queue.peekFirst();
                    ans.add(level);
                    level = new ArrayList<>();
                    head = true;
                }
            }
        }
        return ans;
    }
}
