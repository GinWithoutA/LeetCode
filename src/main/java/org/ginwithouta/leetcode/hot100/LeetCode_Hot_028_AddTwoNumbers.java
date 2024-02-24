package org.ginwithouta.leetcode.hot100;

import org.ginwithouta.leetcode.common.ListNode;

/**
 * @author Ginwithouta
 * Generate at 2024/2/21
 * LeetCode Hot 100 两数相加
 */
public class LeetCode_Hot_028_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int in = 0, a, b, sum;
        ListNode dummyNode = new ListNode(), prev = dummyNode;
        while (l1 != null || l2 != null) {
            a = l1 == null ? 0 : l1.val;
            b = l2 == null ? 0 : l2.val;
            sum = a + b + in;
            prev.next = new ListNode(sum % 10);
            in = sum / 10;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            prev = prev.next;
        }
        if (in > 0) {
            prev.next = new ListNode(in);
        }
        return dummyNode.next;
    }
}
