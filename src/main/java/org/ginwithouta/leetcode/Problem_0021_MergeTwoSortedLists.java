package org.ginwithouta.leetcode;

import org.ginwithouta.leetcode.common.tree.ListNode;

/**
 * @author Ginwithouta
 * Generate at 2024/1/22
 * Problem 合并两个有序链表
 */
public class Problem_0021_MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        /*
         * 双指针，只要小的就不断跳，直到两个链表都结束了
         */
        if (list1 == null && list2 == null) {
            return null;
        }
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode root = null, cur = null;
        while (true) {
            if (list1 == null) {
                cur.next = list2;
                break;
            }
            if (list2 == null) {
                cur.next = list1;
                break;
            }
            if (list1.val <= list2.val) {
                if (root == null) {
                    root = list1;
                    cur = root;
                    list1 = list1.next;
                } else {
                    cur.next = list1;
                    list1 = list1.next;
                    cur = cur.next;
                }
            } else {
                if (root == null) {
                    root = list2;
                    cur = root;
                    list2 = list2.next;
                } else {
                    cur.next = list2;
                    list2 = list2.next;
                    cur = cur.next;
                }
            }
        }
        return root;
    }
}
