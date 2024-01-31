package org.ginwithouta.leetcode;

import org.ginwithouta.leetcode.common.ListNode;

/**
 * @author Ginwithouta
 * Generate at 2023/11/28
 * Problem 两数之和
 */
public class Problem_0002_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /*
         * 这题主要考察编码能力
         * 基本的思路就是遍历 l1 和 l2 两个链表，只要有一个不为空，就加到新的链表中，并记录进位信息
         * 最后再判断是否存在进位信息看是否需要一个新的节点即可
         */
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode node1 = l1, node2 = l2, root = null, cur = null;
        int n1, n2, ca = 0, n;
        while (node1 != null || node2 != null) {
            n1 = node1 == null ? 0 : node1.val;
            n2 = node2 == null ? 0 : node2.val;
            n = n1 + n2 + ca;
            ca = n / 10;
            if (cur == null) {
                cur = new ListNode(n % 10);
                root = cur;
            } else {
                cur.next = new ListNode(n % 10);
                cur = cur.next;
            }
            node1 = node1 == null ? node1 : node1.next;
            node2 = node2 == null ? node2 : node2.next;
        }
        if (ca > 0) {
            cur.next = new ListNode(ca);
        }
        return root;
    }
}
