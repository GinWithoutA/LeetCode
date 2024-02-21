package org.ginwithouta.leetcode.hot100;

import org.ginwithouta.leetcode.common.ListNode;

/**
 * @author Ginwithouta
 * Generate at 2024/2/21
 * LeetCode Hot 100 删除链表的倒数第 N 个结点
 */
public class LeetCode_Hot_0019_RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) {
            return null;
        }
        ListNode dummy = new ListNode(), prev = dummy, cur = head;
        dummy.next = head;
        while (n != 0) {
            cur = cur.next;
            --n;
        }
        while (cur != null) {
            prev = prev.next;
            cur = cur.next;
        }
        cur = prev.next;
        prev.next = cur.next;
        cur.next = null;
        return dummy.next;
    }
}
