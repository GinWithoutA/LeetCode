package org.ginwithouta.leetcode.interview150;

import org.ginwithouta.leetcode.common.ListNode;

/**
 * @author Ginwithouta
 * Generate at 2024/4/7
 * LeetCode 面试经典 150 反转链表Ⅱ
 */
public class LeetCode_Interview_061_ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(), prev = dummy;
        dummy.next = head;
        int idx = 1;
        while (idx < left) {
            head = head.next;
            prev = prev.next;
            ++idx;
        }
        ListNode start = head;
        while (idx < right) {
            head = head.next;
            ++idx;
        }
        ListNode endNext = head.next;
        prev.next = null;
        head.next = null;
        prev.next = reverse(start);
        start.next = endNext;
        return dummy.next;
    }
    private ListNode reverse(ListNode head) {
        ListNode prev = null, next;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
