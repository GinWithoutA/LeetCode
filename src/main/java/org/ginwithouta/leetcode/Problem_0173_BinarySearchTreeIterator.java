package org.ginwithouta.leetcode;

import org.ginwithouta.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ginwithouta
 * Generate at 2024/1/25
 * Problem 二叉搜索树迭代器
 */
public class Problem_0173_BinarySearchTreeIterator {
    public static class BSTIterator {
        /*
         * Morris 遍历
         */
        private final List<TreeNode> list;
        private int idx;
        public BSTIterator(TreeNode root) {
            this.list = new ArrayList<>();
            this.idx = 0;
            morris(root);
        }

        private void morris(TreeNode root) {
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
                this.list.add(cur);
                cur = cur.right;
            }
        }

        public int next() {
            return this.list.get(this.idx++).val;
        }

        public boolean hasNext() {
            return this.idx != this.list.size();
        }
    }
}
