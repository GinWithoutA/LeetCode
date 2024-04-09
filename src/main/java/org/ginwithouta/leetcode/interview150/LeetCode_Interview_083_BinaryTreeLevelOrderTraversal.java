package org.ginwithouta.leetcode.interview150;

import org.ginwithouta.leetcode.common.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Ginwithouta
 * Generate at 2024/4/9
 * LeetCode 面试经典 150 二叉树的层序遍历
 */
public class LeetCode_Interview_083_BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        TreeNode cur, end = root;
        queue.offerLast(root);
        while (!queue.isEmpty()) {
            cur = queue.pollFirst();
            res.add(cur.val);
            if (cur.left != null) {
                queue.offerLast(cur.left);
            }
            if (cur.right != null) {
                queue.offerLast(cur.right);
            }
            if (cur == end) {
                ans.add(res);
                res = new ArrayList<>();
                end = queue.peekLast();
            }
        }
        return ans;
    }
}
