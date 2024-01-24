package org.ginwithouta.leetcode;

import org.ginwithouta.leetcode.common.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Ginwithouta
 * Generate at 2024/1/24
 * Problem 填充每个结点的下一个右侧结点指针
 */
public class Problem_0117_PopulatingNextRightPointersInEachNodeII {
    /**
     * 一般解法，层次遍历
     */
    public Node connect(Node root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        Node pre = null, levelEnd = root, nextLevelEnd = root, cur;
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
            if (pre != null) {
                pre.next = cur;
            }
            if (cur == levelEnd) {
                levelEnd = nextLevelEnd;
                pre = null;
            } else {
                pre = cur;
            }
        }
        return root;
    }

    /**
     * 另一种层次遍历的解法
     */
    public Node process(Node root) {
        /*
         * 在遍历每一个父节点的时候，我们假设下一层有一个虚拟 pre 结点，每当该父节点有孩子，就将 pre 和孩子相连，然后 pre 移动
         * 直到遍历完一层之后，当前结点就可以跳到 pre.next ，当 pre.next 也为空的时候，就说明没有结点了
         */
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        Node cur = root;
        while (cur != null) {
            Node dummyNode = new Node(0), pre = dummyNode;
            while (cur != null) {
                if (cur.left != null) {
                    pre.next = cur.left;
                    pre = pre.next;
                }
                if (cur.right != null) {
                    pre.next = cur.right;
                    pre = pre.next;
                }
                cur = cur.next;
            }
            cur = dummyNode.next;
        }
        return root;
    }
}
