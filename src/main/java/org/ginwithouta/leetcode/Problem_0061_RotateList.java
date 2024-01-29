package org.ginwithouta.leetcode;

import org.ginwithouta.leetcode.common.tree.ListNode;

/**
 * @author Ginwithouta
 * Generate at 2024/1/23
 * Problem 旋转链表
 */
public class Problem_0061_RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        /*
         * 先用一个虚拟节点代表头节点，旋转几次就是就后几位结点放到前面，因此我们需要
         * 找到最终旋转的次数。先遍历一次得到总的结点个数，然后计算需要旋转的次数。
         */
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode dummyNode = new ListNode(0), pre = dummyNode, cur = head;
        dummyNode.next = head;
        int n = 0;
        while (cur != null) {
            ++n;
            cur = cur.next;
        }
        if (k >= n && k % n == 0) {
            return dummyNode.next;
        }
        n = k > n ? k % n : k;
        cur = head;
        for (int i = 1; i < n; ++i) {
            cur = cur.next;
        }
        while (cur.next != null) {
            cur = cur.next;
            pre = pre.next;
        }
        head = pre.next;
        pre.next = null;
        cur.next = dummyNode.next;
        dummyNode.next = head;
        return dummyNode.next;
    }
}
