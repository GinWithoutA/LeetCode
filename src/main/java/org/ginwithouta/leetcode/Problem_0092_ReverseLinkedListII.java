package org.ginwithouta.leetcode;

import org.ginwithouta.leetcode.common.ListNode;

/**
 * @author Ginwithouta
 * Generate at 2024/1/22
 * Problem 反转链表Ⅱ
 */
public class Problem_0092_ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        /*
         * 总共可以分几个步骤：
         * 1）找到 left 节点和 right 节点
         * 2）分离 left 节点到 right 节点的链表出来
         * 3）反转中间链表
         * 4）重新连接
         */
        if (head.next == null || left == right) {
            return head;
        }
        ListNode dummyNode = new ListNode(-1), pre = dummyNode;
        dummyNode.next = head;
        for (int i = 0; i < left - 1; ++i) {
            pre = pre.next;
        }
        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; ++i) {
            rightNode = rightNode.next;
        }
        ListNode leftNode = pre.next, next = rightNode.next;
        pre.next = null;
        rightNode.next = null;
        reverse(leftNode);
        pre.next = rightNode;
        leftNode.next = next;
        return dummyNode.next;
    }
    public void reverse(ListNode head) {
        ListNode pre = null, cur = head, next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }
}
