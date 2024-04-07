package org.ginwithouta.leetcode.interview150;

import org.ginwithouta.leetcode.common.ListNode;

/**
 * @author Ginwithouta
 * Generate at 2024/4/7
 * LeetCode 面试经典 150 删除链表的倒数第N个节点
 */
public class LeetCode_Interview_063_RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(), prev = dummy, next;
        dummy.next = head;
        for (int i = 1; i < n; ++i) {
            head = head.next;
        }
        while (head.next != null) {
            head = head.next;
            prev = prev.next;
        }
        next = prev.next;
        prev.next = next.next;
        next.next = null;
        return dummy.next;
    }
}
