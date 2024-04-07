package org.ginwithouta.leetcode.interview150;

import org.ginwithouta.leetcode.common.ListNode;

/**
 * @author Ginwithouta
 * Generate at 2024/4/7
 * LeetCode 面试经典 150 删除排序链表中的重复元素Ⅱ
 */
public class LeetCode_Interview_064_RemoveCuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(), prev = dummy, cur = head;
        dummy.next = head;
        while (cur != null) {
            while (cur.next != null && cur.next.val == cur.val) {
                cur = cur.next;
            }
            if (prev.next == cur) {
                cur = cur.next;
                prev = prev.next;
            } else {
                prev.next = cur.next;
                cur.next = null;
                cur = prev.next;
            }
        }
        return dummy.next;
    }
}
