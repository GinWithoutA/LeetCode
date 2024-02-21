package org.ginwithouta.leetcode.hot100;

import org.ginwithouta.leetcode.common.ListNode;

/**
 * @author Ginwithouta
 * Generate at 2024/2/21
 * LeetCode Hot 100 合并两个有序链表
 */
public class LeetCode_Hot_0021_MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }
        ListNode big = list1.val >= list2.val ? list1 : list2, small = big == list1 ? list2 : list1;
        ListNode head = small, cur = head;
        small = small.next;
        while (big != null && small != null) {
            if (big.val <= small.val) {
                cur.next = big;
                big = big.next;
            } else {
                cur.next = small;
                small = small.next;
            }
            cur = cur.next;
        }
        if (big == null) {
            cur.next = small;
        }
        if (small == null) {
            cur.next = big;
        }
        return head;
    }
}
