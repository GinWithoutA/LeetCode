package org.ginwithouta.leetcode;

import org.ginwithouta.leetcode.common.tree.ListNode;

/**
 * @author Ginwithouta
 * Generate at 2024/1/23
 * Problem K个一组反转链表
 */
public class Problem_0025_ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        /*
         * 首先我们给定一个 dummyNode 当作是新的首节点，这样可以简化后续对头节点的处理
         * 基本的思路就是找到每一组节点的头和尾，同时记录此组节点的头的前驱和尾的后继，
         * 然后处理，直到在找某一组节点的时候出现了 null ，就跳出循环
         */
        if (head.next == null || k == 1) {
            return head;
        }
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode, end = dummyNode, start, next;
        while (end.next != null) {
            for (int i = 0; i < k && end != null; ++i) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            // 记录此组的前驱和后继
            start = pre.next;
            next = end.next;
            // 断开
            pre.next = null;
            end.next = null;
            reverse(start);
            // 重新接上
            pre.next = end;
            start.next = next;
            // 将 pre 和 end 的位置进行更新
            pre = start;
            end = start;
        }
        return dummyNode.next;
    }

    public void reverse(ListNode head) {
        ListNode pre = null, cur = head, next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }
}
