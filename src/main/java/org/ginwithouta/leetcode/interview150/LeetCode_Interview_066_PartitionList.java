package org.ginwithouta.leetcode.interview150;

import org.ginwithouta.leetcode.common.ListNode;

/**
 * @author Ginwithouta
 * Generate at 2024/4/7
 * LeetCode 面试经典 150 分隔链表
 */
public class LeetCode_Interview_066_PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(), cur = dummy, prev = dummy;
        dummy.next = head;
        while (head != null) {
            if (head.val < x) {
                if (cur.next != head) {
                    prev.next = head.next;
                    head.next = cur.next;
                    cur.next = head;
                    head = prev.next;
                } else {
                    head = head.next;
                    prev = prev.next;
                }
                cur = cur.next;

            } else {
                prev = prev.next;
                head = head.next;
            }
        }
        return dummy.next;
    }
}
