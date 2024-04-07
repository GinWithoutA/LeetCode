package org.ginwithouta.leetcode.interview150;

import org.ginwithouta.leetcode.common.ListNode;

import java.time.Duration;

/**
 * @author Ginwithouta
 * Generate at 2024/4/7
 * LeetCode 面试经典 150 合并两个有序链表
 */
public class LeetCode_Interview_059_MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(), cur = dummy;
        while (list1 != null && list2 != null) {
            cur.next = list1.val <= list2.val ? list1 : list2;
            cur = cur.next;
            if (cur == list1) {
               list1 = list1.next;
            } else {
                list2 = list2.next;
            }
        }
        if (list1 != null) {
            cur.next = list1;
        }
        if (list2 != null) {
            cur.next = list2;
        }
        return dummy.next;
    }
}
