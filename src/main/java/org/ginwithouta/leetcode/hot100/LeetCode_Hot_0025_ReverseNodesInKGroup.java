package org.ginwithouta.leetcode.hot100;

import org.ginwithouta.leetcode.common.ListNode;

/**
 * @author Ginwithouta
 * Generate at 2024/2/21
 */
public class LeetCode_Hot_0025_ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(), end = head, pre = dummy, start, next;
        dummy.next = head;
        while (true) {
            for (int i = 1; i < k && end != null; ++i) {
                end = end.next;
            }
            if (end == null) {
                return dummy.next;
            }
            start = pre.next;
            next = end.next;
            end.next = null;
            pre.next = reverse(pre.next);
            start.next = next;
            pre = start;
            end = next;
        }
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null, cur = head, next;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
