package org.ginwithouta.leetcode.interview150;

import org.ginwithouta.leetcode.common.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ginwithouta
 * Generate at 2024/4/8
 * LeetCode 面试经典 150 二叉搜索树迭代器
 */
public class LeetCode_Interview_078_BinarySearchTreeIterator {
    static class BSTIterator {
        List<TreeNode> list;
        int idx;
        public BSTIterator(TreeNode root) {
            this.list = new ArrayList<>();
            this.idx = -1;
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
            return this.list.get(++this.idx).val;
        }

        public boolean hasNext() {
            return this.idx < this.list.size() - 1;
        }
    }
}
