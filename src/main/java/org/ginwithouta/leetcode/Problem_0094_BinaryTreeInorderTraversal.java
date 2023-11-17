package org.ginwithouta.leetcode;

import org.ginwithouta.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树的根节点 root ，返回它的中序遍历。
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 */
public class Problem_0094_BinaryTreeInorderTraversal {
    /**
     * Morris 遍历
     * 如果存在左孩子，那么找到当前节点的前驱节点，即左孩子的最右子孙节点，将其指向当前节点，然后当前节点跳到左孩子
     * 如果没有左孩子，那么直接跳到右孩子指向的节点
     * 如果此时当前节点等于刚才找到的最右子孙节点的右孩子，那么表明此时当前节点第二次访问，把刚才找到的最右子孙节点的右孩子置为空
     * 重复，直到当前节点变为 null
     */
    public List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        if (root.left == null && root.right == null) {
            result.add(root.value);
            return result;
        }
        TreeNode cur = root, mostRight;
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
            result.add(cur.value);
            cur = cur.right;
        }
        return result;
    }
}
