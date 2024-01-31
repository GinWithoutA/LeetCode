package org.ginwithouta.leetcode;

import org.ginwithouta.leetcode.common.ListNode;

/**
 * @author Ginwithouta
 * Generate at 2024/1/22
 * Problem 随机链表复制
 */
public class Problem_0138_CopyListWithRandomPointer {
    public ListNode copyRandomList(ListNode head) {
        /*
         * 一个很好的方式就是现在原链表中，插入拷贝节点，同时就可以获取 random 节点
         * 接着再把两个链表拆分出来就可以了。最后记得要把原链表的最后一个节点置为空
         */
        if (head == null) {
            return null;
        }
        ListNode node = head;
        while (node != null) {
            ListNode insert = new ListNode(node.val);
            insert.next = node.next;
            node.next = insert;
            node = insert.next;
        }
        node = head;
        while (node != null) {
            if (node.random != null) {
                node.next.random = node.random.next;
            }
            node = node.next.next;
        }
        node = head.next;
        ListNode pre = head, newHead = node;
        while (node.next != null) {
            pre.next = node.next;
            pre = node.next;
            node.next = node.next.next;
            node = node.next;
        }
        pre.next = null;
        return newHead;
    }
}
