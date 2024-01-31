package org.ginwithouta.leetcode;

import org.ginwithouta.leetcode.common.ListNode;

/**
 * @author Ginwithouta
 * Generate at 2024/1/23
 */
public class Problem_0086_PartitionList {
    public static ListNode partition(ListNode head, int x) {
        /*
         * 还是一样，先给一个虚拟头节点，然后遍历，找到一个比目标值小的结点，就继续找，
         * 找到一撮后把这一搓结点往前塞，更新塞入的末尾位置，然后继续往后找，直到结束
         */
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode cur = head, movePre = dummyNode, end, startPre = dummyNode, start;
        while (cur != null) {
            if (cur.val < x) {
                end = cur;
                while (end.next != null && end.next.val < x) {
                    end = end.next;
                }
                if (cur == head) {
                    movePre = end;
                    cur = end.next;
                    startPre = movePre;
                } else {
                    start = cur;
                    startPre.next = end.next;
                    end.next = movePre.next;
                    movePre.next = start;
                    movePre = end;
                    cur = startPre.next;
                }
            } else {
                cur = cur.next;
                startPre = startPre.next;
            }
        }
        return dummyNode.next;
    }
}
