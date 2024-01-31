package org.ginwithouta.leetcode;

import org.ginwithouta.leetcode.common.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Ginwithouta
 * Generate at 2024/1/26
 * Problem 二叉树的右视图
 */
public class Problem_0199_BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        /*
         * 层序遍历找每一层最右边的节点
         */
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        TreeNode levelEnd = root, nextLevelEnd = root, cur;
        queue.offer(root);
        while (!queue.isEmpty()) {
            cur = queue.poll();
            if (cur.left != null) {
                queue.offer(cur.left);
                nextLevelEnd = cur.left;
            }
            if (cur.right != null) {
                queue.offer(cur.right);
                nextLevelEnd = cur.right;
            }
            if (cur == levelEnd) {
                ans.add(cur.val);
                levelEnd = nextLevelEnd;
            }
        }
        return ans;
    }
}
