package org.ginwithouta.leetcode.company.meituan;

import org.ginwithouta.leetcode.common.ListNode;

/**
 * @author Ginwithouta
 * Generate at 2024/3/8
 * LeetCode 美团 合并两个有序链表
 */
public class LeetCode_Metituan_002_MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }
        ListNode dummy = new ListNode();
        ListNode left = list1, right = list2, cur = dummy;
        while (true) {
            if (left == null) {
                cur.next = right;
                break;
            }
            if (right == null) {
                cur.next = left;
                break;
            }
            if (left.val <= right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
