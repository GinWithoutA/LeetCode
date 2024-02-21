package org.ginwithouta.leetcode.hot100;

import org.ginwithouta.leetcode.common.tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Ginwithouta
 * Generate at 2024/2/21
 */
public class LeetCode_Hot_041_BinaryTreeLevelOrderTravseral {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Deque<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> level = new ArrayList<>();
        TreeNode cur, end = root;
        queue.add(root);
        while (!queue.isEmpty()) {
            cur = queue.poll();
            level.add(cur.val);
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
            if (cur == end) {
                ans.add(level);
                level = new ArrayList<>();
                end = queue.peekLast();
            }
        }
        return ans;
    }
}
