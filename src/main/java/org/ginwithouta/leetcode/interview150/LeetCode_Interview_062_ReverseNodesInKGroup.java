package org.ginwithouta.leetcode.interview150;

import org.ginwithouta.leetcode.common.ListNode;

/**
 * @author Ginwithouta
 * Generate at 2024/4/7
 * LeetCode 面试经典 150 K 个一组反转链表
 */
public class LeetCode_Interview_062_ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(), prev = dummy, start, endNext;
        dummy.next = head;
        while (head != null) {
            start = head;
            int idx = 1;
            while (idx < k && head != null) {
                head = head.next;
                ++idx;
            }
            if (head == null) {
                return dummy.next;
            }
            endNext = head.next;
            prev.next = null;
            head.next = null;
            prev.next = reverse(start);
            start.next = endNext;
            prev = start;
            head = endNext;
        }
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
