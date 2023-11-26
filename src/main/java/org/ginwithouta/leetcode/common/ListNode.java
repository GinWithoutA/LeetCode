package org.ginwithouta.leetcode.common;

/**
 * 单链表节点类
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; this.next = null; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
