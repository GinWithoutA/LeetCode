package org.ginwithouta.leetcode.interview150;

import org.ginwithouta.leetcode.common.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Ginwithouta
 * Generate at 2024/4/9
 * LeetCode 面试经典 150 二叉树的层平均值
 */
public class LeetCode_Interview_082_AverageOfLevelsInBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<Double> ans = new ArrayList<>();
        if (root == null) {
            return null;
        }
        TreeNode cur, end = root;
        queue.offerLast(root);
        double sum = 0;
        int count = 1;
        while (!queue.isEmpty()) {
            cur = queue.pollFirst();
            sum += cur.val;
            if (cur.left != null) {
                queue.offerLast(cur.left);
            }
            if (cur.right != null) {
                queue.offerLast(cur.right);
            }
            if (cur == end) {
                ans.add(sum / count);
                sum = 0;
                end = queue.peekLast();
                count = queue.size();
            }
        }
        return ans;
    }
}
