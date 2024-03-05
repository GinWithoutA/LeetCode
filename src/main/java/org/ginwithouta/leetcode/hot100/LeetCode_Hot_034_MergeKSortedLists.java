package org.ginwithouta.leetcode.hot100;

import org.ginwithouta.leetcode.common.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Ginwithouta
 * Generate at 2024/2/21
 * LeetCode Hot 100 合并 K 个升序链表
 */
public class LeetCode_Hot_034_MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> smallHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (ListNode list : lists) {
            if (list != null) {
                smallHeap.offer(list);
            }
        }
        if (smallHeap.isEmpty()) {
            return null;
        }
        ListNode dummy = new ListNode(), pre = dummy, cur;
        while (!smallHeap.isEmpty()) {
            cur = smallHeap.poll();
            pre.next = cur;
            pre = pre.next;
            if (cur.next != null) {
                smallHeap.offer(cur.next);
            }
        }
        return dummy.next;
    }
}
