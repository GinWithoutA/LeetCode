package org.ginwithouta.leetcode.hot100;

import org.ginwithouta.leetcode.common.ListNode;

/**
 * @author Ginwithouta
 * Generate at 2024/2/21
 * LeetCode Hot 100 两两交换链表中的结点
 */
public class LeetCode_Hot_0024_SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(), prev = dummy, first = head, second;
        dummy.next = head;
        while (first != null && first.next != null) {
            second = first.next;
            first.next = second.next;
            prev.next = second;
            second.next = first;
            prev = first;
            first = prev.next;
        }
        return dummy.next;
    }
}
