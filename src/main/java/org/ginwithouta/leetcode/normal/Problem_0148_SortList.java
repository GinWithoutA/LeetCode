package org.ginwithouta.leetcode.normal;

import org.ginwithouta.leetcode.common.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Ginwithouta
 * Generate at 2024/1/31
 * Problem 排序链表
 */
public class Problem_0148_SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        Deque<ListNode> queue = new LinkedList<>();
        ListNode cur = head, next, dummy = new ListNode(0);
        while (cur != null) {
            next = cur.next;
            cur.next = null;
            queue.add(cur);
            cur = next;
        }
        while (queue.size() != 1) {
            ListNode first = queue.poll(), second = queue.poll();
            dummy.next = null;
            cur = dummy;
            while (first != null && second != null) {
                if (first.val <= second.val) {
                    cur.next = first;
                    first = first.next;
                } else {
                    cur.next = second;
                    second = second.next;
                }
                cur = cur.next;
            }
            cur.next = first != null ? first : second;
            queue.offer(dummy.next);
        }
        return queue.poll();
    }

    /**
     * 使用计数排序进行计算
     */
    public ListNode sortListBest(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        ListNode cur = head;
        while (cur != null) {
            min = Math.min(min, cur.val);
            max = Math.max(max, cur.val);
            cur = cur.next;
        }
        int[] count = new int[max - min + 1];
        cur = head;
        while (cur != null) {
            ++count[cur.val - min];
            cur = cur.next;
        }
        cur = head;
        for (int i = 0; i < count.length; ++i) {
            while (count[i] > 0) {
                cur.val = i + min;
                cur = cur.next;
                --count[i];
            }
        }
        return head;
    }
}
