package org.ginwithouta.leetcode.company.byteDance;

import org.ginwithouta.leetcode.common.ListNode;

/**
 * @author Ginwithouta
 * Generate at 2024/3/15
 * LeetCode 字节跳动 K个一组反转链表
 */
public class LeetCode_ByteDance_0025_ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }
        ListNode dummy = new ListNode(), prev = dummy, start = head, end = start, next;
        dummy.next = head;
        while (start != null) {
            for (int i = 1; i < k && end != null; ++i) {
                end = end.next;
            }
            if (end == null) {
                return dummy.next;
            }
            next = end.next;
            end.next = null;
            prev.next = reverse(start);
            start.next = next;
            prev = start;
            start = next;
            end = start;
        }
        return dummy.next;
    }
    private ListNode reverse(ListNode root) {
        ListNode prev = null, cur = root, next;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
