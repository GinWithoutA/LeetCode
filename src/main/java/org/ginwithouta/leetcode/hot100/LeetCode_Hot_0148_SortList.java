package org.ginwithouta.leetcode.hot100;

import org.ginwithouta.leetcode.common.ListNode;

/**
 * @author Ginwithouta
 * Generate at 2024/2/21
 */
public class LeetCode_Hot_0148_SortList {
    public ListNode sortList(ListNode head) {
        /*
         * 二分，递归下去，然后合并，返回合并后的头节点
         */
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode rightStart = slow.next;
        slow.next = null;
        ListNode sortLeft = sortList(head), sortRight = sortList(rightStart);
        return mergeList(sortLeft, sortRight);
    }

    public ListNode mergeList(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return head1 == null ? head2 : head1;
        }
        ListNode small = head1.val <= head2.val ? head1 : head2, big = small == head1 ? head2 : head1, head = small, prev = head;
        small = small.next;
        while (small != null && big != null) {
            if (small.val <= big.val) {
                prev.next = small;
                small = small.next;
            } else {
                prev.next = big;
                big = big.next;
            }
            prev = prev.next;
        }
        if (small == null) {
            prev.next = big;
        }
        if (big == null) {
            prev.next = small;
        }
        return head;
    }
}
