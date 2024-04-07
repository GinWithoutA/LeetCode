package org.ginwithouta.leetcode.interview150;

import org.ginwithouta.leetcode.common.ListNode;

/**
 * @author Ginwithouta
 * Generate at 2024/4/7
 * LeetCode 面试经典 150 两数相加
 */
public class LeetCode_Interview_058_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(), cur = dummy;
        int in = 0;
        while (l1 != null || l2 != null) {
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;
            int val = (num1 + num2 + in) % 10;
            in = (num1 + num2 + in) / 10;
            cur.next = new ListNode(val);
            cur = cur.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (in != 0) {
            cur.next = new ListNode(in);
        }
        return dummy.next;
    }
}
