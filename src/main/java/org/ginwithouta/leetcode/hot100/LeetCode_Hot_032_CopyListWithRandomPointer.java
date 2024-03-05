package org.ginwithouta.leetcode.hot100;

/**
 * @author Ginwithouta
 * Generate at 2024/2/21
 */
public class LeetCode_Hot_032_CopyListWithRandomPointer {
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
        Node dummy = new Node(-1), pre, cur = head;
        while (cur != null) {
            Node node = new Node(cur.val);
            node.next = cur.next;
            cur.next = node;
            cur = node.next;
        }
        pre = head;
        while (pre != null) {
            cur = pre.next;
            cur.random = pre.random == null ? null : pre.random.next;
            pre = cur.next;
        }
        cur = head;
        pre = dummy;
        while (cur != null) {
            pre.next = cur.next;
            cur.next = cur.next.next;
            cur = cur.next;
            pre = pre.next;
        }
        return dummy.next;
    }
}
