package org.ginwithouta.leetcode.interview150;

/**
 * @author Ginwithouta
 * Generate at 2024/4/7
 * LeetCode 面试经典 150 随机链表的复制
 */
public class LeetCode_Interview_060_CopyListWithRandomPointer {
    public static class Node {
        int val;
        Node next;
        Node random;
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        while (cur != null) {
            Node node = new Node(cur.val);
            node.next = cur.next;
            cur.next = node;
            cur = node.next;
        }
        cur = head;
        while (cur != null) {
            cur.next.random = cur.random == null ? null : cur.random.next;
            cur = cur.next.next;
        }
        Node dummy = new Node(0), node = dummy;
        cur = head;
        while (cur != null) {
            node.next = cur.next;
            cur.next = cur.next.next;
            node = node.next;
            cur = cur.next;
        }
        return dummy.next;
    }
}
