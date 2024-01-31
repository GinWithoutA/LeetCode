package org.ginwithouta.leetcode;

import org.ginwithouta.leetcode.common.ListNode;

/**
 * @author Ginwithouta
 * Generate at 2024/1/23
 * Problem 删除排序链表中的重复元素Ⅱ
 */
public class Problem_0082_RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        /*
         * 首先给定一个虚拟头节点，然后每遍历一个节点，就往后遍历看是否有相同节点，有就
         * 删除，没有就继续前进
         */
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyNode = new ListNode(0), pre = dummyNode, cur = head, end;
        dummyNode.next = head;
        while (cur != null) {
            end = cur;
            while (end.next != null && end.next.val == cur.val) {
                end = end.next;
            }
            if (end == cur) {
                pre = cur;
                cur = cur.next;
            } else {
                pre.next = end.next;
                end.next = null;
                cur = pre.next;
            }
        }
        return dummyNode.next;
    }
}
