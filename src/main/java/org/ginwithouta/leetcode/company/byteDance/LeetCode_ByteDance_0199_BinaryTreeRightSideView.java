package org.ginwithouta.leetcode.company.byteDance;

import org.ginwithouta.leetcode.common.tree.TreeNode;

import java.util.*;

/**
 * @author Ginwithouta
 * Generate at 2024/3/15
 * LeetCode 字节跳动 二叉树的右视图
 */
public class LeetCode_ByteDance_0199_BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offerLast(root);
        TreeNode end = root;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.pollFirst();
            if (cur.left != null) {
                queue.offerLast(cur.left);
            }
            if (cur.right != null) {
                queue.offerLast(cur.right);
            }
            if (end == cur) {
                end = queue.peekLast();
                ans.add(cur.val);
            }
        }
        return ans;
    }
}
