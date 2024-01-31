package org.ginwithouta.leetcode;

import org.ginwithouta.leetcode.common.ListNode;

/**
 * @author Ginwithouta
 * Generate at 2024/1/22
 * Problem 环形链表
 */
public class Problem_0141_LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        /*
         * 对于一个环形链表，遍历链表，如果碰到空，说明一定不会有环存在
         */
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
