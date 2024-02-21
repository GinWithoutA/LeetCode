package org.ginwithouta.leetcode.hot100;

import lombok.val;
import org.ginwithouta.leetcode.common.tree.TreeNode;

/**
 * @author Ginwithouta
 * Generate at 2024/2/21
 * LeetCode Hot 100 验证二叉搜索树
 */
public class LeetCode_Hot_043_ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if (root.left == null && root.right == null) {
            return true;
        }
        TreeNode cur = root, mostRight;
        Integer prev = null;
        while (cur != null) {
            if (cur.left != null) {
                mostRight = cur.left;
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }
                mostRight.right = null;
            }
            if (prev != null && cur.val <= prev) {
                return false;
            }
            prev = cur.val;
            cur = cur.right;
        }
        return true;
    }
}
