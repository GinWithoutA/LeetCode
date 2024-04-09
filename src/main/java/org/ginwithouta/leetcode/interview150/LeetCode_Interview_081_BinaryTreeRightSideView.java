package org.ginwithouta.leetcode.interview150;

import org.ginwithouta.leetcode.common.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Ginwithouta
 * Generate at 2024/4/9
 * LeetCode 面试经典 150 二叉树的右视图
 */
public class LeetCode_Interview_081_BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        queue.offerLast(root);
        TreeNode cur, end = root;
        while (!queue.isEmpty()) {
            cur = queue.pollFirst();
            if (cur.left != null) {
                queue.offerLast(cur.left);
            }
            if (cur.right != null) {
                queue.offerLast(cur.right);
            }
            if (cur == end) {
                ans.add(cur.val);
                end = queue.peekLast();
            }
        }
        return ans;
    }
}
