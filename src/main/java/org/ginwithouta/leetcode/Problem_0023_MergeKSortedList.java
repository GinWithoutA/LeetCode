package org.ginwithouta.leetcode;

import org.ginwithouta.leetcode.common.tree.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Ginwithouta
 * Generate at 2023/11/26
 * Problem 合并 K 个有序单链表
 */
public class Problem_0023_MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        /*
         * 利用一个小根堆，将所有链表的当前节点放到小根堆中，每次选取最小的节点出来即可
         * 要注意每次把取出的节点的下一个节点放到小根堆中
         */
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        ListNode head = new ListNode(-1), cur = head, temp;
        for (ListNode list : lists) {
            // 可能传入 null
            if (list != null) {
                minHeap.offer(list);
            }
        }
        while (!minHeap.isEmpty()) {
            temp = minHeap.poll();
            cur.next = temp;
            cur = cur.next;
            if (temp.next != null) {
                minHeap.offer(temp.next);
            }
        }
        cur.next = null;
        cur = head;
        head = head.next;
        cur.next = null;
        return head;
    }

    public ListNode mergeLists(ListNode[] lists) {
        /*
         * 还可以通过归并排序进行处理
         */
        return null;
    }
}
