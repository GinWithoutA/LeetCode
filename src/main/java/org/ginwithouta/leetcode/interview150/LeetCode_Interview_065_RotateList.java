package org.ginwithouta.leetcode.interview150;

import org.ginwithouta.leetcode.common.ListNode;

/**
 * @author Ginwithouta
 * Generate at 2024/4/7
 * LeetCode 面试经典 150 旋转链表
 */
public class LeetCode_Interview_065_RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(), prev = dummy;
        dummy.next = head;
        int count = 0;
        while (head != null) {
            head = head.next;
            ++count;
        }
        k = k % count;
        if (k == 0) {
            return dummy.next;
        }
        head = dummy.next;
        while (k-- != 1) {
            head = head.next;
        }
        while (head.next != null) {
            head = head.next;
            prev = prev.next;
        }
        head.next = dummy.next;
        dummy.next = prev.next;
        prev.next = null;
        return dummy.next;
    }

}
