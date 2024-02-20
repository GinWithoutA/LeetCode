package org.ginwithouta.leetcode.hot100;

import org.ginwithouta.leetcode.common.ListNode;

/**
 * @author Ginwithouta
 * Generate at 2024/2/20
 * LeetCode Hot 100 回文链表
 */
public class LeetCode_Hot_0234_PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head.next == null) {
            return true;
        }
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode reverseHead = reverse(slow.next, slow), temp = reverseHead;
        slow.next = null;
        fast = head;
        boolean ans = true;
        while (fast != null) {
            if (fast.val != temp.val) {
                ans = false;
                break;
            }
            fast =fast.next;
            temp = temp.next;
        }
        slow.next = reverse(reverseHead, null);
        return ans;
    }
    public ListNode reverse(ListNode head, ListNode pre) {
        ListNode cur = head, next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
