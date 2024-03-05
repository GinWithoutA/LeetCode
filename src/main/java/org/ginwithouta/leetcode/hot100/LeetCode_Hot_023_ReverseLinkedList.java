package org.ginwithouta.leetcode.hot100;

import org.ginwithouta.leetcode.common.ListNode;

/**
 * @author Ginwithouta
 * Generate at 2024/2/20
 * LeetCode Hot 100 反转链表
 */
public class LeetCode_Hot_023_ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode cur = head, pre = null, next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
