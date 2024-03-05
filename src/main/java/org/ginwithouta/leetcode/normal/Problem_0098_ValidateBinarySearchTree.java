package org.ginwithouta.leetcode.normal;

import org.ginwithouta.leetcode.common.tree.TreeNode;

/**
 * @author Ginwithouta
 * Generate at 2024/1/26
 * Problem 验证二叉搜索树
 */
public class Problem_0098_ValidateBinarySearchTree {
    private long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        /*
         * 使用递归，如果在参数中传递 pre 值，那么无法返回上层的递归中，因此使用额外的变量来保存 pre 值
         */
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        return isValidBST(root.right);
    }

}
