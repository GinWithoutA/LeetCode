package org.ginwithouta.leetcode;

import org.ginwithouta.leetcode.common.tree.ListNode;

/**
 * @author Ginwithouta
 * Generate at 2024/1/23
 * Problem 删除链表的倒数第 N 个节点
 */
public class Problem_0019_RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        /*
         * 碰到单链表可能会改变头节点的，都使用一个 dummyNode 当作虚拟头节点，然后进行操作
         */
        ListNode dummyNode = new ListNode(0), fast = head, slow = dummyNode;
        dummyNode.next = head;
        for (int i = 1; i < n; ++i) {
            fast = fast.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        fast = slow.next;
        slow.next = fast.next;
        fast.next = null;
        return dummyNode.next;
    }
}
