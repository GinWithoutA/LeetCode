package org.ginwithouta.leetcode;

import org.ginwithouta.leetcode.common.TreeNode;

import java.util.*;

/**
 * @author Ginwithouta
 * Generate at 2023/12/15
 * Problem 反转二叉树的奇数层
 */
public class Problem_2415_ReverseOddLevelsOfBinaryTree {

    /**
     * 解法一
     */
    public TreeNode reverseOddLevelsLevel(TreeNode root) {
        /*
         * 利用层次遍历，遍历每一层的时候交换元素就可以了
         */
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean odd = false;
        int levelCount = 1;
        while (!queue.isEmpty()) {
            TreeNode[] nodes = new TreeNode[levelCount];
            levelCount = 0;
            for (int i = 0; i < nodes.length; ++i) {
                nodes[i] = queue.poll();
                if (nodes[i].left != null) {
                    queue.add(nodes[i].left);
                    ++levelCount;
                }
                if (nodes[i].right != null) {
                    queue.add(nodes[i].right);
                    ++levelCount;
                }
            }
            if (odd) {
                int left = 0, right = nodes.length - 1;
                while (left < right) {
                    int temp = nodes[left].val;
                    nodes[left++].val = nodes[right].val;
                    nodes[right--].val = temp;
                }
            }
            odd ^= true;
        }
        return root;
    }

    /**
     * 解法二
     */
    public TreeNode reverseOddLevels(TreeNode root) {
        /*
         * 利用深度优先遍历，传入两个节点，每次遍历左节点的左孩子和右节点的右孩子对换
         * 左节点的右孩子和右节点的左孩子对换
         */
        process(root.left, root.right, true);
        return root;
    }

    public void process(TreeNode left, TreeNode right, boolean isOdd) {
        if (left == null) {
            return;
        }
        if (isOdd) {
            int temp = left.val;
            left.val = right.val;
            right.val = temp;
        }
        process(left.left, right.right, !isOdd);
        process(left.right, right.left, !isOdd);
    }
}
