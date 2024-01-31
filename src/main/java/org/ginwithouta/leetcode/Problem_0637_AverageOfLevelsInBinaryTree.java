package org.ginwithouta.leetcode;

import org.ginwithouta.leetcode.common.tree.TreeNode;

import java.util.*;

/**
 * @author Ginwithouta
 * Generate at 2024/1/26
 */
public class Problem_0637_AverageOfLevelsInBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        /*
         * 注意溢出问题
         */
        if (root.left == null && root.right == null) {
            return List.of((double) root.val);
        }
        double levelSum = 0D;
        int levelCount = 0;
        TreeNode levelEnd = root, nextLevelEnd = root, cur;
        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> ans = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            cur = queue.poll();
            ++levelCount;
            levelSum += cur.val;
            if (cur.left != null) {
                queue.offer(cur.left);
                nextLevelEnd = cur.left;
            }
            if (cur.right != null) {
                queue.offer(cur.right);
                nextLevelEnd = cur.right;
            }
            if (cur == levelEnd) {
                ans.add(levelSum / levelCount);
                levelSum = 0D;
                levelCount = 0;
                levelEnd = nextLevelEnd;
            }
        }
        return ans;
    }
}
