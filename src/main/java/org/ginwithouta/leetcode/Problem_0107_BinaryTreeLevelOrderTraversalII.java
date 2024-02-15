package org.ginwithouta.leetcode;

import org.ginwithouta.leetcode.common.tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Ginwithouta
 * Generate at 2024/2/15
 * 二叉树的层序遍历Ⅱ
 */
public class Problem_0107_BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        List<Integer> level = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        TreeNode cur, end = root, nextEnd = root;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            level.add(cur.val);
            if (cur.left != null) {
                queue.offer(cur.left);
                nextEnd = cur.left;
            }
            if (cur.right != null) {
                queue.offer(cur.right);
                nextEnd = cur.right;
            }
            if (cur == end) {
                res.addFirst(level);
                level = new ArrayList<>();
                end = nextEnd;
            }
        }
        return new ArrayList<>(res);
    }
}
